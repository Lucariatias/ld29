package io.github.lucariatias.ld29.block;

import io.github.lucariatias.ld29.level.Level;
import io.github.lucariatias.ld29.level.LevelObject;
import io.github.lucariatias.ld29.level.Location;

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
    }

    @Override
    public Rectangle getBoundsAt(Location location) {
        return new Rectangle(location.getX(), location.getY(), 32, 32);
    }
}
