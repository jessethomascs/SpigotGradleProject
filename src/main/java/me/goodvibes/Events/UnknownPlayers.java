/*
Class: UnknownPlayers.java
permission: NOT APPLICABLE - UTILITY CLASS
Author: Jesse Thomas, jesse.thomas@snhu.edu
Hierarchy: NOT APPLICABLE - UTILITY CLASS
Purpose: Strictly for players attempting to log in who aren't on whitelist. Bans all players unless on whitelist.
*/

package me.goodvibes.Events;

import me.goodvibes.Configurations.Config;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class UnknownPlayers implements Listener {

    Config config;

    public UnknownPlayers(Config config) {
        // Default constructor
        this.config = config;
    }

    private String[] internalWhitelist() {
        String names = config.retrieveString("internalWhitelist");
        Bukkit.getConsoleSender().sendMessage("[INTERNAL WHITELIST VERIFICATION]: " + names);
        return names.split("[,]", 0);
    }

    private boolean searchPlayer(String playerName) {
        // Check if player is on internal whitelist
        String[] names = internalWhitelist();

        // todo: Turn this into a kvp for faster searching
        for (int i = 0; i < names.length - 1; i++) {
            if (names[i].equals(playerName)) {
                return true;
            }
        }
        return false;
    }



    @EventHandler
    public void AsyncPlayerPreLoginEvent(AsyncPlayerPreLoginEvent event) {
        /*
            1 - Get whitelists (Bukkit & server-side only)
            2 - Ban the player if not on whitelist, their IP, and save their credentials to unique database
        */

        if (Bukkit.getWhitelistedPlayers().contains(Bukkit.getOfflinePlayer(event.getUniqueId())) && searchPlayer(event.getName())) {
            Bukkit.getConsoleSender().sendMessage("[WATCHDOG] = Player logging in. Display name: " + event.getName() + ". With InetAddress: " + event.getAddress().toString());
            return;
        } else {
            // Ban player
            String reason = "Hey! Sorry about this, but this is a schools club server! Club members only unfortunately!\n";
            String source = "Watchdog";
            String ipAddress = event.getAddress().toString().substring(1);
            Bukkit.getBanList(BanList.Type.NAME).addBan(event.getName(), reason, null, source);
            Bukkit.banIP(ipAddress);

            // Log to console
            Bukkit.getConsoleSender().sendMessage("\n\n\n[WATCHDOG] - Banned player " + event.getName() + " with address " + ipAddress + ". If this was an error, please whitelist prior to sharing our clubs IP address.\n");
        }
    }
}
