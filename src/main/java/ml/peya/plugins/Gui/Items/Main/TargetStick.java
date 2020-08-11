package ml.peya.plugins.Gui.Items.Main;

import ml.peya.plugins.Gui.Item;
import ml.peya.plugins.Gui.*;
import ml.peya.plugins.Utils.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import static ml.peya.plugins.Utils.LookingUtils.getLookingEntity;

/**
 * ターゲットを再設定するユーティリティアイテム(ブレイズロッド)を管理します。
 */
public class TargetStick implements IItems
{
    /**
     * イベント発動時の処理をオーバーライドします。
     *
     * @param player メンチを切る側のプレイヤー。
     * @param target オーバーライドのために必要だと思われる。実際は必要ない。
     */
    @Override
    public void run(Player player, String target)
    {
        Player lookingPlayer = getLookingEntity(player);
        if (lookingPlayer == null)
        {
            player.sendMessage(MessageEngine.get("error.notPlayerFoundInRange"));
            return;
        }
        player.performCommand("target " + lookingPlayer.getName());
    }

    /**
     * アイテムを取得する関数のオーバーライド。どのようなアイテムを返すか、どのような動きをするか、などと言った詳細をこの関数で設定し、アイテムとして返す。
     *
     * @param target ターゲットが誰であるか。
     *
     * @returns 関数内の処理によって設定されたアイテム。
     */
    @Override
    public ItemStack getItem(String target)
    {
        ItemStack stack = new ItemStack(Material.BLAZE_ROD);

        ItemMeta meta = stack.getItemMeta();

        meta.setLore(Item.getLore(this, target));

        meta.setDisplayName(MessageEngine.get("item.targetStick"));

        stack.setItemMeta(meta);
        return stack;
    }

    /**
     * インベントリに空きスペースがあるかどうかを確認する関数のオーバーライド。この関数は使わないため実装は不要。
     *
     * @returns 実装は不要なためfalse。
     */
    @Override
    public boolean canSpace()
    {
        return false;
    }

    /**
     * どのようなIDであるか取得する。詳細はPSACドキュメントを参照。
     *
     * @returns このアイテムの実行ID。
     */
    @Override
    public String getExecName()
    {
        return "TARGET_STICK";
    }

    /**
     * どのようなタイプであるか取得する。
     *
     * @returns ほぼMAIN。大体MAIN。
     */
    @Override
    public Type getType()
    {
        return Type.MAIN;
    }

}
