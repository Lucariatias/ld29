package io.github.lucariatias.ld29.event.player;

import io.github.lucariatias.ld29.event.Cancellable;
import io.github.lucariatias.ld29.pickup.Pickup;
import io.github.lucariatias.ld29.player.Player;

public class PlayerCollectPickupEvent extends PlayerEvent implements Cancellable {

    private Pickup pickup;
    private boolean cancelled;

    public PlayerCollectPickupEvent(Player player, Pickup pickup) {
        super(player);
        this.pickup = pickup;
    }

    public Pickup getPickup() {
        return pickup;
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
