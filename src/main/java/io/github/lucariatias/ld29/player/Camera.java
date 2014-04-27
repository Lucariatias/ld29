package io.github.lucariatias.ld29.player;

import io.github.lucariatias.ld29.level.Location;
import io.github.lucariatias.ld29.level.Vector;

public class Camera {

    private Vector offset;
    private Location location;
    private Player player;

    public Camera(Player player) {
        this.offset = new Vector(-320, -240);
        this.location = player.getLocation().getRelative(offset);
        this.player = player;
    }

    public void onTick() {
        this.location = player.getLocation().getRelative(offset);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
