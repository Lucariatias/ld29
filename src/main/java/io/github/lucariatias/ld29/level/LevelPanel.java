package io.github.lucariatias.ld29.level;

import io.github.lucariatias.ld29.Descent;
import io.github.lucariatias.ld29.player.Camera;
import io.github.lucariatias.ld29.player.Player;
import io.github.lucariatias.ld29.sound.SoundPlayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LevelPanel extends JPanel {

    private Descent descent;
    private Level level;
    private Camera camera;
    private BufferedImage lighting;
    private boolean active;
    private int countDown;

    public LevelPanel(Descent descent, Level level, Player player) {
        this.descent = descent;
        this.level = level;
        this.camera = new Camera(player);
        try {
            this.lighting = ImageIO.read(getClass().getResourceAsStream("/light.png"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        this.countDown = 160;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public Camera getCamera() {
        return camera;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
        if (active) {
            descent.getNotificationManager().queueMessage("Use WASD or the arrow keys to move.");
            if (descent.getOptions().isMusicEnabled()) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SoundPlayer soundPlayer = LevelPanel.this.descent.getSoundPlayer();
                        soundPlayer.stopAll();
                        soundPlayer.play(getClass().getResourceAsStream("/descent.ogg"));
                    }
                }).start();
            }
        } else {
            descent.getSoundPlayer().stopAll();
        }
    }

    public int getCountDown() {
        return countDown;
    }

    public void setCountDown(int countDown) {
        this.countDown = countDown;
    }

    public void onTick() {
        if (active) {
            countDown = countDown > 0 ? countDown - 1 : countDown;
            if (countDown == 0) {
                level.onTick();
            }
            camera.onTick();
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        graphics.setFont(descent.getFont());
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.translate(-camera.getLocation().getX(), -camera.getLocation().getY());
        render(graphics);
        graphics2D.translate(camera.getLocation().getX(), camera.getLocation().getY());
        if (descent.getOptions().isLightingEnabled()) graphics.drawImage(lighting, 0, 0, null);
        descent.getNotificationManager().render(graphics);
        graphics.setColor(Color.RED);
        if (!descent.getPlayer().isDead()) graphics.drawString("SCORE: " + descent.getPlayer().getScore(), 416, 16);
        if (countDown > 0) {
            graphics.setColor(Color.BLACK);
            graphics.fillOval(288, 208, 64, 64);
            graphics.setColor(Color.RED);
            graphics.drawOval(288, 208, 64, 64);
            if (countDown > 120)
                graphics.drawString("3", 320 - ((int) graphics.getFontMetrics().getStringBounds("3", graphics).getWidth() / 2), 244);
            else if (countDown > 80)
                graphics.drawString("2", 320 - ((int) graphics.getFontMetrics().getStringBounds("2", graphics).getWidth() / 2), 244);
            else
                graphics.drawString("1", 320 - ((int) graphics.getFontMetrics().getStringBounds("1", graphics).getWidth() / 2), 244);
        }
    }

    private void render(Graphics graphics) {
        level.render(graphics);
    }

    public void reset() {
        countDown = 160;
        level.reset();
        if (descent.getOptions().isMusicEnabled()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SoundPlayer soundPlayer = LevelPanel.this.descent.getSoundPlayer();
                    soundPlayer.stopAll();
                    soundPlayer.play(getClass().getResourceAsStream("/descent.ogg"));
                }
            }).start();
        }
    }

}
