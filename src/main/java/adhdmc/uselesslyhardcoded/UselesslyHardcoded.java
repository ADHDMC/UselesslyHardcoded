package adhdmc.uselesslyhardcoded;

import adhdmc.uselesslyhardcoded.commands.*;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class UselesslyHardcoded extends JavaPlugin {
    public static Plugin plugin;
    private static final MiniMessage miniMessage = MiniMessage.miniMessage();
    @Override
    public void onEnable() {
        plugin = this;
        this.getCommand("claimkit").setExecutor(new KitClaimCommand());
        this.getCommand("vote").setExecutor(new VoteCommand());
        this.getCommand("rules").setExecutor(new RulesCommand());
        this.getCommand("livemap").setExecutor(new MapLinkCommand());
        this.getServer().getPluginManager().registerEvents(new DiscordSRVListeners(), this);
    }

    public static MiniMessage getMiniMessage() {
        return miniMessage;
    }

}
