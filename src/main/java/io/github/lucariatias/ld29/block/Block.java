package io.github.lucariatias.ld29.block;

import io.github.lucariatias.ld29.level.LevelObject;

import java.awt.*;

public class Block extends LevelObject {

    public Block() {
        setSolid(true);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(32, 32, 32));
        graphics.fillRect(getLocation().getX(), getLocation().getY(), 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
