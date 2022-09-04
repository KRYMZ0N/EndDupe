package me.krymz0n.enddupe;

import com.destroystokyo.paper.event.entity.EntityTeleportEndGatewayEvent;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

    }

    @EventHandler
    public void onTeleport(EntityTeleportEndGatewayEvent evt) { //TODO Need to test
        if (isChestable(evt.getEntity())) {
            if (evt.getEntity() instanceof ChestedHorse) {
                ChestedHorse ch = (ChestedHorse) evt.getEntity();

                Inventory inv = ch.getInventory();

                if (ch.getHealth() < 1) {
                   World w = Bukkit.getServer().getWorld(Objects.requireNonNull(evt.getTo()).getWorld().getUID());

                    assert w != null;
                    w.dropItemNaturally(evt.getTo(), new ItemStack((ItemStack) inv));
                }


            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private boolean isChestable(Entity e) {
        return e.getType() == EntityType.DONKEY || e.getType() == EntityType.MULE || e.getType() == EntityType.LLAMA;
    }
}
