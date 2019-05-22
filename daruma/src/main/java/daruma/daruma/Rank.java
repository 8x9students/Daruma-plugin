package daruma.daruma;

import static org.bukkit.Bukkit.getServer;

class Rank {
    void rank(){
        for(int i=0;i<=10;i++){
            getServer().broadcastMessage(Daruma.list.get(i));
        }
    }
}
