package me.goodvibes;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CustomEventExample extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    private final String playerName;

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public CustomEventExample(String playerName) {
        this.playerName = playerName;
    }


    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public String getPlayerName() {
        return this.playerName;
    }
}
