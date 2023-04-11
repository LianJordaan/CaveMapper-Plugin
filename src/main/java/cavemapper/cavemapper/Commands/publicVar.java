package cavemapper.cavemapper.Commands;

import cavemapper.cavemapper.CaveMapper;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class publicVar {


    //public static void iterateOverFoo(Boolean canContinue, Integer totalBlocks, Player p) {
        //start Function = new start();
        //CompletableFuture.runAsync(() -> {
        //    while(publicVar.isRunning) {
        //        if (canContinue) {
        //            publicVar.num++;
        //            ArrayList<ArrayList<Location>> check = Function.check(canContinue, totalBlocks, publicVar.HaveChecked, publicVar.HighlightBlocks, p);
        //            publicVar.HaveChecked = check.get(0);
        //            publicVar.HighlightBlocks = check.get(1);
        //        }
        //        try {
        //            Thread.sleep(1L);
        //        } catch (InterruptedException ignored) {}
        //    }
        //});
        //new BukkitRunnable() {
        //    start Function = new start();
        //    public void run() {
        //        while(publicVar.isRunning) {
        //            if (canContinue) {
        //                publicVar.num++;
        //                ArrayList<ArrayList<Location>> check = Function.check(canContinue, totalBlocks, publicVar.HaveChecked, publicVar.HighlightBlocks, p);
        //                publicVar.HaveChecked = check.get(0);
        //                publicVar.HighlightBlocks = check.get(1);
        //            }
//
        //            try {
        //                Thread.sleep(1L);
        //            } catch (InterruptedException exception) {}
        //        }
        //    }
        //}.runTaskAsynchronously(JavaPlugin.getPlugin(CaveMapper.class));
    //}
    public static boolean isRunning = false;
    public static ArrayList<Location> BlocksToClear = new ArrayList();
    public static ArrayList<Location> BlocksToCheck = new ArrayList();
    public static ArrayList<Location> HaveChecked = new ArrayList();
    public static ArrayList<Location> HighlightBlocks = new ArrayList();
    public static Integer num = new Integer(0);


}

