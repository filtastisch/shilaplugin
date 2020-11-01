package de.filtastisch.plugin.master.main.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class joinListener implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e){
        e.setJoinMessage ("§7[§8" + e.getPlayer ().getName () + "§7]" + "§6 Ist dem Server beigetreten!" );
        if (!e.getPlayer().isOp ()) {
            e.getPlayer().sendMessage ( "§7[§aBuildserver§7]§e Um §cOP §eRechte zu erhalten gib deinen §cpersönlichen Token §eein" );
        }
    }

}
