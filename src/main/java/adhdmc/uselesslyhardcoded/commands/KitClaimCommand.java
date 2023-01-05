package adhdmc.uselesslyhardcoded.commands;

import adhdmc.uselesslyhardcoded.UselesslyHardcoded;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class KitClaimCommand implements CommandExecutor {
    NamespacedKey timer = new NamespacedKey(UselesslyHardcoded.plugin, "claimkit-time");
    private static final MiniMessage miniMessage = UselesslyHardcoded.getMiniMessage();
    Component goldShovelName = miniMessage.deserialize("<reset><gradient:gold:yellow>Claim Shovel");
    Component goldShovelLore1 = miniMessage.deserialize("<reset><rainbow>------------");
    Component goldShovelLore2 = miniMessage.deserialize("<reset><gray>Right click opposite");
    Component goldShovelLore3 = miniMessage.deserialize("<reset><gray>corners of a");
    Component goldShovelLore4 = miniMessage.deserialize("<reset><gray>rectangle to");
    Component goldShovelLore5 = miniMessage.deserialize("<reset><gray>claim that area");
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendRichMessage("<red>Only players can run this command");
            return false;
        }
        PersistentDataContainer playerPDC = player.getPersistentDataContainer();
        Long timeStamp = playerPDC.get(timer, PersistentDataType.LONG);
        // If they have used the command before...
        if (timeStamp != null) {
            int cooldownTime = 1800000;                                 // Time in Milliseconds
            long timeDelta = System.currentTimeMillis() - timeStamp;    // Time Elapsed since Last Used
            // Check how long since they last used the command...
            if (timeDelta <= cooldownTime) {
                int timeSeconds = ((int)(cooldownTime-timeDelta))/1000;
                player.sendRichMessage("<white>[<green>Server</green>]<dark_gray> »<reset> That command is currently on cooldown (" + timeSeconds + "s). You will have to wait to use this command again");
                return false;
            }
        }
        // Give player shovel.
        ItemStack goldShovel = new ItemStack(Material.GOLDEN_SHOVEL, 1);
        ItemMeta meta = goldShovel.getItemMeta();
        meta.displayName(goldShovelName);
        meta.lore(List.of(goldShovelLore1, goldShovelLore2, goldShovelLore3, goldShovelLore4, goldShovelLore5));
        goldShovel.setItemMeta(meta);
        if (player.getInventory().addItem(goldShovel).isEmpty()) {
            sender.sendRichMessage("<white>[<green>Server</green>]<dark_gray> »<reset> <yellow>You have been given a claim shovel");
            playerPDC.set(timer, PersistentDataType.LONG, System.currentTimeMillis());
        } else {
            player.sendRichMessage("<white>[<green>Server</green>]<dark_gray> » <red>There was no room in your inventory for a golden shovel, please make space.");
        }
        return true;
    }
}
