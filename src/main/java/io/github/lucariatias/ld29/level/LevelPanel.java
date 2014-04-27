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
    private boolean active;
    private int countDown;

    public LevelPanel(Descent descent, Level level, Player player) {
        this.descent = descent;
        this.level = level;
        this.camera = new Camera(player);
        this.countDown = 160;
    }

    public Camera getCamera() {
        return camera;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void onTick() {
        if (active) {
            countDown = countDown > 0 ? countDown - 1 : countDown;
            if (countDown == 0) {
                level.onTick();
                camera.onTick();
            }
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        graphics.setFont(descent.getFont());
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.translate(-camera.getLocation().getX(), -camera.getLocation().getY());
        render(graphics);
        graphics2D.translate(camera.getLocation().getX(), camera.getLocation().getY());
        descent.getNotificationManager().render(graphics);
        if (countDown > 0) {
            graphics.setColor(Color.BLACK);
            graphics.fillOval(288, 208, 64, 64);
            graphics.setColor(Color.RED);
            graphics.drawOval(288, 208, 64, 64);
            if (countDown > 120) graphics.drawString("3", 320 - ((int) graphics.getFontMetrics().getStringBounds("3", graphics).getWidth() / 2), 244);
            else if (countDown > 80) graphics.drawString("2", 320 - ((int) graphics.getFontMetrics().getStringBounds("2", graphics).getWidth() / 2), 244);
            else if (countDown > 4) graphics.drawString("1", 320 - ((int) graphics.getFontMetrics().getStringBounds("1", graphics).getWidth() / 2), 244);
        }
    }

    private void render(Graphics graphics) {
        level.render(graphics);
    }

}
