package io.github.lucariatias.ld29.level;

import io.github.lucariatias.ld29.Descent;
import io.github.lucariatias.ld29.block.Block;
import io.github.lucariatias.ld29.tile.TileSheet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Level {

    private Descent descent;

    private TileSheet tileSheet;

    private Set<LevelObject> objects = new HashSet<>();

    public Level(Descent descent) {
        this.descent = descent;
        try {
            tileSheet = new TileSheet(ImageIO.read(getClass().getResourceAsStream("/tiles.png")), 32, 32);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public TileSheet getTileSheet() {
        return tileSheet;
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
            if (object.getLocation().distanceSquared(descent.getLevelPanel().getCamera().getLocation()) <= 640000) object.render(graphics);
        }
    }

    public void populate(BufferedImage map) {
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                int pixel = map.getRGB(x, y);
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;
                LevelObject object = getObject(new Color(r, g, b));
                if (object != null) {
                    object.setLocation(new Location(x * 32, y * 32));
                    addObject(object);
                }
            }
        }
        map.flush();
    }

    private LevelObject getObject(Color colour) {
        switch (colour.getBlue()) {
            case 0: return null;
            case 1: return new Block(this, tileSheet.getImage(colour.getRed(), colour.getGreen()));
            case 2: return descent.getPlayer();
            default: return null;
        }
    }

}
