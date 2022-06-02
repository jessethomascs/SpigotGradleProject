/*
Class: cUnban.java
permission: GoodVibesOnly.BanManager.cUnban
Author: Jesse Thomas, jesse.thomas@snhu.edu
Hierarchy: BanManager subclass
Purpose: Unbans a player from the server. *Does not remove info in database
*/

package me.goodvibes.commands.BanManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

public class cUnban implements CommandExecutor {

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, @NonNull String[] args) {
        if (sender instanceof Player player) {

        }
        return true;
    }
}
