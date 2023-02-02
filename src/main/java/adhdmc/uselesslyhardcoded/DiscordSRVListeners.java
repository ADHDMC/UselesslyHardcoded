package adhdmc.uselesslyhardcoded;

import com.vexsoftware.votifier.model.VotifierEvent;
import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.dependencies.jda.api.entities.TextChannel;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import com.vexsoftware.votifier.model.Vote;
import org.bukkit.plugin.Plugin;

public class DiscordSRVListeners implements Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onVote(VotifierEvent voteEvent) {
        String votesLeft = "%voteparty_votes_required_party%";
        votesLeft = PlaceholderAPI.setPlaceholders(null, votesLeft);
        if (!(votesLeft.equals("12") || votesLeft.equals("8") || votesLeft.equals("4"))) {
            return;
        }
        CommandSender sender = UselesslyHardcoded.plugin.getServer().getConsoleSender();
        String message = "discord broadcast Hey <@&1066984433925750844>! A vote party is coming up in " + votesLeft + " votes! Hurry in if you want to make the vote party!";
        UselesslyHardcoded.plugin.getServer().dispatchCommand(sender, message);
    }
}
