package io.github.lucariatias.ld29.level;

import io.github.lucariatias.ld29.Descent;
import io.github.lucariatias.ld29.player.Camera;
import io.github.lucariatias.ld29.player.Player;

import javax.swing.*;
import java.awt.*;

public class LevelPanel extends JPanel {

    private Descent descent;
    private Level level;
    private Camera camera;

    public LevelPanel(Descent descent, Level level, Player player) {
        this.descent = descent;
        this.level = level;
        this.camera = new Camera(player);
    }

    public Camera getCamera() {
        return camera;
    }

    public void onTick() {
        level.onTick();
        camera.onTick();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.translate(-camera.getLocation().getX(), -camera.getLocation().getY());
        render(graphics);
        graphics2D.translate(camera.getLocation().getX(), camera.getLocation().getY());
        descent.getNotificationManager().render(graphics);
    }

    private void render(Graphics graphics) {
        level.render(graphics);
    }

}
