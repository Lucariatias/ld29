package io.github.lucariatias.ld29.level;

import javax.swing.*;
import java.awt.*;

public class LevelPanel extends JPanel {

    private Level level;

    public LevelPanel(Level level) {
        this.level = level;
    }

    public void onTick() {
        level.onTick();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        render(graphics);
    }

    private void render(Graphics graphics) {
        level.render(graphics);
    }

}
