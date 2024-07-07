package com.kzics.dc.menu;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuConfiguration {

    private String title;
    private int size;
    private Map<Integer, ItemStack> items;

    public MenuConfiguration(File file) {
        loadConfig(file);
    }

    private void loadConfig(File file) {
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        this.title = config.getString("menu.title");
        this.size = config.getInt("menu.size");
        this.items = new HashMap<>();

        for (String key : config.getConfigurationSection("menu.items").getKeys(false)) {
            int slot = Integer.parseInt(key);
            String type = config.getString("menu.items." + key + ".type");
            if(type == null) continue;
            
            String name = config.getString("menu.items." + key + ".name");
            List<String> lore = config.getStringList("menu.items." + key + ".lore");
            Map<String, Object> enchantments = config.getConfigurationSection("menu.items." + key + ".enchantments").getValues(false);
            int amount = config.getInt("menu.items." + key + ".amount", 1);

            ItemStack item = new ItemStack(Material.getMaterial(type), amount);
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                if (name != null) meta.setDisplayName(name);
                if (lore != null) meta.setLore(lore);

                for (Map.Entry<String, Object> enchantEntry : enchantments.entrySet()) {
                    Enchantment enchantment = Enchantment.getByName(enchantEntry.getKey());
                    int level = (int) enchantEntry.getValue();
                    if (enchantment != null) {
                        meta.addEnchant(enchantment, level, true);
                    }
                }

                item.setItemMeta(meta);
            }

            items.put(slot, item);
        }
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

    public Map<Integer, ItemStack> getItems() {
        return items;
    }
}
