package daruma.daruma;


import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


import static org.bukkit.Bukkit.getServer;

public class hantei implements Listener {
    @EventHandler
    public void GoalEvent(PlayerInteractEvent event){//ゴールした時
        Player player = event.getPlayer();
        ItemStack hand = event.getPlayer().getItemInHand();
        Block block = event.getClickedBlock();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if ((block != null ? block.getType() : null) == Material.STONE_BUTTON) {
                if (hand.getType() == Material.AIR) {
                    if (player.getGameMode() == GameMode.ADVENTURE) {
                        getServer().broadcastMessage(ChatColor.BLUE + player.getName() + ChatColor.WHITE + "さんがゴールしました！");
                        (player.getWorld()).playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        player.setGameMode(GameMode.SPECTATOR);
                    }
                }
            }
        }
    }
    @EventHandler
    public void DamegeCancel(EntityDamageEvent event){//ダメージの無効化
        Entity entity = event.getEntity();
        if (entity.getType()== EntityType.PLAYER){
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void HealCancel(EntityRegainHealthEvent event){//回復の無効化
        Entity entity = event.getEntity();
        if (entity.getType()== EntityType.PLAYER){
            event.setCancelled(true);
        }
    }
}