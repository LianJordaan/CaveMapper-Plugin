package cavemapper.cavemapper;

import cavemapper.cavemapper.Commands.start;
import cavemapper.cavemapper.Commands.command;
import cavemapper.cavemapper.Commands.stop;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


public final class CaveMapper extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("highlightblock").setExecutor(new command());
        getCommand("algorithmstart").setExecutor(new start());
        getCommand("algorithmstop").setExecutor(new stop());
    }

    @Override
    public void onDisable() {
        for(World world : Bukkit.getServer().getWorlds()) {
            for(Entity e : world.getEntities()) {
                //command command = new command();
                //command.HighlightBlock(e.getLocation());
                if(e.getScoreboardTags().contains("HighlightBlock Mob")) {
                    e.remove();
                }
            }
        }
    }

}