package daruma.daruma;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


class Move implements Listener {
    @EventHandler
    void move(PlayerMoveEvent event){//動いたかどうかの判定
        while (Daruma.move){
        Player player = event.getPlayer();
            if (player.getGameMode() == GameMode.ADVENTURE) {
                player.sendMessage(ChatColor.RED + "動いてしまった！");
                player.setGameMode(GameMode.SPECTATOR);
            }
        }
    }
}