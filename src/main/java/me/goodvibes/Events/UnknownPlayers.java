/*
Class: UnknownPlayers.java
permission: NOT APPLICABLE - UTILITY CLASS
Author: Jesse Thomas, jesse.thomas@snhu.edu
Hierarchy: NOT APPLICABLE - UTILITY CLASS
Purpose: Strictly for players attempting to log in who aren't on whitelist. Bans all players unless on whitelist.
*/

package me.goodvibes.Events;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.net.InetAddress;
import java.util.UUID;

public class UnknownPlayers implements Listener {
    @EventHandler
    public void AsyncPlayerPreLoginEvent(AsyncPlayerPreLoginEvent event) {
        /*
            1 - Get whitelist
            2 - Ban the player if not on whitelist, their IP, and save their credentials to unique database
        */

        if (Bukkit.getWhitelistedPlayers().contains(Bukkit.getOfflinePlayer(event.getUniqueId()))) {
            Bukkit.broadcastMessage("[WATCHDOG] = Player logging in. Display name: " + event.getName() + ". With InetAddress: " + event.getAddress().toString());
            return;
        } else {
            // Ban player
            String reason = "Hey! Sorry about this, but this is a schools club server! Club members only unfortunately!";
            String source = "Watchdog";
            String ipAddress = event.getAddress().toString().substring(1);
            Bukkit.getBanList(BanList.Type.NAME).addBan(event.getName(), reason, null, source);
            Bukkit.banIP(ipAddress);

            // Log to console
            Bukkit.broadcastMessage("\n\n\n[WATCHDOG] - Banned player " + event.getName() + ". If this was an error, please whitelist prior to sharing our clubs IP address.");
        }
    }
}
