package adhdmc.uselesslyhardcoded;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class UselesslyHardcoded extends JavaPlugin {
    public static Plugin plugin;
    @Override
    public void onEnable() {
        plugin = this;
        this.getCommand("claimkit").setExecutor(new KitClaimCommand());
        this.getCommand("vote").setExecutor(new VoteCommand());
        this.getCommand("rules").setExecutor(new RulesCommand());
        this.getCommand("livemap").setExecutor(new MapLinkCommand());
        this.getCommand("yeet").setExecutor(new YeetCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
