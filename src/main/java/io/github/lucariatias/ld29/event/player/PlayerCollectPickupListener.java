package io.github.lucariatias.ld29.event.player;

import io.github.lucariatias.ld29.event.Listener;
import io.github.lucariatias.ld29.plugin.Plugin;

public abstract class PlayerCollectPickupListener extends Listener<PlayerCollectPickupEvent> {

    public PlayerCollectPickupListener(Plugin plugin) {
        super(plugin, PlayerCollectPickupEvent.class);
    }

    public abstract void onPlayerCollectPickup(PlayerCollectPickupEvent event);

    @Override
    public void onEvent(PlayerCollectPickupEvent event) {
        onPlayerCollectPickup(event);
    }

}
