package de.filtastisch.plugin.master.main.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class healCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.hasPermission ( "master.heal" )){
                if (args.length == 0){
                    p.setHealth ( 20 );
                }
            }
        }
        return false;
    }
}
