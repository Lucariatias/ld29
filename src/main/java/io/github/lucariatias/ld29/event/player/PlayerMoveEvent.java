package io.github.lucariatias.ld29.event.player;

import io.github.lucariatias.ld29.event.Cancellable;
import io.github.lucariatias.ld29.level.Location;
import io.github.lucariatias.ld29.player.Player;

public class PlayerMoveEvent extends PlayerEvent implements Cancellable {

    private Location from;
    private Location to;
    private boolean cancelled;

    public PlayerMoveEvent(Player player, Location from, Location to) {
        super(player);
        this.from = from;
        this.to = to;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
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
