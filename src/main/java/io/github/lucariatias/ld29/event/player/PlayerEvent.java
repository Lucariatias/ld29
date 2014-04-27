package io.github.lucariatias.ld29.event.player;

import io.github.lucariatias.ld29.event.Event;
import io.github.lucariatias.ld29.player.Player;

public abstract class PlayerEvent extends Event {

    private Player player;

    public PlayerEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

}
