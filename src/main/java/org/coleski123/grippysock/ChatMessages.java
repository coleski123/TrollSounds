package org.coleski123.grippysock;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class ChatMessages {
    private final GrippySock plugin;

    public ChatMessages(GrippySock plugin) {
        this.plugin = plugin;
    }

    public String Prefix(){
        return plugin.config.getString("Prefix").replace('&', '§');
    }

    public void OnlyPlyFail(CommandSender sender){
        sender.sendMessage("Only players can use this command.");
    }

    public void PluginCmdUsage(CommandSender sender){
        sender.sendMessage(Prefix() + " " + ChatColor.YELLOW + "Usage: /trollsounds <playername> <soundname>");
    }

    public void PluginCmdFail(CommandSender sender){
        Player player = (Player) sender;
        String PluginCmdFailMsg = plugin.config.getString("ChatMessages.PluginCommandFail").replace('&', '§');
        player.sendMessage(PluginCmdFailMsg);
    }

    public void SoundPlayed(CommandSender sender, String soundName){
        Player player = (Player) sender;
        String SoundPlayedMessage = plugin.config.getString("ChatMessages.SoundPlayed")
                .replace('&', '§')
                .replace("{SOUND}", soundName);
        player.sendMessage(Prefix() + " " + SoundPlayedMessage);
    }

    public void PlyNotFound(CommandSender sender, String playerName){
        Player player = (Player) sender;
        String PlyNotFoundMsg = plugin.config.getString("ChatMessages.PlayerNotFound")
                .replace('&', '§')
                .replace("{PLAYER}", playerName);
        player.sendMessage(Prefix() + " " + PlyNotFoundMsg);
    }

    public void SoundNameFail(CommandSender sender){
        Player player = (Player) sender;
        String SoundNameFailMsg = plugin.config.getString("ChatMessages.SoundNameFail").replace('&', '§');
        player.sendMessage(Prefix() + " " + SoundNameFailMsg);
    }

    public void SoundsList(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(ChatColor.GREEN + "Available sounds:");

            // Create a component builder
            TextComponent clickableList = new TextComponent("");

            // Add the sound options as clickable text
            addClickableSoundOption(clickableList, "creeperhiss", "Cick to copy!", "creeperhiss");
            addClickableSoundOption(clickableList, "zombie", "Cick to copy!", "zombie");
            addClickableSoundOption(clickableList, "enderman", "Cick to copy!", "enderman");
            addClickableSoundOption(clickableList, "lightning", "Cick to copy!", "lightning");
            addClickableSoundOption(clickableList, "horn1", "Cick to copy!", "horn1");
            addClickableSoundOption(clickableList, "horn2", "Cick to copy!", "horn2");
            addClickableSoundOption(clickableList, "horn3", "Cick to copy!", "horn3");
            addClickableSoundOption(clickableList, "horn4", "Cick to copy!", "horn4");
            addClickableSoundOption(clickableList, "cave", "Cick to copy!", "cave");
            addClickableSoundOption(clickableList, "damage", "Cick to copy!", "damage");
            addClickableSoundOption(clickableList, "door", "Cick to copy!", "door");
            addClickableSoundOption(clickableList, "lever", "Cick to copy!", "lever");
            addClickableSoundOption(clickableList, "piston", "Cick to copy!", "piston");
            addClickableSoundOption(clickableList, "bell", "Cick to copy!", "bell");
            addClickableSoundOption(clickableList, "villager", "Cick to copy!", "bell");
            addClickableSoundOption(clickableList, "pig", "Cick to copy!", "bell");
            addClickableSoundOption(clickableList, "cow", "Cick to copy!", "bell");
            addClickableSoundOption(clickableList, "ghastcry", "Cick to copy!", "bell");
            addClickableSoundOption(clickableList, "silverfish", "Cick to copy!", "bell");
            addClickableSoundOption(clickableList, "anvil", "Cick to copy!", "bell");

            // Send the clickable list to the player
            player.spigot().sendMessage(clickableList);
        }
    }

    private void addClickableSoundOption(TextComponent baseComponent, String soundName, String hoverText, String copyText) {
        TextComponent option = new TextComponent(ChatColor.YELLOW + soundName);
        option.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, copyText));
        option.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hoverText).create()));

        // Add a comma and space after each option for spacing
        TextComponent comma = new TextComponent(", ");
        baseComponent.addExtra(option);
        baseComponent.addExtra(comma);
    }

    public void ReloadConfigMessage(CommandSender sender){
        Player player = (Player) sender;
        String ReloadConfigMsg = plugin.config.getString("ChatMessages.ReloadConfig").replace('&', '§');
        player.sendMessage(Prefix() + " " + ReloadConfigMsg);
    }
}
