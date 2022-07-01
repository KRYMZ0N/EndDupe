package me.krymz0n.enddupe;

import com.destroystokyo.paper.event.entity.EntityTeleportEndGatewayEvent;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @EventHandler
    public void onTeleport(EntityTeleportEndGatewayEvent evt) { //TODO Need to look into abstract horse inv, and also how to actually do this lmfao.
        if (isChestable(evt.getEntity())) {
            if (evt.getEntity() instanceof ChestedHorse) {
                ChestedHorse ch = (ChestedHorse) evt.getEntity();

                ch.getInventory();


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
