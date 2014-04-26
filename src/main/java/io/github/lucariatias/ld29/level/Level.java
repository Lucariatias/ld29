package io.github.lucariatias.ld29.level;

import io.github.lucariatias.ld29.Descent;
import io.github.lucariatias.ld29.block.Block;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

public class Level {

    private Descent descent;

    private Set<LevelObject> objects = new HashSet<>();

    public Level(Descent descent, BufferedImage map) {
        this.descent = descent;
        populate(map);
    }

    public Set<LevelObject> getObjects() {
        return objects;
    }

    public void addObject(LevelObject object) {
        objects.add(object);
    }

    public void onTick() {
        for (LevelObject object : objects) {
            object.onTick();
        }
    }

    public void render(Graphics graphics) {
        for (LevelObject object : objects) {
            object.render(graphics);
        }
    }

    public void populate(BufferedImage map) {
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                int pixel = map.getRGB(x, y);
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;
                LevelObject object = null;
                if (r == 255 && g == 255 && b == 255) object = new Block();
                if (r == 0 && g == 255 && b == 0) object = descent.getPlayer();
                if (object != null) {
                    object.setLocation(new Location(x * 32, y * 32));
                    addObject(object);
                }
            }
        }
    }

}
