package ml.peya.plugins;

import com.comphenix.protocol.ProtocolManager;
import com.zaxxer.hikari.HikariDataSource;
import ml.peya.plugins.BungeeStructure.CommandManager;
import ml.peya.plugins.DetectClasses.DetectingList;
import ml.peya.plugins.DetectClasses.KillCounting;
import ml.peya.plugins.Gui.Item;
import ml.peya.plugins.Learn.NeuralNetwork;
import ml.peya.plugins.Moderate.Tracker;
import ml.peya.plugins.Module.Modules;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * PSAC全体で使用する変数群を管理します。
 * インスタンス生成はされません。
 */
public class Variables
{
    /**
     * ログを出力する対象をloggerとして格納します。
     */
    public static Logger logger = Logger.getLogger("PeyangSuperbAntiCheat");
    /**
     * プラグインのコンフィグを変更する入れ子。getConfig()により静的化します。
     */
    public static FileConfiguration config;
    /**
     * Watcheyeのデータベースの置き場所が入ります。
     */
    public static String databasePath;
    /**
     * Bankickのデータベースの置き場所が入ります。
     */
    public static String banKickPath;
    /**
     * Trustのデータベースの置き場所が入ります。
     */
    public static String trustPath;
    /**
     * BungeeCordのチャンネルです。
     */
    public static String bungeeChannel;
    /**
     * いろいろ値を入手するのに使います。
     * 地味に便利。
     */
    public static DetectingList cheatMeta;
    /**
     * キル回数をグローバルに格納するらしいです。意味わからんけど。
     */
    public static KillCounting counting;
    /**
     * ProtocolLibでNetな対策をばっちり行います。
     */
    public static ProtocolManager protocolManager;
    /**
     * ヘルプの表示とかに使います。
     * 後で色々追加されるヤツ。
     */
    public static Item item;
    /**
     * {@code CommandTracking}で追跡が入った時にこの値に動きがあるそうです。
     */
    public static Tracker tracker;
    /**
     * {@code CommandMods}に関与するクラスの関数とかで出てきたmodsをここに格納するそうです。
     */
    public static HashMap<UUID, HashMap<String, String>> mods;
    /**
     * 定期メッセージに使います。なんかあったのか初期化されてる。
     */
    public static long time = 0L;
    /**
     * まだ学習しきれていないひよっこAIの代わりにVLリミットとして登場します。
     */
    public static int banLeft;
    /**
     * この数を超えたらムキムキAIが代わりにキック評価をしてくれるようになります。
     */
    public static int learnCountLimit;
    /**
     * 学習回数がここに格納されるそうです。
     */
    public static int learnCount;
    /**
     * AIの脳ですね(パワーワード)。
     * ここにlearn()関数などをぶち込みます。
     */
    public static NeuralNetwork network;
    /**
     * Watcheyeデータベースをデシリアライズしてあげます。
     */
    public static HikariDataSource eye;
    /**
     * Bankickデータベースをデシリアライズしてやります。
     */
    public static HikariDataSource banKick;
    /**
     * Trustデータベースをデシリアライズしときます。
     */
    public static HikariDataSource trust;
    /**
     * Skinデータベースをデシリアライズしときます。
     */
    public static HikariDataSource skin;
    /**
     * 定期メッセージが有効になっているかどうか。
     */
    public static boolean isAutoMessageEnabled;
    /**
     * Trackingが有効だったまま投げ出していたかどうか。
     */
    public static boolean isTrackEnabled;
    /**
     * バンジー存在チェック
     */
    public static boolean bungeeCord;
    /**
     * 初期化完了
     */
    public static boolean initialized;
    /**
     * どういう定期メッセージを行うのかのアクション。
     */
    public static BukkitRunnable autoMessage;
    /**
     * Tracking時にやること。
     */
    public static BukkitRunnable trackerTask;
    /**
     * BungeeCord共通コマンド
     */
    public static CommandManager bungeeCommand;
    /**
     * モジュール
     */
    public static Modules module;
}