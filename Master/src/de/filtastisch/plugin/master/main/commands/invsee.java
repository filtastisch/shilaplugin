package de.filtastisch.plugin.master.main.commands;

import javafx.print.PageLayout;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class invsee implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (sender.hasPermission ( "shila.invsee" )){
                if (args.length == 1){
                    Player target = Bukkit.getPlayer (args[0]);
                    Player player = (Player)sender;

                    player.openInventory(target.getInventory ());
                    player.sendMessage ("§9Du hast das Inventar von §a" + target.getName () + " §9geöffnet!" );
                }else{
                    sender.sendMessage ("");
                }
            }else{
                sender.sendMessage ("");
            }
        return false;
    }
}
