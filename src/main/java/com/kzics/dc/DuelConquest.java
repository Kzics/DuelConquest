package com.kzics.dc;

import org.bukkit.plugin.java.JavaPlugin;

public class DuelConquest extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("DuelConquest has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("DuelConquest has been disabled!");
    }

}
