package adhdmc.uselesslyhardcoded.commands;

import adhdmc.uselesslyhardcoded.UselesslyHardcoded;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class RenameCommand implements CommandExecutor {
    MiniMessage miniMessage = UselesslyHardcoded.getMiniMessage();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only a player can run this command");
            return false;
        }
        if (!player.hasPermission("uhc.rename")) {
            player.sendRichMessage("<red>You do not have permission to run this command");
            return false;
        }
        if (args.length == 0) {
            player.sendRichMessage("<red>No arguments provided, please try again and write what you want to name the item");
            return false;
        }
        if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
            player.sendRichMessage("<white>[<green>Server</green>]<dark_gray> » <gray>You need to hold something to rename!");
            return false;
        }
        String renameString = Arrays.toString(args);
        Component renameComponent = miniMessage.deserialize(renameString);
        ItemStack itemToRename = player.getInventory().getItemInMainHand();
        itemToRename.getItemMeta().displayName(renameComponent);
        player.sendRichMessage("Item has been renamed to " + renameString);
        return true;
    }
}
