package org.meigo.eventChanger;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class EventChanger extends JavaPlugin {
    private static EventChanger instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getPluginManager().registerEvents(new EventsC(), (Plugin)this);
        } else {
            getLogger().warning("(HOOK) PlaceholderAPI plugin not found.");
            getLogger().warning(" |");
            getLogger().warning(" | INSTALL PlaceholderAPI FOR THE PLUGIN TO WORK");
            getLogger().warning(" | https://github.com/PlaceholderAPI/PlaceholderAPI");
            getLogger().warning(" |");
            Bukkit.getPluginManager().disablePlugin((Plugin)this);
        }
        instance = this;
        saveDefaultConfig();
        reloadConfig();
        ((PluginCommand)Objects.<PluginCommand>requireNonNull(getCommand("eventchanger"))).setExecutor(new EventChangerCMD());
        Bukkit.getPluginManager().registerEvents(new EventsC(), (Plugin)this);
    }

    public static EventChanger getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
