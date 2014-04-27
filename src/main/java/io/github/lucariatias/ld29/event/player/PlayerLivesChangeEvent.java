package io.github.lucariatias.ld29.event.player;

import io.github.lucariatias.ld29.event.Cancellable;
import io.github.lucariatias.ld29.player.Player;

public class PlayerLivesChangeEvent extends PlayerEvent implements Cancellable {

    private int oldLives;
    private int newLives;
    private boolean cancelled;

    public PlayerLivesChangeEvent(Player player, int oldLives, int newLives) {
        super(player);
        this.oldLives = oldLives;
        this.newLives = newLives;
    }

    public int getOldLives() {
        return oldLives;
    }

    public void setOldLives(int oldLives) {
        this.oldLives = oldLives;
    }

    public int getNewLives() {
        return newLives;
    }

    public void setNewLives(int newLives) {
        this.newLives = newLives;
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
