package io.github.lucariatias.ld29.player;

import io.github.lucariatias.ld29.level.LevelObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends LevelObject {

    private BufferedImage image;

    private int angle;

    public Player(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void render(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.rotate(Math.toRadians(angle), getLocation().getX() + (image.getWidth() / 2), getLocation().getY() + (image.getHeight() / 2));
        graphics2D.drawImage(image, getLocation().getX(), getLocation().getY(), null);
        graphics2D.rotate(-Math.toRadians(angle), getLocation().getX() + (image.getWidth() / 2), getLocation().getY() + (image.getHeight() / 2));
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getLocation().getX(), getLocation().getY(), image.getWidth(), image.getHeight());
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

}
