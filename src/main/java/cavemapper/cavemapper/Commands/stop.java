package cavemapper.cavemapper.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class stop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        command functions = new command();
        functions.ClearHighlightBlocks();
        publicVar.isRunning = false;
        for(Location loc : publicVar.BlocksToClear) {
            loc.getBlock().setType(Material.AIR);
        }
        publicVar.BlocksToCheck = new ArrayList();
        Player p = (Player) sender;
        p.sendMessage(ChatColor.RED + "Stopped.. i think");
        return true;
    }
}
