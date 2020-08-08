package ml.peya.plugins.Commands.CmdTst;

import ml.peya.plugins.Detect.*;
import ml.peya.plugins.Enum.*;
import ml.peya.plugins.*;
import ml.peya.plugins.Moderate.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

import java.util.*;

public class AuraPanic implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (ErrorMessageSender.unPermMessage(sender, "psac.aurapanic") || ErrorMessageSender.invalidLengthMessage(sender, args, 1, 2))
            return true;

        int count = 5;

        Player player = Bukkit.getPlayer(args[0]);
        boolean reachModeEnabled = false;
        if (args.length == 2 && args[0].equals("-r"))
        {
            player = Bukkit.getPlayer(args[1]);
            reachModeEnabled = true;
        }
        if (player == null)
        {
            sender.sendMessage(MessageEngine.get("error.playerNotFound"));

            return true;
        }

        if (TrustModifier.isTrusted(player) && !player.hasPermission("psac.trust"))
        {
            sender.sendMessage(MessageEngine.get("error.trusted"));
            return true;
        }

        if (PeyangSuperbAntiCheat.cheatMeta.exists(player.getUniqueId()))
        {
            sender.sendMessage(MessageEngine.get("error.aura.testingNow"));

            return true;
        }

        if (!PeyangSuperbAntiCheat.config.getBoolean("message.lynx"))
        {
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", player.getDisplayName() + (player.getDisplayName().equals(player.getName()) ? "": (" (" + player.getName() + ") ")));
            map.put("type", "AuraPanicBot");
            map.put("seconds", String.valueOf(PeyangSuperbAntiCheat.config.getInt("npc.seconds")));

            sender.sendMessage(MessageEngine.get("message.aura.summon", map));
        }
        else
            sender.sendMessage(MessageEngine.get("message.aura.lynx"));

        if (args.length == 2)
        {
            try
            {
                count = Integer.parseInt(args[1]);
            }
            catch (Exception e)
            {
                sender.sendMessage(MessageEngine.get("error.invalidArgument"));
                return true;
            }

        }

        DetectType type = DetectType.AURA_PANIC;
        type.setPanicCount(count);
        type.setSender(sender);

        DetectConnection.scan(player, type, sender, reachModeEnabled);
        return true;
    }
}
