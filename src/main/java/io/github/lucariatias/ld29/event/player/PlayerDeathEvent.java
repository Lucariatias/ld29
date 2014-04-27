package io.github.lucariatias.ld29.event.player;

import io.github.lucariatias.ld29.event.Event;
import io.github.lucariatias.ld29.player.Player;

public class PlayerDeathEvent extends Event {

    private Player player;

    public PlayerDeathEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

}
