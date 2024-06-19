package nl.bryansuk.foundationapi.menuitems;

import nl.bryansuk.foundationapi.ItemStackCreator;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

public class FillerGlass extends MenuItem {

    public FillerGlass() {}

    @Override
    public @NotNull ItemStackCreator makeItemStack() {
        return new ItemStackCreator(Material.LIGHT_GRAY_STAINED_GLASS_PANE)
                .setName("")
                .setLore("");
    }


    @Override
    public void onClick(InventoryClickEvent e) {
        e.setCancelled(true);
    }
}
