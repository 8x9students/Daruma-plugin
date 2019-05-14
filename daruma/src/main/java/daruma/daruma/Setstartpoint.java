package daruma.daruma;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

class Setstartpoint {
    void setstartpoint(Player player){
        Daruma.startpoint = player.getLocation();
        player.sendMessage(ChatColor.WHITE+"スタート地点が"+Daruma.startpoint.getX()+"、"+Daruma.startpoint.getY()+"、"+Daruma.startpoint.getZ()+"に設定されました");
        System.out.println("スタート地点が"+Daruma.startpoint.getX()+"、"+Daruma.startpoint.getY()+"、"+Daruma.startpoint.getZ()+"に設定されました");
    }
}
