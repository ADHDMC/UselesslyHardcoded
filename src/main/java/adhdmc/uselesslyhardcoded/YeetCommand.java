package adhdmc.uselesslyhardcoded;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class YeetCommand implements CommandExecutor {
    PotionEffect yeetBlindEffect = new PotionEffect(PotionEffectType.BLINDNESS, 200, 10, false, false, false);
    PotionEffect yeetFireResEffect = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200, 10, false, false, false);
    PotionEffect yeetWaterBreathing = new PotionEffect(PotionEffectType.WATER_BREATHING, 200,10, false,false,false);
    PotionEffect yeetRegen = new PotionEffect(PotionEffectType.REGENERATION, 200, 10, false, false, false);
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String arg = args[0];
        if (UselesslyHardcoded.plugin.getServer().getPlayer(arg) == null) {
            sender.sendRichMessage("<red>Player not found");
            return false;
        }
        Player player = UselesslyHardcoded.plugin.getServer().getPlayer(arg);
        if (player != null) {
            player.addPotionEffects(List.of(yeetBlindEffect, yeetRegen, yeetFireResEffect, yeetWaterBreathing));
            sender.sendRichMessage("<green>player has been yeeted");
            return true;
        }
        return false;
    }
}
