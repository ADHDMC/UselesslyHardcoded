package adhdmc.uselesslyhardcoded.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class MapLinkCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendRichMessage("<white>[<green>Server</green>]<dark_gray> »<reset> <yellow>View our livemap at <#519efc><click:open_url:'https://map.creators-smp.com/'><hover:show_text:'<green>Click to go to our map!'>https://map.creators-smp.com/</hover></click>");
        return false;
    }
}
