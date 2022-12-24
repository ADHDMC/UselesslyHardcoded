package adhdmc.uselesslyhardcoded;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class RulesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendRichMessage("""
                <white>[<green>Server</green>]<dark_gray> »<reset> <gold><bold>Server Rules</gold>
                <u>[1]</u> <gray>Respect others</gray>
                <u>[2]</u> <gray>Do not grief</gray>
                <u>[3]</u> <gray>Do not scam</gray>
                <u>[4]</u> <gray>Do not intentionally cause lag</gray>
                <u>[5]</u> <gray>Do not exploit bugs or glitches</gray>
                <u>[6]</u> <gray>Do not use mods or hacks that give you an unfair advantage</gray>
                <yellow>Staff have full authority to remove players who do not comply with these rules""");
        return false;
    }
}
