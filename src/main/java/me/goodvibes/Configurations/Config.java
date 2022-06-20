/*
Class: Config.java
permission: NOT APPLICABLE - UTILITY CLASS
Author: Jesse Thomas, jesse.thomas@snhu.edu
Hierarchy: NOT APPLICABLE - UTILITY CLASS
Purpose: Handles everything configuration wise. Dependency injection of Main is also held here, easily tracked more.
*/

package me.goodvibes.Configurations;

import me.goodvibes.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;

public class Config implements Listener {

    Main plugin;
    FileConfiguration configFile;

    public Config(Main plugin, FileConfiguration configFile) {
        this.plugin = plugin;
        this.configFile = configFile;

        plugin.saveDefaultConfig();
        String temp = plugin.getCustomConfiguration().getString("version");
        Bukkit.broadcastMessage("[GVO-PLUGIN] - " + temp);
    }

    public String retrieveString(String configLineName) {
        return configFile.getString("internalWhitelist");
    }

    public boolean storeNewLine(String info) {
        return false;
    }
}
