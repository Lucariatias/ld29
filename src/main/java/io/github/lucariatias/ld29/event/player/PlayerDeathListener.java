package io.github.lucariatias.ld29.event.player;

import io.github.lucariatias.ld29.event.Listener;

public abstract class PlayerDeathListener extends Listener<PlayerDeathEvent> {

    public PlayerDeathListener() {
        super(PlayerDeathEvent.class);
    }

    public abstract void onPlayerDeath(PlayerDeathEvent event);

    @Override
    public void onEvent(PlayerDeathEvent event) {
        onPlayerDeath(event);
    }
}
