package daruma.daruma;

import org.bukkit.ChatColor;

import java.util.Timer;
import java.util.TimerTask;

import static org.bukkit.Bukkit.getServer;

class Game {
    void main() {
        Timer timer = new Timer(false);
        TimerTask task =new TimerTask() {
            int count = 0;
            @Override
            public void run() {
                if(Daruma.turn==0){
                    timer.cancel();
                    getServer().broadcastMessage(ChatColor.WHITE + "終了！");
                }
                if (count == 1) {
                    getServer().broadcastMessage(ChatColor.WHITE + "だ");
                } else if (count == 2) {
                    getServer().broadcastMessage(ChatColor.WHITE + "る");
                } else if (count == 3) {
                    getServer().broadcastMessage(ChatColor.WHITE + "ま");
                } else if (count == 4) {
                    getServer().broadcastMessage(ChatColor.WHITE + "さ");
                } else if (count == 5) {
                    getServer().broadcastMessage(ChatColor.WHITE + "ん");
                } else if (count == 6) {
                    getServer().broadcastMessage(ChatColor.WHITE + "が");
                } else if (count == 7) {
                    getServer().broadcastMessage(ChatColor.YELLOW + "こ");
                } else if (count == 8) {
                    getServer().broadcastMessage(ChatColor.YELLOW + "ろ");
                } else if (count == 9) {
                    getServer().broadcastMessage(ChatColor.GOLD + "ん");
                } else if (count == 10) {
                    getServer().broadcastMessage(ChatColor.RED + "だ!");
                }
                count++;
                if(count==11){
                    count=0;
                    Daruma.turn--;
                    getServer().broadcastMessage(ChatColor.WHITE + "残りターン数：" + ChatColor.RED + Daruma.turn);
                }
            }
        };
        timer.schedule(task,3000,1000);
    }
}