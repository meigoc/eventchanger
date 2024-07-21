package org.meigo.eventChanger;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import java.util.Objects;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

public class EventsC implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        FileConfiguration config = EventChanger.getInstance().getConfig();
        if (((String)Objects.<String>requireNonNull(config.getString("Switches.Events.JoinMessageIsEnabled"))).equalsIgnoreCase("true")) {
            String message = config.getString("Events.Messages.JoinMessage");
            message = PlaceholderAPI.setPlaceholders(event.getPlayer(), Objects.<String>requireNonNull(message));
            message = ChatColor.translateAlternateColorCodes('&', message);
            event.setJoinMessage(message);
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        FileConfiguration config = EventChanger.getInstance().getConfig();
        if (config.getString("Events.Other.PlayerMove.Can").equalsIgnoreCase("false")) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent player) {
        if (((String)Objects.<String>requireNonNull(EventChanger.getInstance().getConfig().getString("Switches.Events.QuitMessageIsEnabled"))).equalsIgnoreCase("true")) {
            if (((String)Objects.<String>requireNonNull(EventChanger.getInstance().getConfig().getString("Events.Messages.QuitMessage"))).equalsIgnoreCase("none")) {
                player.setQuitMessage(player.getQuitMessage());
            } else {
                String text = ((String)Objects.<String>requireNonNull(EventChanger.getInstance().getConfig().getString("Events.Messages.QuitMessage"))).replace("{player}", player.getPlayer().getName());
                String message = PlaceholderAPI.setPlaceholders(player.getPlayer(), text);
                message = ChatColor.translateAlternateColorCodes('&', message);
                player.setQuitMessage(message);
            }
        } else {
            player.quitMessage();
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent player) {
        if (((String)Objects.<String>requireNonNull(player.getDeathMessage())).equals(((Player)Objects.<Player>requireNonNull(player.getEntity().getPlayer())).getName() + " fell out of the world")) {
            String text = ((String)Objects.<String>requireNonNull(EventChanger.getInstance().getConfig().getString("Events.Messages.DeathMessages.World"))).replace("{player}", player.getEntity().getPlayer().getName());
            String message = PlaceholderAPI.setPlaceholders(player.getEntity().getPlayer(), text);
            message = ChatColor.translateAlternateColorCodes('&', message);
            player.setDeathMessage(message);
        }
        if (((String)Objects.<String>requireNonNull(player.getDeathMessage())).equals(((Player)Objects.<Player>requireNonNull(player.getEntity().getPlayer())).getName() + " fell from a high place")) {
            String text = ((String)Objects.<String>requireNonNull(EventChanger.getInstance().getConfig().getString("Events.Messages.DeathMessages.High place"))).replace("{player}", player.getEntity().getPlayer().getName());
            String message = PlaceholderAPI.setPlaceholders(player.getEntity().getPlayer(), text);
            message = ChatColor.translateAlternateColorCodes('&', message);
            player.setDeathMessage(message);
        } else {
            player.setDeathMessage(player.getDeathMessage());
        }
    }

    @EventHandler
    public void onChat(PlayerChatEvent player) {
        if (((String)Objects.<String>requireNonNull(EventChanger.getInstance().getConfig().getString("Switches.Events.Chat.CustomMessageIsEnabled"))).equals("true")) {
            String message = Objects.<String>requireNonNull(((String)Objects.<String>requireNonNull(EventChanger.getInstance().getConfig().getString("Events.Messages.ChatMessage"))).replace("{player}", player.getPlayer().getName()).replace("{message}", ""));
            message = PlaceholderAPI.setPlaceholders(player.getPlayer(), message);
            message = ChatColor.translateAlternateColorCodes('&', message);
            String playermessage = player.getMessage();
            player.setFormat(message + playermessage);
        } else {
            player.setCancelled(false);
        }
    }

    @EventHandler
    public void onJump(PlayerJumpEvent event) {
        FileConfiguration config = EventChanger.getInstance().getConfig();
        if (config.getString("Events.Other.PlayerJump.Can").equalsIgnoreCase("false")) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onSprinting(PlayerToggleSprintEvent event) {
        FileConfiguration config = EventChanger.getInstance().getConfig();
        if (config.getString("Events.Other.PlayerSprinting.Kill").equalsIgnoreCase("true")) {
            event.getPlayer().setGameMode(GameMode.SURVIVAL);
            event.getPlayer().damage(event.getPlayer().getHealth());
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onSneaking(PlayerToggleSneakEvent event) {
        FileConfiguration config = EventChanger.getInstance().getConfig();
        if (config.getString("Events.Other.PlayerSneaking.Kill").equalsIgnoreCase("true")) {
            event.getPlayer().setGameMode(GameMode.SURVIVAL);
            event.getPlayer().damage(event.getPlayer().getHealth());
        } else {
            event.setCancelled(false);
        }
    }
}
