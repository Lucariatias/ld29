package io.github.lucariatias.ld29.level;

import io.github.lucariatias.ld29.Descent;
import io.github.lucariatias.ld29.block.Block;
import io.github.lucariatias.ld29.player.Player;
import io.github.lucariatias.ld29.tile.TileSheet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Level {

    private Descent descent;

    private TileSheet tileSheet;

    private BufferedImage map;

    private final Set<LevelObject> objects = Collections.synchronizedSet(new HashSet<LevelObject>());

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

    public void reset() {
        objects.clear();
        populate(map);
        descent.getPlayer().reset();
        descent.getPlayerController().reset();
    }

    public void onTick() {
        synchronized (objects) {
            for (LevelObject object : objects) {
                object.onTick();
            }
        }
    }

    public void render(Graphics graphics) {
        Location cameraLocation = descent.getLevelPanel().getCamera().getLocation();
        for (LevelObject object : objects) {
            if (!(object instanceof Player)) {
                Location objectLocation = object.getLocation();
                if (objectLocation.getX() >= cameraLocation.getX() - 32 && objectLocation.getY() >= cameraLocation.getY() - 32 && objectLocation.distanceSquared(cameraLocation) <= 640000)
                    object.render(graphics);
            }
        }
        descent.getPlayer().render(graphics);
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
        this.map = map;
    }

    private LevelObject getObject(Color colour) {
        switch (colour.getBlue()) {
            case 0: return null;
            case 1:
                Rectangle bounds;
                if (colour.getRed() == 0) {
                    switch (colour.getGreen()) {
                        case 0:
                            bounds = new Rectangle(0, 0, 0, 0);
                            break;
                        case 1:case 2:
                            bounds = new Rectangle(0, 0, 32, 32);
                            break;
                        default:
                            bounds = new Rectangle(0, 0, 32, 32);
                            break;
                    }
                } else if (colour.getRed() == 1) {
                    switch (colour.getGreen()) {
                        case 0:
                            bounds = new Rectangle(16, 16, 16, 16);
                            break;
                        case 1:
                            bounds = new Rectangle(16, 0, 16, 16);
                            break;
                        case 2:
                            bounds = new Rectangle(0, 16, 32, 16);
                            break;
                        default:
                            bounds = new Rectangle(0, 0, 32, 32);
                            break;
                    }
                } else if (colour.getRed() == 2) {
                    switch (colour.getGreen()) {
                        case 0:
                            bounds = new Rectangle(0, 16, 16, 16);
                            break;
                        case 1:
                            bounds = new Rectangle(0, 0, 16, 16);
                            break;
                        case 2:
                            bounds = new Rectangle(0, 0, 16, 32);
                            break;
                        default:
                            bounds = new Rectangle(0, 0, 32, 32);
                            break;
                    }
                } else if (colour.getRed() == 3) {
                    switch (colour.getGreen()) {
                        case 0:
                        case 1:
                            bounds = new Rectangle(0, 0, 32, 32);
                            break;
                        case 2:
                            bounds = new Rectangle(16, 0, 16, 32);
                            break;
                        default:
                            bounds = new Rectangle(0, 0, 32, 32);
                            break;
                    }
                } else if (colour.getRed() == 4) {
                    switch (colour.getGreen()) {
                        case 0:
                        case 1:
                            bounds = new Rectangle(0, 0, 32, 32);
                            break;
                        case 2:
                            bounds = new Rectangle(0, 0, 32, 16);
                            break;
                        default:
                            bounds = new Rectangle(0, 0, 32, 32);
                            break;
                    }
                } else if (colour.getRed() == 5) {
                    switch (colour.getGreen()) {
                        case 0:
                            bounds = new Rectangle(0, 0, 16, 16);
                            break;
                        case 1:
                            bounds = new Rectangle(0, 16, 16, 16);
                            break;
                        case 2:
                        default:
                            bounds = new Rectangle(0, 0, 32, 32);
                            break;
                    }
                } else if (colour.getRed() == 6) {
                    switch (colour.getGreen()) {
                        case 0:
                            bounds = new Rectangle(16, 0, 16, 16);
                            break;
                        case 1:
                        case 2:
                            bounds = new Rectangle(16, 16, 16, 16);
                            break;
                        case 3:
                            bounds = new Rectangle(16, 0, 16, 16);
                            break;
                        default:
                            bounds = new Rectangle(0, 0, 32, 32);
                            break;
                    }
                } else if (colour.getRed() == 7) {
                    switch (colour.getGreen()) {
                        case 0:case 1:
                            bounds = new Rectangle(0, 0, 32, 32);
                            break;
                        case 2:
                            bounds = new Rectangle(0, 16, 16, 16);
                            break;
                        case 3:
                            bounds = new Rectangle(0, 0, 16, 16);
                            break;
                        default:
                            bounds = new Rectangle(0, 0, 32, 32);
                            break;
                    }
                } else {
                    bounds = new Rectangle(0, 0, 32, 32);
                }
                return new Block(this, tileSheet.getImage(colour.getRed(), colour.getGreen()), bounds);
            case 2: return descent.getPlayer();
            default: return null;
        }
    }

}
