package de.filtastisch.plugin.master.main.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import static de.filtastisch.plugin.master.main.Main.vanish;

public class hungerListener implements Listener {

    @EventHandler
    public void onHungerDeplete(FoodLevelChangeEvent e) {
        Player p = (Player) e;
        if (vanish.contains(p)){
                e.setCancelled ( true );
                p.setFoodLevel ( 20 );
        }
    }

}
