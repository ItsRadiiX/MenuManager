package nl.bryansuk.foundationapi.listeners;

import nl.bryansuk.foundationapi.menumanager.Menu;
import nl.bryansuk.foundationapi.menuitems.MenuItem;
import nl.bryansuk.foundationapi.menumanager.PaginatedMenu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class MenuListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        InventoryHolder holder = e.getInventory().getHolder();

        if (holder instanceof Menu menu) {
            ItemStack currentItem = e.getCurrentItem();
            if (currentItem == null) return;

            int slotClicked = e.getSlot();

            MenuItem menuItem = menu.getMenuItems().get(slotClicked);
            if (menuItem == null) {
                if (holder instanceof PaginatedMenu paginatedMenu){
                    menuItem = paginatedMenu.getPageMenuItems().get(slotClicked);
                }
            }

            if (menuItem == null) return;

            if (menuItem.getItemStack().equals(currentItem)) {
                menuItem.onClick(e);
            } else {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onMenuClose(InventoryCloseEvent e){

        InventoryHolder holder = e.getInventory().getHolder();

        if (holder instanceof Menu menu){
            menu.closeLogic();
        }

    }

}
