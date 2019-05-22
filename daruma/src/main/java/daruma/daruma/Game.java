package daruma.daruma;

import org.bukkit.ChatColor;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;
import static org.bukkit.Bukkit.getServer;

class Game {
    void game() {
        Timer timer = new Timer(false);
        TimerTask task =new TimerTask() {
            int count = 0;
            int turn = Daruma.turn;
            @Override
            public void run() {
                if(turn==0){
                    getServer().broadcastMessage(ChatColor.WHITE + "終了！");
                    Daruma.check=false;
                    timer.cancel();
                }
                if(!Daruma.game){
                    Daruma.check=false;
                    timer.cancel();
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
                    Daruma.move=true;
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count=0;
                    turn--;
                    Daruma.move=false;
                    getServer().broadcastMessage(ChatColor.WHITE + "残りターン数：" + ChatColor.RED + turn);
                }
            }
        };
        timer.schedule(task,0,1000);
    }
}