package me.goodvibes.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

public class TeleportManager implements CommandExecutor {

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, @NonNull String[] args) {
        if (sender instanceof Player player) {
            if (command.getName().equals("TeleportManager")) {
                player.sendMessage("TeleportManager: Version 1.0");
                player.sendMessage("----------------------------");
                player.sendMessage("/TeleportManager: Gives overview");
                player.sendMessage("/tpa: Teleport request a player");
                return true;
            } else if (command.getName().equals("tpa")) {
                return true;
            } else {
                player.sendMessage("Your command entered was: " + command.getName());
                return true;
            }
        }
        return false;
    }
}
