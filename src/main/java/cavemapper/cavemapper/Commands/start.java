package cavemapper.cavemapper.Commands;

import cavemapper.cavemapper.CaveMapper;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import static cavemapper.cavemapper.Commands.publicVar.BlocksToCheck;


public class start implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(ChatColor.GREEN + "Started.. i think?");

                int totalBlocks = 0;
                publicVar.isRunning = true;
                boolean cont;
                try {
                    BlocksToCheck.add(p.getTargetBlockExact(9999).getLocation());
                    cont = true;
                } catch (Exception e) {
                    cont = false;
                }
                final boolean canContinue = cont;
                command functions = new command();
                publicVar.num = 0;
                start Function = new start();
                JavaPlugin plugin = JavaPlugin.getPlugin(CaveMapper.class);
                publicVar publicVarFunctions = new publicVar();
                new Thread(() -> {
                    while(publicVar.isRunning) {
                        if (canContinue) {
                            publicVar.num++;
                            ArrayList<ArrayList<Location>> check = check(canContinue, totalBlocks, publicVar.HaveChecked, publicVar.HighlightBlocks, p);
                            publicVar.HaveChecked = check.get(0);
                            publicVar.HighlightBlocks = check.get(1);
                        }
                    }
                }).start();
            }

        return true;
   }


    public ArrayList<ArrayList<Location>> check(boolean canContinue, int totalBlocks, ArrayList<Location> HaveChecked, ArrayList<Location> HighlightBlocks, Player p) {
        command functions = new command();
        if (!publicVar.isRunning) {
            p.sendMessage(ChatColor.RED + "Scan cancelled");
            canContinue = false;
            publicVar.isRunning = false;
        }
        if (canContinue){
                boolean[] sides = functions.CheckSide(BlocksToCheck.get(0));
                int index = 0;
                for(boolean bool : sides) {
                    totalBlocks++;
                    index++;
                    if (bool){
                        functions.Correspondence(index, BlocksToCheck.get(0)).getBlock().setType(Material.GLASS);
                        publicVar.BlocksToClear.add(functions.Correspondence(index, BlocksToCheck.get(0)));
                        if (!HaveChecked.contains(BlocksToCheck.get(0))) {
                            BlocksToCheck.add(functions.Correspondence(index, BlocksToCheck.get(0)));
                        }
                    } else {
                        if (!HighlightBlocks.contains(functions.Correspondence(index, BlocksToCheck.get(0)).getBlock().getLocation())) {
                            functions.HighlightBlock(functions.Correspondence(index, BlocksToCheck.get(0)));
                            HighlightBlocks.add(functions.Correspondence(index, BlocksToCheck.get(0)));
                        }
                    }

                }
                try {
                    if (!HaveChecked.contains(BlocksToCheck.get(0))) {
                        HaveChecked.add(BlocksToCheck.get(0));
                    }
                    BlocksToCheck.remove(BlocksToCheck.get(0));
                } catch (Exception ignored) {
                }
        }
        for(Location loc : publicVar.BlocksToClear) {
            try{
                loc.getBlock().setType(Material.AIR);
            }catch (Exception ignored) {
            }
        }
        try {
            Location get = BlocksToCheck.get(0);
        } catch (Exception e) {
            p.sendMessage(ChatColor.RED + "Cave mapping done!");
            publicVar.isRunning = false;
            canContinue = false;
    }
        ArrayList<ArrayList<Location>> r = new ArrayList();
        r.add(HaveChecked);
        r.add(HighlightBlocks);
        return r;
}}
