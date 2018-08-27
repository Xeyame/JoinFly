package me.xeya.joinfly;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class joinFly extends JavaPlugin implements Listener {

    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        //set up the config
        config.addDefault("permission", "joinfly.fly");
        config.options().copyDefaults(true);
        saveConfig();
        //register event
        getServer().getPluginManager().registerEvents(this, this);
        this.getConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (e.getPlayer().hasPermission(config.getString("permission"))) {
            e.getPlayer().setAllowFlight(true);
        } else {
            e.getPlayer().setAllowFlight(false);
        }
    }
}
