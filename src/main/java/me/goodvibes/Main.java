package me.goodvibes;

import me.goodvibes.ChatFilter.ChatListener;
import me.goodvibes.Config.Config;
import me.goodvibes.Events.UnknownPlayers;
import me.goodvibes.commands.BanManager.cBan;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {
    private File configurationFile;
    private FileConfiguration customConfiguration;

    @Override
    public void onEnable() {
        // Setup before listeners
        createCustomConfiguration();
        saveDefaultConfig();

        // Listeners
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new UnknownPlayers(), this);
        getServer().getPluginManager().registerEvents(new Config(this), this);

        // Command registering
        this.getCommand("cBan").setExecutor(new cBan());

        // 10-4 print
        Bukkit.getLogger().info("GVO-PLUGIN: Plugin established.");
    }

    public FileConfiguration getCustomConfiguration() {
        return this.customConfiguration;
    }

    private void createCustomConfiguration() {
        configurationFile = new File(getDataFolder(), "config.yml");
        if (!configurationFile.exists()) {
            configurationFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }

        customConfiguration = new YamlConfiguration();
        try {
            customConfiguration.load(configurationFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("GVO-Plugin: Plugin disestablished.");
    }

}
