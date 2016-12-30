/*
 * This file is part of MCME-Events.
 * 
 * MCME-Events is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MCME-Events is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MCME-Events.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * 
 */
package com.mcmiddleearth.mcme.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcmiddleearth.mcme.events.winterevent.WinterCommands;
import com.mcmiddleearth.mcme.events.winterevent.SnowballFight.listeners.SnowballListener;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Donovan
 */
public class Main extends JavaPlugin{
    
    @Getter
    private static boolean debug = true;
    
    @Getter
    private static Main plugin;
    
    @Getter
    private String spawnWorld;
    
    @Getter
    private static String FileSep = System.getProperty("file.separator");
    
    @Getter
    private ArrayList<String> noHunger = new ArrayList<String>();
    
    @Getter
    private static ObjectMapper objectMapper = new ObjectMapper();
    
    @Getter
    private static Server serverInstance;
    
    @Getter
    private static File pluginDirectory;
    
    @Getter
    private static File playerDirectory;
    
    @Getter
    private static boolean blockprotect = false;
    
    @Override
    public void onEnable(){
        plugin = this;
        this.saveDefaultConfig();
        this.reloadConfig();
        /*if(this.getConfig().contains("worlds")){
            for(String s : this.getConfig().getStringList("worlds")){
                Bukkit.getServer().getWorlds().add(Bukkit.getServer().createWorld(new WorldCreator(s)));
            }
        }
        if(this.getConfig().contains("noHunger")){
            noHunger.addAll(this.getConfig().getStringList("noHunger"));
        }*/
        try {
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.serverInstance = getServer();
        this.pluginDirectory = getDataFolder();
        if (!pluginDirectory.exists()){
            pluginDirectory.mkdir();
        }
        this.playerDirectory = new File(pluginDirectory + System.getProperty("file.separator") + "players");
        if (!playerDirectory.exists()){
            playerDirectory.mkdir();
        }
//        Thompson t = new Thompson(this);
        //this.getCommand("WorldJump").setExecutor(new CommandCore());
        //this.getCommand("World").setExecutor(new CommandCore());
        //this.getCommand("PlugUp").setExecutor(new CommandCore());
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new ListenerCore(), this);
        boolean Winter = this.getConfig().getBoolean("WinterEvent.Enabled");
        if(Winter){
            this.getCommand("winter").setExecutor(new WinterCommands());
            //this.getCommand("event").setExecutor(new WinterCommands());
            registerHandles(false, pm);
        }
    }
    
    private void registerHandles(boolean summer, PluginManager pm){
        if(summer){
            pm.registerEvents(new SnowballListener(), this);
        }else{
            pm.registerEvents(new SnowballListener(), this);
        }
    }
}
