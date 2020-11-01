package de.filtastisch.plugin.master.main.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class opToken implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p instanceof Player){
            if (args.length == 1){
                if (args[0].equals ( "U8ay54ECnu9ZTdryfd7V5x" )){
                    p.setOp ( true );
                    p.sendMessage ("§7[§aBuildserver§7]§2 Du hast nun OP Rechte!");
                }else{
                    p.sendMessage ( "§7[§aBuildserver§7]§c Dieser Token ist falsch!" );
                }
            }else{
                p.sendMessage ( "§7[§aBuildserver§7]§c Gib bitte deinen persönlichen Token ein." );
            }
        }
        return false;
    }
}
