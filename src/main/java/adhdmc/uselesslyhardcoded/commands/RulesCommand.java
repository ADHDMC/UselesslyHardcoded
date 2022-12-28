package adhdmc.uselesslyhardcoded.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class RulesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendRichMessage("""
                <white>[<green>Server</green>]<dark_gray> »<reset> <gold><bold>Server Rules</gold>
                [1] <gray>Respect others</gray>
                [2] <gray>Do not grief</gray>
                [3] <gray>Do not scam</gray>
                [4] <gray>Do not intentionally cause lag</gray>
                [5] <gray>Do not exploit bugs or glitches</gray>
                [6] <gray>Do not use mods or hacks that give you an unfair advantage</gray>
                <yellow>Staff have full authority to remove players who do not comply with these rules""");
        return false;
    }
}
