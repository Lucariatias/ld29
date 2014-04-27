package io.github.lucariatias.ld29.event.player;

import io.github.lucariatias.ld29.event.Listener;
import io.github.lucariatias.ld29.plugin.Plugin;

public abstract class PlayerShootListener extends Listener<PlayerShootEvent> {

    public PlayerShootListener(Plugin plugin) {
        super(plugin, PlayerShootEvent.class);
    }

    public abstract void onPlayerShoot(PlayerShootEvent event);

    @Override
    public void onEvent(PlayerShootEvent event) {
        onPlayerShoot(event);
    }
}
