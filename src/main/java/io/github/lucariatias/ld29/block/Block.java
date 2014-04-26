package io.github.lucariatias.ld29.block;

import io.github.lucariatias.ld29.level.Level;
import io.github.lucariatias.ld29.level.LevelObject;
import io.github.lucariatias.ld29.level.Location;
import io.github.lucariatias.ld29.level.Vector;

import java.awt.*;

public class Block extends LevelObject {

    public Block(Level level) {
        super(level);
        setSolid(true);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(32, 32, 32));
        graphics.fillRect(getLocation().getX(), getLocation().getY(), 32, 32);
        boolean tl = isCollision(getLocation().getRelative(new Vector(-1, -1))); // Top left
        boolean tr = isCollision(getLocation().getRelative(new Vector(1, -1))); // Top right
        boolean bl = isCollision(getLocation().getRelative(new Vector(-1, 1))); // Bottom left
        boolean br = isCollision(getLocation().getRelative(new Vector(1, 1))); // Bottom right
        boolean t = isCollision(getLocation().getRelative(new Vector(0, -1))); // Top
        boolean l = isCollision(getLocation().getRelative(new Vector(-1, 0))); // Left
        boolean r = isCollision(getLocation().getRelative(new Vector(1, 0))); // Right
        boolean b = isCollision(getLocation().getRelative(new Vector(0, 1))); // Bottom
    }

    @Override
    public Rectangle getBoundsAt(Location location) {
        return new Rectangle(location.getX(), location.getY(), 32, 32);
    }
}
