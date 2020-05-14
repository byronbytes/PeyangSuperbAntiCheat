package ml.peya.plugins;

import ml.peya.plugins.Enum.*;
import org.bukkit.entity.*;

import javax.swing.plaf.nimbus.*;
import java.sql.*;
import java.util.*;

public class WatchEyeManagement
{
    public static String add(Player target, String FromName, String FromUUID)
    {
        String manageId = UUID.randomUUID().toString().replace("-", "");
        try(Connection connection = PeyangSuperbAntiCheat.hManager.getConnection();
            Statement statement = connection.createStatement())
        {
            statement.execute(String.format("INSERT INTO watcheye VALUES ('%s', '%s', %s, '%s', '%s', '%s')",
                    target.getUniqueId().toString().replace("-", ""),
                    target.getName(),
                    System.currentTimeMillis(),
                    FromName,
                    FromUUID,
                    manageId));
            statement.close();
            return manageId;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean setReason(String id, EnumCheatType reason, int vl)
    {
        try(Connection connection = PeyangSuperbAntiCheat.hManager.getConnection();
            Statement statement = connection.createStatement())
        {
            String reasonString = reason.getSysName();
            if (reasonString.endsWith(" "))
                reasonString = reasonString.substring(0, reasonString.length() - 1);
            statement.execute(String.format("INSERT INTO watchreason VALUES ('%s', '%s', %s)",
                    id,
                    reasonString,
                    vl));
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isExistsRecord(String targetUuid, String fromUuid)
    {
        try (Connection connection = PeyangSuperbAntiCheat.hManager.getConnection();
            Statement statement = connection.createStatement())
        {
            ResultSet result = statement.executeQuery("SELECT * FROM watcheye WHERE UUID = '" + targetUuid + "' AND ISSUEBYUUID = '" + fromUuid + "'");
            return result.isBeforeFirst();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}