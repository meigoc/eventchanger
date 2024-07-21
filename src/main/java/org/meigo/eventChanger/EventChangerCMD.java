package org.meigo.eventChanger;

import org.bukkit.command.CommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class EventChangerCMD implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender == null)
            //
        if (command == null)
            //
        if (s == null)
            //
        if (args == null)
            //
        if (!sender.hasPermission("eventchanger.command")) {
            sender.sendMessage(ChatColor.GREEN + "! " + ChatColor.WHITE + "" + ChatColor.RED + "/eventchanger");
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(ChatColor.GREEN + "! " + ChatColor.WHITE + "/eventchanger reload");
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            EventChanger.getInstance().reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "! " + ChatColor.WHITE );
        } else {
            sender.sendMessage(ChatColor.GREEN + "! " + ChatColor.WHITE + "/eventchanger reload");
            return true;
        }
        return true;
    }
}
