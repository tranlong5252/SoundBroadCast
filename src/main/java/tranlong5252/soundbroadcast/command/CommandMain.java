package tranlong5252.soundbroadcast.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import tranlong5252.soundbroadcast.SoundBroadcast;
import tranlong5252.soundbroadcast.tasks.Trigger;

public class CommandMain implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("sbc")) {
            if (args.length <= 0) {
                sender.sendMessage("§7/sbc <tin nhắn>");
                return false;
            }
            StringBuilder message = new StringBuilder();
            for (String arg : args) {
                message.append(arg).append(" ");
            }
            new Trigger(ChatColor.translateAlternateColorCodes('&', message.toString()), 5)
                    .runTaskTimer(SoundBroadcast.getInstance(), 0, 7);
        }
        return false;
    }
}
