package adhdmc.uselesslyhardcoded;

import adhdmc.uselesslyhardcoded.commands.FlyCommand;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class FlyListeners implements Listener {
    NamespacedKey flyStatus = FlyCommand.flyStatus;
    byte on = 1;
    byte off = 0;
    @EventHandler
    public void onPlayerLogin(PlayerJoinEvent joinEvent){
        Player player = joinEvent.getPlayer();
        PersistentDataContainer playerPDC = player.getPersistentDataContainer();
        Bukkit.getScheduler().runTaskLater(UselesslyHardcoded.plugin, ()-> {
            Byte playerFlyState = playerPDC.getOrDefault(flyStatus, PersistentDataType.BYTE, off);
            if (playerFlyState == on
                    && player.hasPermission("uhc.fly")) {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendRichMessage("<white>[<green>Server</green>]<dark_gray> » <green>Flight enabled");
            }
        }, 4);
    }

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent worldEvent) {
        Player player = worldEvent.getPlayer();
        PersistentDataContainer playerPDC = player.getPersistentDataContainer();
        Byte playerFlyState = playerPDC.getOrDefault(flyStatus, PersistentDataType.BYTE, off);
        if (playerFlyState == on
                && player.hasPermission("uhc.fly")) {
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendRichMessage("<white>[<green>Server</green>]<dark_gray> » <green>Flight enabled");
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent respawnEvent) {
        Player player = respawnEvent.getPlayer();
        PersistentDataContainer playerPDC = player.getPersistentDataContainer();
        Byte playerFlyState = playerPDC.getOrDefault(flyStatus, PersistentDataType.BYTE, off);
        if (playerFlyState == on
                && player.hasPermission("uhc.fly")) {
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendRichMessage("<white>[<green>Server</green>]<dark_gray> » <green>Flight enabled");
        }
    }

    @EventHandler
    public void onGamemodeChange(PlayerGameModeChangeEvent gameModeChangeEvent) {
        Player player = gameModeChangeEvent.getPlayer();
        PersistentDataContainer playerPDC = player.getPersistentDataContainer();
        Byte playerFlyState = playerPDC.getOrDefault(flyStatus, PersistentDataType.BYTE, off);
        if (playerFlyState == on
                && player.hasPermission("uhc.fly")) {
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendRichMessage("<white>[<green>Server</green>]<dark_gray> » <green>Flight enabled");
        }
    }
}
