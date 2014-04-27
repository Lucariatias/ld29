package io.github.lucariatias.ld29.event.player;

import io.github.lucariatias.ld29.event.Listener;
import io.github.lucariatias.ld29.plugin.Plugin;

public abstract class PlayerLivesChangeListener extends Listener<PlayerLivesChangeEvent> {

    public PlayerLivesChangeListener(Plugin plugin) {
        super(plugin, PlayerLivesChangeEvent.class);
    }

    public abstract void onPlayerLivesChange(PlayerLivesChangeEvent event);

    @Override
    public void onEvent(PlayerLivesChangeEvent event) {
        onPlayerLivesChange(event);
    }

}
