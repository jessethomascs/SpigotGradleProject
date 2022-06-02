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
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Locale;

public class ChatListener implements Listener {

    @EventHandler
    public void AsyncPlayerChatEvent(AsyncPlayerChatEvent chat) {
        if (chat.getMessage().equals("who's joe".toLowerCase(Locale.ROOT))) { // todo: this is a testing function, remove after use
            chat.getPlayer().sendMessage("original: " + chat.getMessage());
            chat.getPlayer().sendMessage("Your format: " + chat.getFormat());
            chat.getPlayer().sendMessage("Event name: " + chat.getEventName());
            chat.setMessage("JOE MAMA");
        }

        /// FUNCTION STRUCTURE ///
        /*
            Get player chat here, check for profanity/slurs/targeted harassment
        */

        /*public void army nation() lol
            Action for message here, ban for slur, warn, kick, etc.
        */

        /*public void army nation() lol
            Call 'UploadChat.java' and send to Discord (this being last is important)
        */
    }
}
