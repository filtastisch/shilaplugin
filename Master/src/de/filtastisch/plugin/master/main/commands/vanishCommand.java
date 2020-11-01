package de.filtastisch.plugin.master.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import static de.filtastisch.plugin.master.main.Main.vanish;

import java.util.ArrayList;
import java.util.List;

public class vanishCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (p instanceof Player){
            if (args.length == 0) {
                if (p.hasPermission ( "shila.vanish" )) {
                    if (vanish.contains (p)) {
                        vanish.remove (p);
                        p.sendMessage ("§7[§aVanish§7]§6 Du bist nun nicht mehr im Vanish");
                        p.setAllowFlight (false);
                        p.setInvulnerable (false);
                        for(PotionEffect effect : p.getActivePotionEffects ())
                            p.removePotionEffect (effect.getType ());
                        for (Player all : Bukkit.getOnlinePlayers ()) {
                            all.showPlayer ( p );
                        }
                    } else {
                        vanish.add ( p );
                        p.sendMessage ("§7[§aVanish§7]§6 Du bist nun im Vanish");
                        p.setAllowFlight (true);
                        p.addPotionEffect (new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 0));
                        p.addPotionEffect (new PotionEffect(PotionEffectType.SATURATION, 1000000, 255));
                        p.setInvulnerable (true);

                        for (Player all : Bukkit.getOnlinePlayers ()) {
                            all.hidePlayer (p);
                        }
                    }
                }else {
                    p.sendMessage ( "§7[§aVanish§7]§c Du hast dazu keine Rechte" );
                }
            }
        }
        return false;
    }
}
