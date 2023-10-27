package org.coleski123.grippysock;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatMessages {
    private final GrippySock plugin;

    public ChatMessages(GrippySock plugin) {
        this.plugin = plugin;
    }

    public void OnlyPlyFail(CommandSender sender){
        sender.sendMessage("Only players can use this command.");
    }

    public void PluginCmdUsage(CommandSender sender){
        String pluginPrefix = plugin.config.getString("Prefix").replace('&', '§');
        sender.sendMessage(pluginPrefix + " " + ChatColor.YELLOW + "Usage: /trollsounds <playername> <soundname>");
    }

    public void PluginCmdFail(CommandSender sender){
        Player player = (Player) sender;
        String PluginCmdFailMsg = plugin.config.getString("ChatMessages.PluginCommandFail").replace('&', '§');
        player.sendMessage(PluginCmdFailMsg);
    }

    public void SoundPlayed(CommandSender sender, String soundName){
        Player player = (Player) sender;
        String pluginPrefix = plugin.config.getString("Prefix").replace('&', '§');
        String SoundPlayedMessage = plugin.config.getString("ChatMessages.SoundPlayed")
                .replace('&', '§')
                .replace("{SOUND}", soundName);
        player.sendMessage(pluginPrefix + " " + SoundPlayedMessage);
    }

    public void PlyNotFound(CommandSender sender, String playerName){
        Player player = (Player) sender;
        String pluginPrefix = plugin.config.getString("Prefix").replace('&', '§');
        String PlyNotFoundMsg = plugin.config.getString("ChatMessages.PlayerNotFound")
                .replace('&', '§')
                .replace("{PLAYER}", playerName);
        player.sendMessage(pluginPrefix + " " + PlyNotFoundMsg);
    }

    public void SoundNameFail(CommandSender sender){
        Player player = (Player) sender;
        String pluginPrefix = plugin.config.getString("Prefix").replace('&', '§');
        String SoundNameFailMsg = plugin.config.getString("ChatMessages.SoundNameFail").replace('&', '§');
        player.sendMessage(pluginPrefix + " " + SoundNameFailMsg);
    }

    public void SoundsList(CommandSender sender){
        Player player = (Player) sender;
        player.sendMessage(ChatColor.GREEN + "Available sounds:");
        player.sendMessage(ChatColor.YELLOW + "creeperhiss");
        player.sendMessage(ChatColor.YELLOW + "zombie");
        player.sendMessage(ChatColor.YELLOW + "enderman");
        player.sendMessage(ChatColor.YELLOW + "lightning");
        player.sendMessage(ChatColor.YELLOW + "horn1");
        player.sendMessage(ChatColor.YELLOW + "horn2");
        player.sendMessage(ChatColor.YELLOW + "horn3");
        player.sendMessage(ChatColor.YELLOW + "horn4");
        player.sendMessage(ChatColor.YELLOW + "cave");
        player.sendMessage(ChatColor.YELLOW + "damage");
        player.sendMessage(ChatColor.YELLOW + "door");
        player.sendMessage(ChatColor.YELLOW + "lever");
        player.sendMessage(ChatColor.YELLOW + "piston");
        player.sendMessage(ChatColor.YELLOW + "bell");
    }

    public void ReloadConfigMessage(CommandSender sender){
        Player player = (Player) sender;
        String pluginPrefix = plugin.config.getString("Prefix").replace('&', '§');
        String ReloadConfigMsg = plugin.config.getString("ChatMessages.ReloadConfig").replace('&', '§');
        player.sendMessage(pluginPrefix + " " + ReloadConfigMsg);
    }
}
