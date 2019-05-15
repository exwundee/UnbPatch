package xyz.exwundee.unbpatch.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class WalkEvent implements Listener {

    /**
     * I understand this is not the best way to do it,
     * but John needs this ASAP and I can't be bothered
     * to make this more complex than **he** needs it to be.
     */

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        boolean hasUnbreakables = false;
        for (ItemStack itemStack : event.getPlayer().getInventory().getContents()) {
            if (isUnbreakable(itemStack)) {
                itemStack.setDurability(itemStack.getType().getMaxDurability());
                hasUnbreakables = true;
            }
        }
        if (hasUnbreakables == true) {
            event.getPlayer().sendMessage("§cBy the power of §4§lHOHN§c, your unbreakables have been removed.");
        }
    }

    public boolean isUnbreakable(ItemStack itemStack) {
        if (itemStack.getDurability() > itemStack.getType().getMaxDurability()) return true;
        return false;
    }

}
