/*
Class: ChatListener.java
permission: NOT APPLICABLE - UTILITY CLASS
Author: Jesse Thomas, jesse.thomas@snhu.edu
Hierarchy: NOT APPLICABLE - UTILITY CLASS
Purpose: Monitors in the in-game chat. Part of the clubs effort to keep it clean and safe. Todo: Add more here
*/

package me.goodvibes.ChatFilter;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        //event.setJoinMessage(); Implement Config SQL Option
        Bukkit.broadcastMessage("Welcome " + event.getPlayer().getDisplayName() + " to GoodVibesOnly!");
    }
}
