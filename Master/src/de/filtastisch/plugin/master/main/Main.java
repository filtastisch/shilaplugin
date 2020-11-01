package de.filtastisch.plugin.master.main;

import de.filtastisch.plugin.master.main.commands.*;
import de.filtastisch.plugin.master.main.listener.hungerListener;
import de.filtastisch.plugin.master.main.listener.joinListener;
import de.filtastisch.plugin.master.main.util.ItemBuilder;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main extends JavaPlugin {

    public static List<Player> vanish = new ArrayList<> ();
    public static List<Player> isNicked = new ArrayList<> ();
    public static HashMap<String, String> nick = new HashMap<>();

    @Override
    public void onEnable() {
        this.getCommand("heal").setExecutor(new healCommand());
        this.getCommand ("optoken").setExecutor (new opToken());
        this.getCommand ("invsee").setExecutor (new invsee ());
        this.getCommand ("vanish").setExecutor (new vanishCommand ());
        this.getCommand ("admin").setExecutor (new adminGUI ());
        this.getCommand ("nick").setExecutor (new nickManager ());

        getServer().getPluginManager().registerEvents(new adminGUI (), this);
        getServer().getPluginManager().registerEvents(new joinListener (), this);
        getServer().getPluginManager().registerEvents(new hungerListener(),this);

        System.out.println ("Plugin aktiviert!");

    }

    @Override
    public void onDisable() {
        Bukkit.broadcastMessage ("§cACHTUNG RELOAD!");
    }
}
