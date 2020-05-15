package ml.peya.plugins.Utils;

import ml.peya.plugins.Enum.*;
import ml.peya.plugins.*;
import org.bukkit.entity.*;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class WatchEyeManagement
{
    public static String add(Player target, String FromName, String FromUUID, int level)
    {
        String manageId = UUID.randomUUID().toString().replace("-", "");
        try(Connection connection = PeyangSuperbAntiCheat.hManager.getConnection();
            Statement statement = connection.createStatement())
        {
            statement.execute(String.format("INSERT INTO watcheye VALUES ('%s', '%s', %s, '%s', '%s', '%s', %s)",
                    target.getUniqueId().toString().replace("-", ""),
                    target.getName(),
                    new Date().getTime(),
                    FromName,
                    FromUUID,
                    manageId,
                    level));
            statement.close();
            return manageId;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            ReportUtils.errorNotification(ReportUtils.getStackTrace(e));
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
            ReportUtils.errorNotification(ReportUtils.getStackTrace(e));
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
            ReportUtils.errorNotification(ReportUtils.getStackTrace(e));
            return false;
        }
    }


    public static boolean isExistsRecord(String id)
    {
        try (Connection connection = PeyangSuperbAntiCheat.hManager.getConnection();
             Statement statement = connection.createStatement())
        {
            ResultSet result = statement.executeQuery("SELECT * FROM watcheye WHERE MNGID = '" + id + "'");
            return result.isBeforeFirst();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ReportUtils.errorNotification(ReportUtils.getStackTrace(e));
            return false;
        }
    }

}
