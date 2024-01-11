package org.coleski123.grippysock;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sounds {
    private final GrippySock plugin;
    public Sounds(GrippySock plugin) {
        this.plugin = plugin;
    }

    public boolean PluginSounds(){
        return plugin.getConfig().getBoolean("Options.PluginSounds");
    }

    public Sound getSound(String soundName){
        switch (soundName) {
            case "creeperhiss":
                return Sound.ENTITY_CREEPER_PRIMED;
            case "zombie":
                return Sound.ENTITY_ZOMBIE_AMBIENT;
            case "enderman":
                return Sound.ENTITY_ENDERMAN_AMBIENT;
            case "lightning":
                return Sound.ENTITY_LIGHTNING_BOLT_IMPACT;
            case "horn1":
                return Sound.ITEM_GOAT_HORN_SOUND_1;
            case "horn2":
                return Sound.ITEM_GOAT_HORN_SOUND_2;
            case "horn3":
                return Sound.ITEM_GOAT_HORN_SOUND_3;
            case "horn4":
                return Sound.ITEM_GOAT_HORN_SOUND_4;
            case "cave":
                return Sound.AMBIENT_CAVE;
            case "damage":
                return Sound.ENTITY_PLAYER_ATTACK_NODAMAGE;
            case "door":
                return Sound.BLOCK_WOODEN_DOOR_OPEN;
            case "lever":
                return Sound.BLOCK_LEVER_CLICK;
            case "piston":
                return Sound.BLOCK_PISTON_EXTEND;
            case "bell":
                return Sound.BLOCK_BELL_RESONATE;
            case "villager":
                return Sound.ENTITY_VILLAGER_AMBIENT;
            case "pig":
                return Sound.ENTITY_PIG_AMBIENT;
            case "cow":
                return Sound.ENTITY_COW_AMBIENT;
            case "ghastcry":
                return Sound.ENTITY_GHAST_AMBIENT;
            case "silverfish":
                return Sound.ENTITY_SILVERFISH_AMBIENT;
            case "anvil":
                return Sound.BLOCK_ANVIL_PLACE;
            case "bat":
                return Sound.ENTITY_BAT_AMBIENT;
            case "allay":
                return Sound.ENTITY_ALLAY_DEATH;
            case "amethyst":
                return Sound.BLOCK_AMETHYST_BLOCK_STEP;
            case "vex":
                return Sound.ENTITY_VEX_AMBIENT;
            case "guardian":
                return Sound.ENTITY_GUARDIAN_AMBIENT;
            case "blaze":
                return Sound.ENTITY_BLAZE_AMBIENT;
        }
        return null;
    }

    public Boolean checkSound(String soundName){
        switch (soundName) {
            case "creeperhiss":
                return true;
            case "zombie":
                return true;
            case "enderman":
                return true;
            case "lightning":
                return true;
            case "horn1":
                return true;
            case "horn2":
                return true;
            case "horn3":
                return true;
            case "horn4":
                return true;
            case "cave":
                return true;
            case "damage":
                return true;
            case "door":
                return true;
            case "lever":
                return true;
            case "piston":
                return true;
            case "bell":
                return true;
            case "villager":
                return true;
            case "pig":
                return true;
            case "cow":
                return true;
            case "ghastcry":
                return true;
            case "silverfish":
                return true;
            case "anvil":
                return true;
            case "bat":
                return true;
            case "allay":
                return true;
            case "amethyst":
                return true;
            case "vex":
                return true;
            case "guardian":
                return true;
            case "blaze":
                return true;
        }
        return false;
    }

    public void playTrollSound(CommandSender sender, String[] args){
        String playerName = args[0];
        Player player = (Player) sender;
        Player targetPlayer = player.getServer().getPlayer(playerName);
        Location targetLocation = targetPlayer.getLocation();
        targetLocation.add(0, -1, 0); // Move to the feet level
        targetPlayer.playSound(targetLocation, getSound(args[1]), 10f, 1.0f);
    }

    public void SuccessSound(CommandSender sender) {
        Player player = (Player) sender;
        if (PluginSounds()) {
            Sound sound = Sound.BLOCK_NOTE_BLOCK_BIT;
            float volume = 0.10f;
            float pitch = 2.0f;
            player.playSound(player.getLocation(), sound, volume, pitch);
        }
    }

    public void FailureSound(CommandSender sender) {
        Player player = (Player) sender;
        if (PluginSounds()) {
            Sound sound = Sound.BLOCK_NOTE_BLOCK_BIT;
            float volume = 0.10f;
            float pitch = 1.0f;
            player.playSound(player.getLocation(), sound, volume, pitch);
        }
    }
}
