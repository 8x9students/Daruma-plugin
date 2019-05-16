package daruma.daruma;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;
import static org.bukkit.Bukkit.getServer;


public class Daruma_commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return false;
        }
        if(args.length==1) {
            switch (args[0].toLowerCase()) {
                case "start":
                    if(Daruma.startpoint==null){
                        sender.sendMessage("スタート地点がありません");
                        return false;
                    }
                    if(Daruma.turn==0){
                        sender.sendMessage("ターンが０です");
                        return false;
                    }
                    Daruma.game=true;
                    Timer timer = new Timer();
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            for (Player target : Bukkit.getOnlinePlayers()) {
                                if (target.getGameMode()== GameMode.ADVENTURE) {
                                    target.teleport(Daruma.startpoint);
                                }
                            }
                            getServer().broadcastMessage(ChatColor.WHITE+"ターン数は"+ChatColor.RED+Daruma.turn+ChatColor.WHITE+"です");
                            getServer().broadcastMessage(ChatColor.WHITE+"5秒後にゲームを開始します…");
                            Daruma.check=true;
                            for (int i=5;i>=1;i--){
                                getServer().broadcastMessage(ChatColor.RED+""+i);
                                try {
                                    sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            new Game().game();
                        }
                    };
                    timer.schedule(task,0);
                    break;
                case "setstartpoint":
                    new Setstartpoint().setstartpoint((Player)sender);
                    break;
                case "end":
                    new End().end();
                    break;
                default:
                    sender.sendMessage("未知のコマンドです");
            }
        }else if(args.length==2) {
            try {
                switch (args[0].toLowerCase()) {
                    case "turn":
                        new Turn().turn(Integer.parseInt(args[1]));
                        break;
                }
            }catch(Exception e){
                e.printStackTrace();
                sender.sendMessage(ChatColor.RED + "エラー");
            }
        }
        return true;
    }
}