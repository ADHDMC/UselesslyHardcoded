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
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class KitClaimCommand implements CommandExecutor {
    NamespacedKey timer = new NamespacedKey(UselesslyHardcoded.plugin, "claimkit-time");
    private static final MiniMessage miniMessage = UselesslyHardcoded.getMiniMessage();
    Component goldShovelName = miniMessage.deserialize("<gradient:gold:yellow>Claim Shovel");
    Component goldShovelLore = miniMessage.deserialize("""
            <gray>Right click the
            opposite corners of
            the area you would
            like to claim!""");
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendRichMessage("<red>Only players can run this command");
            return false;
        }
        PersistentDataContainer playerPDC = player.getPersistentDataContainer();
        Integer timeStamp = playerPDC.get(timer, PersistentDataType.INTEGER);
        int serverTick = UselesslyHardcoded.plugin.getServer().getCurrentTick();
        ItemStack goldShovel = new ItemStack(Material.GOLDEN_SHOVEL, 1);
        goldShovel.getItemMeta().displayName(goldShovelName);
        goldShovel.getItemMeta().lore(List.of(goldShovelLore));
        if (timeStamp != null && timeStamp > serverTick) {
            player.sendRichMessage("<white>[<green>Server</green>]<dark_gray> »<reset> That command is currently on cooldown. You will have to wait to use this command again");
            return false;
        }
        if (player.getInventory().addItem(goldShovel).isEmpty()) {
            sender.sendRichMessage("<white>[<green>Server</green>]<dark_gray> »<reset> <yellow>You have been given a claim shovel");
            playerPDC.set(timer, PersistentDataType.INTEGER, serverTick);
        } else {
            player.sendRichMessage("<white>[<green>Server</green>]<dark_gray> » <red>There was no room in your inventory for a golden shovel, please make space.");
        }
        return true;
    }
}
