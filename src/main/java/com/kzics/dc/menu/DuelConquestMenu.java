package com.kzics.dc.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public abstract class DuelConquestMenu implements InventoryHolder {

    protected String title;
    protected int size;
    protected Inventory inventory;

    public DuelConquestMenu(MenuConfiguration config) {
        this.title = config.getTitle();
        this.size = config.getSize();
        this.inventory = Bukkit.createInventory(this, size, title);
        initializeItems(config);
    }

    private void initializeItems(MenuConfiguration config) {
        for (Map.Entry<Integer, ItemStack> entry : config.getItems().entrySet()) {
            inventory.setItem(entry.getKey(), entry.getValue());
        }
    }

    public abstract void open(Player player);

    public abstract void handleClick(InventoryClickEvent e);

    public abstract void handleClose(InventoryCloseEvent e);

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}