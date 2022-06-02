/*
Class: cKick.java
permission: GoodVibesOnly.BanManager.cKick
Author: Jesse Thomas, jesse.thomas@snhu.edu
Hierarchy: BanManager subclass
Purpose: Kicks a player from the server
*/

package me.goodvibes.commands.BanManager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

public class cKick implements CommandExecutor {

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, @NonNull String[] args) {
        if (args.length < 1 || args[0].length() == 0) { // No target given
            sender.sendMessage("Invalid syntax. Usage: /kick <target> <reason>");
            return false;
        }

        Player target = Bukkit.getPlayerExact(args[0]);
        String reason = (args[1].length() < 1) ? ("Kicked by operator") : args[1];
        if (target != null) {
            target.kickPlayer(reason);
        } else {
            sender.sendMessage("Target is not online.");
        }
        return true;
    }
}
