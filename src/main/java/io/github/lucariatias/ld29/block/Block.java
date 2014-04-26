package io.github.lucariatias.ld29.block;

import io.github.lucariatias.ld29.level.Level;
import io.github.lucariatias.ld29.level.LevelObject;
import io.github.lucariatias.ld29.level.Location;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Block extends LevelObject {

    private BufferedImage image;
    private Rectangle bounds;

    public Block(Level level, BufferedImage image) {
        super(level);
        this.image = image;
        setSolid(true);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(image, getLocation().getX(), getLocation().getY(), null);
    }

    @Override
    public Rectangle getBoundsAt(Location location) {
        return new Rectangle(location.getX() + (int) bounds.getX(), location.getY() + (int) bounds.getY(), (int) bounds.getWidth(), (int) bounds.getHeight());
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
