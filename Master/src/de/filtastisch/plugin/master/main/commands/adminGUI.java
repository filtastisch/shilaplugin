package de.filtastisch.plugin.master.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.nio.Buffer;
import java.security.PublicKey;

public class adminGUI implements CommandExecutor, Listener{

    public String GUI_NAME = "§4§lAdmin GUI";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (p instanceof Player){
            if (args.length == 0){
                if (p.hasPermission ( "shila.admin" )){
                    Inventory inventory = Bukkit.createInventory (null, 9*4, GUI_NAME);

                    ItemStack item_goldenapple = new ItemStack (Material.GOLDEN_APPLE);
                    ItemMeta meta = item_goldenapple.getItemMeta ();
                    meta.setDisplayName ( "§cTEST" );
                    inventory.setItem (4, new ItemStack (item_goldenapple));

                    p.openInventory (inventory);
                }
            }
        }
        return false;
    }

    @EventHandler
    public void adminGuiClickCancel(InventoryClickEvent event){
        if (!(event.getWhoClicked () instanceof Player)) return;
        Player player = (Player) event.getWhoClicked ();
        if (event.getClickedInventory ().equals (GUI_NAME)){
            event.setCancelled (true);
        }
    }
}
