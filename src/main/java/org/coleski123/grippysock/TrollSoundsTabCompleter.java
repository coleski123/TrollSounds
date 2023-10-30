package org.coleski123.grippysock;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TrollSoundsTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            // Suggest online player names, "list," and "reloadconfig" as the first argument
            for (Player player : Bukkit.getOnlinePlayers()) {
                completions.add(player.getName());
            }
            completions.add("list");
            completions.add("reloadconfig");
        } else if (args.length == 2) {
            // Suggest valid sound names as the second argument
            completions.add("creeperhiss");
            completions.add("zombie");
            completions.add("enderman");
            completions.add("lightning");
            completions.add("horn1");
            completions.add("horn2");
            completions.add("horn3");
            completions.add("horn4");
            completions.add("cave");
            completions.add("damage");
            completions.add("door");
            completions.add("lever");
            completions.add("piston");
            completions.add("bell");
            completions.add("villager");
            completions.add("pig");
            completions.add("cow");
            completions.add("ghastcry");
            completions.add("silverfish");
            completions.add("anvil");
            // Add more sound names here...
        }

        return completions;
    }
}