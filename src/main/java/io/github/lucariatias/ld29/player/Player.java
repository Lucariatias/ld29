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
        graphics2D.rotate(Math.toRadians(angle), getLocation().getX(), getLocation().getY());
        graphics2D.drawImage(image, getLocation().getX() - (image.getWidth() / 2), getLocation().getY() - (image.getHeight() / 2), null);
        graphics2D.rotate(-Math.toRadians(angle), getLocation().getX(), getLocation().getY());
        graphics.setColor(Color.WHITE);
        graphics.drawOval(getLocation().getX() - 64, getLocation().getY() - 64, 128, 128);
        graphics.drawLine(getLocation().getX() + image.getWidth(), getLocation().getY(), getLocation().getX() + (image.getWidth() * 2), getLocation().getY());
        graphics.drawLine(getLocation().getX() - image.getWidth(), getLocation().getY(), getLocation().getX() - (image.getWidth() * 2), getLocation().getY());
        graphics.drawLine(getLocation().getX(), getLocation().getY() + image.getHeight(), getLocation().getX(), getLocation().getY() + (image.getHeight() * 2));
        graphics.drawLine(getLocation().getX(), getLocation().getY() - image.getHeight(), getLocation().getX(), getLocation().getY() - (image.getHeight() * 2));
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
