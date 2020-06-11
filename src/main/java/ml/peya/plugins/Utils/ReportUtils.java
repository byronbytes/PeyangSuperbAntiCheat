package ml.peya.plugins.Utils;

import net.md_5.bungee.api.chat.*;
import org.bukkit.*;
import org.bukkit.entity.*;

import java.io.*;

public class ReportUtils
{
    public static void adminNotification(String id)
    {
        for(Player player: Bukkit.getOnlinePlayers())
        {
            if (player.hasPermission("psr.admin"))
            {
                player.sendMessage(ChatColor.GREEN + "[" +
                        ChatColor.BLUE + "PeyangSuperbAntiCheat" +
                        ChatColor.GREEN + "] " +
                        ChatColor.RED + "プレイヤーがレポートを提出しました！");

                ComponentBuilder hover = new ComponentBuilder("/psr show " + id);
                hover.color(net.md_5.bungee.api.ChatColor.AQUA);

                ComponentBuilder builder = new ComponentBuilder(ChatColor.YELLOW + "クリックしてレポートを確認してください！");
                builder.append("[" + ChatColor.YELLOW + ChatColor.BOLD + "CLICK" + ChatColor.WHITE + "]")
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, hover.create()))
                        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/psr show " + id));
                player.spigot().sendMessage(builder.create());
            }
        }
    }

    public static void errorNotification(String stacktrace)
    {
        for(Player player: Bukkit.getOnlinePlayers())
        {
            if (player.hasPermission("psr.admin"))
            {
                player.sendMessage(ChatColor.GREEN + "[" +
                        ChatColor.BLUE + "PeyangSuperbAntiCheat" +
                        ChatColor.GREEN + "] " +
                        ChatColor.RED + "プレイヤーレポートでエラーが発生しました！");

                ComponentBuilder hover = new ComponentBuilder(stacktrace.replace("\r", "\n").replace("\t", "    "));

                ComponentBuilder builder = new ComponentBuilder(ChatColor.YELLOW + "カーソルを合わせて確認してください！");
                builder.append("[" + ChatColor.YELLOW + ChatColor.BOLD + "カーソルを合わせる" + ChatColor.WHITE + "]")
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, hover.create()));
                player.spigot().sendMessage(builder.create());
            }
        }
    }

    public static <T extends Exception> String getStackTrace(T e)
    {
        StringWriter str = new StringWriter();
        PrintWriter w = new PrintWriter(str);
        e.printStackTrace(w);
        w.flush();
        return str.toString();

    }
}