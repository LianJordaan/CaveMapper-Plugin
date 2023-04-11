package cavemapper.cavemapper.Commands;

import cavemapper.cavemapper.CaveMapper;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (sender instanceof Player){
            Player p = (Player) sender;
            try {
                if (p.getTargetBlockExact(999999).getLocation().distance(p.getLocation()) <= 10) {
                    HighlightBlock(new Location(p.getWorld(), p.getTargetBlockExact(10).getX() + 0.5, p.getTargetBlockExact(10).getY(), p.getTargetBlockExact(10).getZ() + 0.5));
                }
            }catch(Exception e){p.sendMessage(ChatColor.RED + "ERROR");}
        }

        return true;
    }

    public void ClearHighlightBlocks(){
        for(World world : Bukkit.getServer().getWorlds()) {
            for(Entity e : world.getEntities()) {
                if(e.getScoreboardTags().contains("HighlightBlock Mob")) {
                    e.remove();
                }
            }
        }
    }

    public void HighlightBlock(Location loc) {
        Entity entity = loc.getWorld().spawnEntity(loc, EntityType.SHULKER);
        Shulker shulker = (Shulker) entity;
        shulker.setAI(false);
        shulker.addScoreboardTag("HighlightBlock Mob");
        shulker.setInvisible(true);
        shulker.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 10, false, false));
        shulker.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 999999, 1, false, false));
        shulker.setInvulnerable(true);
        shulker.setSilent(true);
        shulker.setGravity(false);
        new BukkitRunnable() {
            public void run() {
                shulker.remove();
            }
        }.runTaskLater(JavaPlugin.getProvidingPlugin(CaveMapper.class), 200L);

    }



    public Location Correspondence(int num, Location loc) {
        if (num == 1) {
            return loc.getBlock().getRelative(BlockFace.UP, 1).getLocation();
        } else if (num == 2){
            return loc.getBlock().getRelative(BlockFace.DOWN, 1).getLocation();
        } else if (num == 3) {
            return loc.getBlock().getRelative(BlockFace.NORTH, 1).getLocation();
        } else if (num == 4) {
            return loc.getBlock().getRelative(BlockFace.EAST, 1).getLocation();
        } else if (num == 5) {
            return loc.getBlock().getRelative(BlockFace.SOUTH, 1).getLocation();
        } else if (num == 6) {
            return loc.getBlock().getRelative(BlockFace.WEST, 1).getLocation();
        }

        return loc.getBlock().getRelative(BlockFace.UP, 1).getLocation();
    }

    public boolean[] CheckSide(Location loc) {
        boolean[] returns = {false, false, false, false, false, false};
        ArrayList<Material> materials = new ArrayList();
        assert false;
        materials.add(Material.AIR);
        materials.add(Material.WATER);
        materials.add(Material.CAVE_AIR);
        materials.add(Material.LAVA);
        materials.add(Material.GLASS);
        if(materials.contains(loc.getBlock().getRelative(BlockFace.UP, 1).getType())){
            returns[0] = true;
        } if(materials.contains(loc.getBlock().getRelative(BlockFace.DOWN, 1).getType())) {
            returns[1] = true;
        } if(materials.contains(loc.getBlock().getRelative(BlockFace.NORTH, 1).getType())) {
            returns[2] = true;
        } if(materials.contains(loc.getBlock().getRelative(BlockFace.EAST, 1).getType())) {
            returns[3] = true;
        } if(materials.contains(loc.getBlock().getRelative(BlockFace.SOUTH, 1).getType())) {
            returns[4] = true;
        } if(materials.contains(loc.getBlock().getRelative(BlockFace.WEST, 1).getType())) {
            returns[5] = true;
        }
        return returns;
    }


}