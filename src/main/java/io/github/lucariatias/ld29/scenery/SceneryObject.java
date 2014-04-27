package io.github.lucariatias.ld29.scenery;

import io.github.lucariatias.ld29.level.Level;
import io.github.lucariatias.ld29.level.LevelObject;
import io.github.lucariatias.ld29.level.Location;
import io.github.lucariatias.ld29.sprite.Sprite;

import java.awt.*;

public class SceneryObject extends LevelObject {

    private Sprite sprite;

    public SceneryObject(Level level, Sprite sprite) {
        super(level);
        this.sprite = sprite;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(sprite.getImage(), getLocation().getX(), getLocation().getY(), null);
    }

    @Override
    public void onTick() {
        sprite.onTick();
    }

    @Override
    public Rectangle getBoundsAt(Location location) {
        return new Rectangle(getLocation().getX(), getLocation().getY(), sprite.getImage().getWidth(), sprite.getImage().getHeight());
    }
}
