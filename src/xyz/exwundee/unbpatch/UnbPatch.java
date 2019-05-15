package xyz.exwundee.unbpatch;

// happy, riga?

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.exwundee.unbpatch.events.WalkEvent;

/**
 **     Created by x1D on 05-15-2019.
 **/
public class UnbPatch extends JavaPlugin {

    Plugin plugin;

    public void onEnable() {
        plugin = this;
        registerEvents(this, new WalkEvent());
    }

    public void registerEvents(Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

}
