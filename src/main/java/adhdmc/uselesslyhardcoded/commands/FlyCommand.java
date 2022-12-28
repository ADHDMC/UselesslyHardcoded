package adhdmc.uselesslyhardcoded.commands;

import adhdmc.uselesslyhardcoded.UselesslyHardcoded;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {
    public static NamespacedKey flyStatus = new NamespacedKey(UselesslyHardcoded.plugin, "fly");
    byte on = 1;
    byte off = 0;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can run this command");
            return false;
        }
        if (!player.hasPermission("uhc.fly")){
            sender.sendRichMessage("<red>You do not have permission for this command");
            return false;
        }
        PersistentDataContainer playerPDC = player.getPersistentDataContainer();
        Byte flyState = playerPDC.get(flyStatus, PersistentDataType.BYTE);
        if (flyState == null || flyState == off) {
            playerPDC.set(flyStatus, PersistentDataType.BYTE, on);
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendRichMessage("<white>[<green>Server</green>]<dark_gray> » <green>Flight enabled");
            return true;
        }
        if (flyState == on) {
            playerPDC.set(flyStatus, PersistentDataType.BYTE, off);
            player.setAllowFlight(false);
            player.setFlying(false);
            player.sendRichMessage("<white>[<green>Server</green>]<dark_gray> » <gray>Flight disabled");
            return true;
        }
        return false;
    }
}
