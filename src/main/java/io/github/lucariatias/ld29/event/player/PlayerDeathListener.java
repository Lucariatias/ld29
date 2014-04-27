package io.github.lucariatias.ld29.event.player;

import io.github.lucariatias.ld29.event.Listener;
import io.github.lucariatias.ld29.plugin.Plugin;

public abstract class PlayerDeathListener extends Listener<PlayerDeathEvent> {

    public PlayerDeathListener(Plugin plugin) {
        super(plugin, PlayerDeathEvent.class);
    }

    public abstract void onPlayerDeath(PlayerDeathEvent event);

    @Override
    public void onEvent(PlayerDeathEvent event) {
        onPlayerDeath(event);
    }
}
