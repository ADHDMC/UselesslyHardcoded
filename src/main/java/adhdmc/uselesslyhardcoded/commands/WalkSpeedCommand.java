package adhdmc.uselesslyhardcoded.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WalkSpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("This command can only be run by a player");
            return false;
        }
        if (!player.hasPermission("uhc.walkspeed")) {
            player.sendRichMessage("<red>You do not have permission for this command");
            return false;
        }
        if (args.length == 0) {
            float flyspeed = player.getWalkSpeed();
            player.sendRichMessage("<white>[<green>Server</green>]<dark_gray> » <green>Your current walkspeed is " + flyspeed);
            return true;
        }
        if (args[0].equalsIgnoreCase("reset")) {
            player.setWalkSpeed(0.2f);
            player.sendRichMessage("<white>[<green>Server</green>]<dark_gray> » <gray>Your walkspeed has been reset");
            return true;
        }
        try {
            float speed = Float.parseFloat(args[0]);
        } catch (NumberFormatException e) {
            player.sendRichMessage("<red>Please enter a number between -10 and 10");
            return false;
        }
        float speed = Float.parseFloat(args[0]);
        speed = speed/10;
        if (!((speed > -1) && (speed < 1))) {
            player.sendRichMessage("<red>Please enter a number between -10 and 10");
            return false;
        }
        player.setWalkSpeed(speed);
        player.sendRichMessage("<white>[<green>Server</green>]<dark_gray> »<green> Walkspeed set to " + speed);
        return false;
    }
}
