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
 * m
 * You should have received a copy of the GNU General Public License
 * along with MCME-Events.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * 
 */
package com.mcmiddleearth.mcme.events.PVP.Handlers;

import com.mcmiddleearth.mcme.events.Main;
import com.mcmiddleearth.mcme.events.PVP.Map;
import com.mcmiddleearth.mcme.events.PVP.PVPCore;
import com.mcmiddleearth.mcme.events.Util.DBmanager;
import java.io.File;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Donovan <dallen@dallen.xyz>
 */
public class AllGameHandlers implements Listener{
    
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        if(PVPCore.getPlaying().keySet().contains(e.getPlayer().getName())){
            Map m = Map.maps.get(PVPCore.getPlaying().get(e.getPlayer().getName()));
            if(m != null){
                if(m.getName().contains("HD")){
                    if(e.getPlayer().getInventory().contains(new ItemStack(Material.TNT))){
                        e.getPlayer().getInventory().remove(Material.TNT);
                        e.getPlayer().getLocation().getWorld().dropItem(e.getPlayer().getLocation(), new ItemStack(Material.TNT));
                    }
                }
            }
        }
    }
    
    @EventHandler
    public void onWorldSave(WorldSaveEvent e){
        for(String mn : Map.maps.keySet()){
            Map m = Map.maps.get(mn);
            DBmanager.saveObj(m, new File(PVPCore.getSaveLoc() + Main.getFileSep() + "Maps"), mn);
        }
    }
    
}
