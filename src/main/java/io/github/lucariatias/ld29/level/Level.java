package io.github.lucariatias.ld29.level;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Level {

    private Set<LevelObject> objects = new HashSet<>();

    public Set<LevelObject> getObjects() {
        return objects;
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
}
