package daruma.daruma;


import org.bukkit.ChatColor;

import static org.bukkit.Bukkit.getServer;

class End {
    void end(){
        Daruma.game=false;
        getServer().broadcastMessage(ChatColor.DARK_RED+"コマンドが実行されました。ゲームを終了します");
    }
}
