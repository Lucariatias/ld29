package io.github.lucariatias.ld29.event.player;

import io.github.lucariatias.ld29.event.Cancellable;
import io.github.lucariatias.ld29.player.Laser;
import io.github.lucariatias.ld29.player.Player;

public class PlayerShootEvent extends PlayerEvent implements Cancellable {

    private Laser laser;
    private boolean cancelled;

    public PlayerShootEvent(Player player, Laser laser) {
        super(player);
        this.laser = laser;
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
