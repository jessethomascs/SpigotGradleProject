package me.goodvibes;

import me.goodvibes.ChatFilter.ChatListener;
import me.goodvibes.Events.UnknownPlayers;
import me.goodvibes.commands.BanManager.cBan;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getLogger().info("GVO-PLUGIN: Plugin established.");
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new UnknownPlayers(), this);
        this.getCommand("cBan").setExecutor(new cBan());
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("GVO-Plugin: Plugin disestablished.");
    }

}
