package daruma.daruma;

import org.bukkit.Location;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.Objects;

public final class Daruma extends JavaPlugin implements Listener {
    static int turn = 0;
    static Location startpoint = null;
    static boolean move = false;
    static boolean check = false;
    static boolean game = false;
    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("Daruma")).setExecutor(new Daruma_commands());
        getServer().getPluginManager().registerEvents(new hantei(),this);
        getLogger().info("だるま起動しました");
        // Plugin startup logic
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
