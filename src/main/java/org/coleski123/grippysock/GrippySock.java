package org.coleski123.grippysock;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class GrippySock extends JavaPlugin {
    private ChatMessages chatMessages;
    private Sounds playSound;
    private String pluginPrefix = ChatColor.DARK_PURPLE + "[TrollSounds]";

    @Override
    public void onEnable() {
        //Enable Bstats
        int pluginId = 20153;
        Metrics metrics = new Metrics(this, pluginId);

        // Ensure the config.yml file exists and load it
        this.saveDefaultConfig();
        config = getConfig(); // Load the configuration

        // Plugin startup logic
        sendConsoleMessage(ChatColor.GREEN + "TrollSounds has been enabled!");

        chatMessages = new ChatMessages(this);
        playSound = new Sounds(this);

        new UpdateChecker(this, 113264).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) {
                sendConsoleMessage("&2No new versions available.");
            } else {
                sendConsoleMessage("&cA new version is now available! Download: https://www.spigotmc.org/resources/trollsounds.113264/");
            }
        });
    }

    // Load the plugins configuration
    FileConfiguration config = getConfig();

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        sendConsoleMessage(ChatColor.RED + "TrollSounds has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            chatMessages.OnlyPlyFail(sender);
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 1 && args[0].equalsIgnoreCase("reloadconfig")) {
            if (player.hasPermission("trollsounds.reloadconfig")) {
                reloadConfig();
                config = getConfig();
                chatMessages.ReloadConfigMessage(sender);
                playSound.SuccessSound(sender);
            } else {
                chatMessages.PluginCmdFail(sender);
                playSound.FailureSound(sender);
            }
            return true;
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("list")) {
            if (player.hasPermission("trollsounds.list")) {
                chatMessages.SoundsList(sender);
            } else {
                chatMessages.PluginCmdFail(sender);
                playSound.FailureSound(sender);
            }
            return true;
        }

        if (args.length < 2) {
            chatMessages.PluginCmdUsage(sender);
            return true;
        }

        String playerName = args[0];
        String soundName = args[1];

        // Check if the player has the required permission
        if (!player.hasPermission("trollsounds.playsounds")) {
            chatMessages.PluginCmdFail(sender);
            playSound.FailureSound(sender);
            return true;
        }

        if (playSound.checkSound(soundName)) {
            // Find the target player by name
            Player targetPlayer = player.getServer().getPlayer(playerName);

            if (targetPlayer != null) {
                playSound.playTrollSound(sender, args);
                chatMessages.SoundPlayed(sender, soundName);
                return true;
            } else {
                chatMessages.PlyNotFound(sender, playerName);
                playSound.FailureSound(sender);
                return true;
            }
        } else {
            chatMessages.SoundNameFail(sender);
            playSound.FailureSound(sender);
            return true;
        }
    }

    private void sendConsoleMessage(String message) {
        getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pluginPrefix + " " + message));
    }
}
