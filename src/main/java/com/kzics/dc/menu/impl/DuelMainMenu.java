package com.kzics.dc.menu.impl;

import com.kzics.dc.menu.DuelConquestMenu;
import com.kzics.dc.menu.MenuConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class DuelMainMenu extends DuelConquestMenu {

    public DuelMainMenu(MenuConfiguration configuration) {
        super(configuration);
    }

    @Override
    public void open(Player player) {
        player.openInventory(inventory);
    }

    @Override
    public void handleClick(InventoryClickEvent e) {

    }

    @Override
    public void handleClose(InventoryCloseEvent e) {

    }
}
