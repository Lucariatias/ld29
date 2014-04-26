package io.github.lucariatias.ld29.player;

import io.github.lucariatias.ld29.level.Level;
import io.github.lucariatias.ld29.level.LevelObject;
import io.github.lucariatias.ld29.level.Location;
import io.github.lucariatias.ld29.level.Vector;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends LevelObject {

    private BufferedImage image;

    private int speed = 4;
    private int angle;

    private boolean dead;
    private int explodeRadius = 1;

    public Player(Level level, BufferedImage image) {
        super(level);
        this.image = image;
    }

    @Override
    public void render(Graphics graphics) {
        if (!dead) {
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
        } else {
                graphics.setColor(Color.RED);
                graphics.drawOval(getLocation().getX() - explodeRadius, getLocation().getY() - explodeRadius, explodeRadius * 2, explodeRadius * 2);
        }
    }

    @Override
    public Rectangle getBoundsAt(Location location) {
        return new Rectangle(location.getX() - (image.getWidth() / 2), location.getY() - (image.getHeight() / 2), image.getWidth(), image.getHeight());
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    @Override
    public void onTick() {
        if (!dead) {
            setDirection(new Vector((int) Math.round(speed * Math.sin(Math.toRadians(90 - angle))), (int) Math.round(speed * Math.cos(Math.toRadians(90 - angle)))));
            if (!isCollision(getLocation().getRelative(getDirection()))) {
                setLocation(getLocation().getRelative(getDirection()));
            } else {
                die();
            }
        } else {
            explodeRadius = explodeRadius < 1280 ? explodeRadius + 16 : explodeRadius;
        }
    }

    public void die() {
        dead = true;
    }

    public void reset() {
        dead = false;
        explodeRadius = 1;
        angle = 0;
    }

}
