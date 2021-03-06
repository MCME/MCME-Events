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
package com.mcmiddleearth.mcme.events.winterevent.SnowManInvasion;

import com.mcmiddleearth.mcme.events.winterevent.SnowManInvasion.Snowman.InvasionSnowman;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;

/**
 *
 * @author Donovan
 */
public class Invasion {
    
    public static ArrayList<InvasionSnowman> army = new ArrayList<>();
    
    
    
    Runnable tick = new Runnable() {
            @Override
            public void run() {
                
            }
        };
    
    public Invasion(List<SpawnPoint> spawnPoints){
        for(SpawnPoint sp : spawnPoints){
            army.addAll(sp.spawn());
        }
    }
}
