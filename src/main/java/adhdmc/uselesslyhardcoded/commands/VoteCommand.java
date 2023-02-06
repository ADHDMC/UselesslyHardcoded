package adhdmc.uselesslyhardcoded.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class VoteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendRichMessage("""
                                  <bold><gold>Help our server grow by voting for us!<reset>
                                  <aqua>Click these links and write your username in the vote box, and  hit 'vote'<reset>
                                  <click:open_url:'https://www.planetminecraft.com/server/creatorssmp/vote/'><hover:show_text:'<aqua>https://www.planetminecraft.com/server/creatorssmp/vote/'><gray>• <#519efc>Planet Minecraft</hover></click><reset>
                                  <click:open_url:'https://minecraft-mp.com/server/313337/vote/'><hover:show_text:'<aqua>https://minecraft-mp.com/server/313337/vote/'><gray>• <#519efc>Minecraft-MP</hover></click><reset>
                                  <click:open_url:'https://minecraftservers.org/vote/644666/'><hover:show_text:'<aqua>https://minecraftservers.org/vote/644666/'><gray>• <#519efc>MinecraftServers</hover></click><reset>
                                  <click:open_url:'https://minecraft-server-list.com/server/492776/vote/'><hover:show_text:'<aqua>https://minecraft-server-list.com/server/492776/vote/'><gray>• <#519efc>Minecraft Server List</hover></click><reset>
                                  <click:open_url:'https://minecraft.buzz/vote/6869'><hover:show_text:'<aqua>https://minecraft.buzz/vote/6869'><gray>• <#519efc>Minecraft Buzz</hover></click><reset>
                                  <click:open_url:'https://servers-minecraft.net/server-creatorssmp.23554'><hover:show_text:'<aqua>https://servers-minecraft.net/server-creatorssmp.23554'><gray>• <#519efc>Servers-Minecraft</hover></click><reset>
                                  <yellow>Rewards for each vote are <aqua>❖ 4 Diamonds</aqua> and <green>◎ 10 Credits
                                  <gray>Note: Be sure to keep the tabs open until the site says successful, if you close the tabs before the vote goes through, your rewards may not properly register.""");
        return true;
    }
}
