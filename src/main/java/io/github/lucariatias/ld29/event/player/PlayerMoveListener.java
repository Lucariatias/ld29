package io.github.lucariatias.ld29.event.player;

import io.github.lucariatias.ld29.event.Listener;
import io.github.lucariatias.ld29.plugin.Plugin;

public abstract class PlayerMoveListener extends Listener<PlayerMoveEvent> {

    public PlayerMoveListener(Plugin plugin, Class<PlayerMoveEvent> event) {
        super(plugin, event);
    }

    public abstract void onPlayerMove(PlayerMoveEvent event);

    @Override
    public void onEvent(PlayerMoveEvent event) {
        onPlayerMove(event);
    }

}
