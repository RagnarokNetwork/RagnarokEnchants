package net.ragnaroknetwork.ragnarokenchants;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

public final class RagnarokEnchants extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onEchantItem(EnchantItemEvent event) {
        Map enchantments = event.getEnchantsToAdd();

        enchantments.forEach((key, value) -> {
            Enchantment enchantment = (Enchantment) key;
            if (enchantment.hashCode() == 34) { // Unbreaking
                if ((int) value > 1) {
                    enchantments.put(enchantment, 1);
                }
            }

            if (enchantment.hashCode() == 7) { // Thorns
                if ((int) value > 1) {
                    enchantments.remove(enchantment);
                }
            }
        });
    }
}
