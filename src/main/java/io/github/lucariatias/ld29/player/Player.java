package io.github.lucariatias.ld29.player;

import io.github.lucariatias.ld29.level.Level;
import io.github.lucariatias.ld29.level.LevelObject;
import io.github.lucariatias.ld29.level.Location;
import io.github.lucariatias.ld29.level.Vector;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends LevelObject {

    private static final int SPEED = 4;

    private BufferedImage image;

    private int angle;

    public Player(Level level, BufferedImage image) {
        super(level);
        this.image = image;
    }

    @Override
    public void render(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.rotate(Math.toRadians(angle), getLocation().getX(), getLocation().getY());
        graphics2D.drawImage(image, getLocation().getX() - (image.getWidth() / 2), getLocation().getY() - (image.getHeight() / 2), null);
        graphics2D.rotate(-Math.toRadians(angle), getLocation().getX(), getLocation().getY());
        graphics.setColor(Color.WHITE);
        graphics.drawOval(getLocation().getX() - 48, getLocation().getY() - 48, 96, 96);
        graphics.drawLine(getLocation().getX() + image.getWidth(), getLocation().getY(), getLocation().getX() + (image.getWidth() * 2), getLocation().getY());
        graphics.drawLine(getLocation().getX() - image.getWidth(), getLocation().getY(), getLocation().getX() - (image.getWidth() * 2), getLocation().getY());
        graphics.drawLine(getLocation().getX(), getLocation().getY() + image.getHeight(), getLocation().getX(), getLocation().getY() + (image.getHeight() * 2));
        graphics.drawLine(getLocation().getX(), getLocation().getY() - image.getHeight(), getLocation().getX(), getLocation().getY() - (image.getHeight() * 2));
        graphics.setColor(Color.GREEN);
        Location startLocation = new Location((int) Math.round((double) getLocation().getX() + (double) image.getWidth() * Math.sin(Math.toRadians(90 - angle))), (int) Math.round((double) getLocation().getY() + (double) image.getHeight() * Math.cos(Math.toRadians(90 - angle))));
        Location endLocation = new Location((int) Math.round((double) getLocation().getX() + ((double) image.getWidth() * 2D) * Math.sin(Math.toRadians(90 - angle))), (int) Math.round((double) getLocation().getY() + ((double) image.getHeight() * 2D) * Math.cos(Math.toRadians(90 - angle))));
        graphics.drawLine(startLocation.getX(), startLocation.getY(), endLocation.getX(), endLocation.getY());
    }

    @Override
    public Rectangle getBoundsAt(Location location) {
        return new Rectangle(location.getX() - (image.getWidth() / 2), location.getY() - (image.getHeight() / 2), image.getWidth(), image.getHeight());
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    @Override
    public void onTick() {
        setDirection(new Vector((int) Math.round(SPEED * Math.sin(Math.toRadians(90 - angle))), (int) Math.round(SPEED * Math.cos(Math.toRadians(90 - angle)))));
        super.onTick();
    }

}
