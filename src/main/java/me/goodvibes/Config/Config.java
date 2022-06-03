/*
Class: Config.java
permission: NOT APPLICABLE - UTILITY CLASS
Author: Jesse Thomas, jesse.thomas@snhu.edu
Hierarchy: NOT APPLICABLE - UTILITY CLASS
Purpose: Handles everything configuration wise. Dependency injection of Main is also held here, easily tracked more.
*/

package me.goodvibes.Config;

import me.goodvibes.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class Config implements Listener {
    public Config(Main plugin) {
        plugin.saveDefaultConfig();
        String temp = plugin.getCustomConfiguration().getString("version");
        Bukkit.broadcastMessage("[GVO-PLUGIN] - " + temp);
    }


}
