package ml.peya.plugins.Gui.Events;

import ml.peya.plugins.Gui.*;
import ml.peya.plugins.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.*;

import java.util.*;

/**
 * イベントの根本的なやつ。
 */
public class Run implements Listener
{
    /**
     * Interactイベント...らしい。
     *
     * @param e なんか使ったときに発令するイベント。
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInteract(PlayerInteractEvent e)
    {
        ItemStack itemStack = e.getItem();

        if (e.getItem() == null || e.getItem().getType() == Material.AIR || Item.canGuiItem(itemStack)) return;

        e.setCancelled(true);

        Item item = PeyangSuperbAntiCheat.item;

        for (IItems items : item.getItems())
        {
            String type = items.getExecName();
            if (Objects.equals(Item.getType(itemStack), type))
                items.run(e.getPlayer(), Item.getTarget(itemStack));
        }
    }
}
