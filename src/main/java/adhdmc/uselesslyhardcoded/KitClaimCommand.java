package adhdmc.uselesslyhardcoded;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class KitClaimCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendRichMessage("<red>Only players can run this command");
            return false;
        }
        ItemStack goldShovel = new ItemStack(Material.GOLDEN_SHOVEL, 1);
        if (player.getInventory().addItem(goldShovel).isEmpty()) {
            sender.sendRichMessage("<white>[<green>Server</green>]<dark_gray> »<reset> <yellow>You have been given a claim shovel");
        } else {
            player.sendRichMessage("<white>[<green>Server</green>]<dark_gray> » <red>There was no room in your inventory for a golden shovel, please make space.");
        }
        return true;
    }
}
