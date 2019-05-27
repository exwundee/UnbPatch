package xyz.exwundee.unbpatch.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

/**
 **     Created by x1D on 05-15-2019.
 **/
public class WalkEvent implements Listener {

    /**
     * I understand this is not the best way to do it,
     * but John needs this ASAP and I can't be bothered
     * to make this more complex than **he** needs it to be.
     */

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        for (ItemStack itemStack : event.getPlayer().getInventory().getContents()) {
            boolean h = false;
            if (itemStack != null && isUnbreakable(itemStack) && itemStack.getType().isItem() && !itemStack.getType().isEdible()) {
                itemStack.setDurability((short) 0);
                event.getPlayer().updateInventory();
                h = true;
            }
            if (h == true) {
                event.getPlayer().sendMessage("§cBy the power of §4§lHOHN§c, your unbreakables have been removed.");
            }
        }
    }

    public boolean isUnbreakable(ItemStack itemStack) {
        if (itemStack.getDurability() < 0 || itemStack.getDurability() > itemStack.getType().getMaxDurability())
            return true;
        else return false;
    }

}
