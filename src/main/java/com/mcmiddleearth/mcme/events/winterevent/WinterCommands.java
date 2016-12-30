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
package com.mcmiddleearth.mcme.events.winterevent;

import com.mcmiddleearth.mcme.events.winterevent.SnowballFight.commands.ClearCommand;
import com.mcmiddleearth.mcme.events.winterevent.SnowballFight.commands.GetCommand;
import com.mcmiddleearth.mcme.events.winterevent.SnowballFight.commands.SnowCommand;
import com.mcmiddleearth.mcme.events.winterevent.SnowballFight.commands.StartStopCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Donovan
 */
public class WinterCommands implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String label, String[] args) {
        if(args.length == 0){
            return false;
        }else{
            if(args[0].equalsIgnoreCase("snow")){//work because no args in lizzy code :P
                return new SnowCommand().onCommand(cs, cmnd, label, args);
            }else if(args[0].equalsIgnoreCase("getsnow")){
                return new GetCommand().onCommand(cs, cmnd, label, args);
            }else if(args[0].equalsIgnoreCase("start")){
                return new StartStopCommand().onCommand(cs, cmnd, label, args);
            }else if(args[0].equalsIgnoreCase("stop")){
                return new StartStopCommand().onCommand(cs, cmnd, label, args);
            }else if(args[0].equalsIgnoreCase("clear")){
                return new ClearCommand().onCommand(cs, cmnd, label, args);
            }else{
                cs.sendMessage("Invalid subcommand");
                return false;
            }
        }
    }
}
