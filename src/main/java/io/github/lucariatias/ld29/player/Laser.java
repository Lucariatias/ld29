package io.github.lucariatias.ld29.player;

import io.github.lucariatias.ld29.block.BreakableBlock;
import io.github.lucariatias.ld29.level.Level;
import io.github.lucariatias.ld29.level.LevelObject;
import io.github.lucariatias.ld29.level.Location;
import io.github.lucariatias.ld29.level.Vector;

import java.awt.*;

public class Laser extends LevelObject {

    private static final double LENGTH = 32D;

    private Camera camera;

    private int speed = 8;
    private int angle;
    private boolean dead;

    private int explodeRadius;

    public Laser(Level level, Camera camera, Location location, int angle) {
        super(level);
        this.camera = camera;
        setLocation(location);
        this.angle = angle;
    }

    @Override
    public void render(Graphics graphics) {
        if (!dead) {
            Location startLocation = getLocation();
            Location endLocation = getEndLocation();
            graphics.setColor(Color.RED);
            graphics.drawLine(startLocation.getX(), startLocation.getY(), endLocation.getX(), endLocation.getY());
        } else {
            graphics.setColor(Color.RED);
            graphics.drawOval(getLocation().getX() - explodeRadius, getLocation().getY() - explodeRadius, explodeRadius * 2, explodeRadius * 2);
        }
    }

    public Location getEndLocation() {
        return getEndLocationAt(getLocation());
    }

    private Location getEndLocationAt(Location location) {
        return new Location((int) Math.round((double) location.getX() + (LENGTH * Math.sin(Math.toRadians(90 - angle)))), (int) Math.round((double) location.getY() + (LENGTH * Math.cos(Math.toRadians(90 - angle)))));
    }

    @Override
    public Rectangle getBoundsAt(Location location) {
        return new Rectangle(getEndLocationAt(location).getX() - 8, getEndLocationAt(location).getY() - 8, 16, 16);
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
        if (camera.getLocation().distanceSquared(getLocation()) > 640000) getLevel().removeObject(this);
        if (!dead) {
            setDirection(new Vector((int) Math.round(speed * Math.sin(Math.toRadians(90 - angle))), (int) Math.round(speed * Math.cos(Math.toRadians(90 - angle)))));
            Location newLocation = getLocation().getRelative(getDirection());
            if (!isCollision(newLocation)) {
                setLocation(newLocation);
            } else {
                LevelObject collidingObject = getCollision(newLocation);
                if (collidingObject instanceof BreakableBlock) {
                    collidingObject.die();
                }
                die();
            }
        } else {
            explodeRadius = explodeRadius < 64 ? explodeRadius + 2 : 64;
            if (explodeRadius == 64) {
                getLevel().removeObject(this);
            }
        }
    }

    @Override
    public void die() {
        dead = true;
    }

}
