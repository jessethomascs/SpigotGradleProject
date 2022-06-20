package me.goodvibes.Configurations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.goodvibes.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class INTERNAL_WHITELIST implements Listener, CommandExecutor {

    Main plugin;
    public static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public Map<String, Object> map = new HashMap<>();


    private File configFile;
    private FileConfiguration editConfig;

    public INTERNAL_WHITELIST(Main plugin) throws FileNotFoundException {
        // Default constructor
        this.plugin = plugin;
        this.Setup();
    }

    // First time setup per load for file
    private void Setup() throws FileNotFoundException {
        configFile = new File(plugin.getDataFolder(), "INTERNAL_WHITELIST.json");
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            plugin.saveResource("INTERNAL_WHITELIST.json", false);
        } else {
            // The file already exists
            map = gson.fromJson(new FileReader(configFile), HashMap.class);
            try {
                editConfig.load(configFile);
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, @NonNull String[] args) {
        if (args.length < 1 || args[0].length() == 0) {
            String[] names = args[0].split(",");
            for (String name : names) {
                try {
                    AddToWhitelist(name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        return false;
    }

    private void AddToWhitelist(String name) throws IOException {
        // Internal whitelist
        Writer writer = new FileWriter(configFile, true);
        gson.toJson(name, writer);
        writer.flush();
        writer.close();

        // Vanilla whitelist
        OfflinePlayer offlinePlayer = Bukkit.getPlayer(UUID.fromString(name));
        Bukkit.getWhitelistedPlayers().add(offlinePlayer);
    }
}
