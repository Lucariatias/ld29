package io.github.lucariatias.ld29.event.player;

import io.github.lucariatias.ld29.event.Cancellable;
import io.github.lucariatias.ld29.event.Event;
import io.github.lucariatias.ld29.player.Laser;
import io.github.lucariatias.ld29.player.Player;

public class PlayerShootEvent extends Event implements Cancellable {

    private Player player;
    private Laser laser;
    private boolean cancelled;

    public PlayerShootEvent(Player player, Laser laser) {
        this.player = player;
        this.laser = laser;
    }

    public Player getPlayer() {
        return player;
    }

    public Laser getLaser() {
        return laser;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
