package de.filtastisch.plugin.master.main.commands;

import net.minecraft.server.v1_16_R2.ChatModifier;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.scoreboard.*;


import java.lang.reflect.Field;

import static de.filtastisch.plugin.master.main.Main.isNicked;
import static de.filtastisch.plugin.master.main.Main.nick;


public class nickManager implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (sender instanceof Player){
            Player p = (Player)sender;
            if (p.hasPermission("shila.nick")){
                if (args.length == 1){
                    if (args[0].length () < 15){
                        nick.put (p.getName(), args[0]);
                        p.sendMessage("§7[§aNickManager§7]§a Dein Nickname ist jetzt §6" + args[0] + "§a!");
                        p.setDisplayName(args[0]);
                        p.setPlayerListName(args[0]);
                    } else {
                        p.sendMessage("§7[§aNickManager§7]§c Der Nickname darf nur 15 Zeichen haben!");
                    }
                } else {
                    p.sendMessage("§7[§aNickManager§7]§a Dein Nickname wurde zurückgesetzt!");
                    p.setDisplayName(nick.get (1));
                    p.setPlayerListName(nick.get(1));
                }
            }
        }
        return false;
    }
}