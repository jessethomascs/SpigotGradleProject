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
