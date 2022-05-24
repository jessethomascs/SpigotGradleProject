import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getLogger().info("GVO-PLUGIN: Plugin established.");
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        this.getCommand("BanManager").setExecutor(new BanManager());
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("GVO-Plugin: Plugin disestablished.");
    }

}
