package io.github.lucariatias.ld29.pickup;

import io.github.lucariatias.ld29.Descent;
import io.github.lucariatias.ld29.level.Level;
import io.github.lucariatias.ld29.level.LevelObject;
import io.github.lucariatias.ld29.level.Location;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Pickup extends LevelObject {

    private Descent descent;

    private BufferedImage image;
    private String name;

    private boolean dead;
    private int effectRadius = 1;

    public Pickup(Descent descent, Level level, BufferedImage image) {
        super(level);
        setSolid(true);
        this.image = image;
        this.descent = descent;
    }

    @Override
    public void render(Graphics graphics) {
        if (!dead) {
            graphics.drawImage(image, getLocation().getX(), getLocation().getY(), null);
        } else {
            graphics.setColor(Color.YELLOW);
            graphics.drawOval(getLocation().getX() - effectRadius, getLocation().getY() - effectRadius, effectRadius * 2, effectRadius * 2);
        }
    }

    @Override
    public Rectangle getBoundsAt(Location location) {
        return dead ? new Rectangle(location.getX(), location.getY(), 0, 0) : new Rectangle(location.getX(), location.getY(), image.getWidth(), image.getHeight());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void onTick() {
        if (dead) effectRadius = effectRadius < 64 ? effectRadius + 4 : 64;
        if (effectRadius == 64) getLevel().removeObject(this);
    }

    public void onPickup() {
        descent.getNotificationManager().queueMessage("Picked up " + getName() + "!");
        die();
    }

    public Descent getDescent() {
        return descent;
    }

    @Override
    public void die() {
        dead = true;
    }

}
