/*
Class: cKick.java
permission: GoodVibesOnly.BanManager.cKick
Author: Jesse Thomas, jesse.thomas@snhu.edu
Hierarchy: BanManager subclass
Purpose: Kicks a player from the server, logging incident report for kick to database
*/

package me.goodvibes.commands.BanManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

public class cKick implements CommandExecutor {

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, @NonNull String[] args) {
        if (sender instanceof Player player) {

        }
        return true;
    }
}
