package adhdmc.uselesslyhardcoded;

import adhdmc.uselesslyhardcoded.commands.FlyCommand;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class LoginListener implements Listener {
    NamespacedKey flyStatus = FlyCommand.flyStatus;
    byte on = 1;
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent loginEvent){
        Player player = loginEvent.getPlayer();
        PersistentDataContainer playerPDC = player.getPersistentDataContainer();
        Byte playerFlyState = playerPDC.get(flyStatus, PersistentDataType.BYTE);
        if (playerFlyState != null
                && playerFlyState == on
                && player.hasPermission("uhc.fly")){
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendRichMessage("<white>[<green>Server</green>]<dark_gray> » <green>Flight enabled");
        }
    }
}
