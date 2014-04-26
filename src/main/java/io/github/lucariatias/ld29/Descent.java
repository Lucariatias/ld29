package io.github.lucariatias.ld29;

import io.github.lucariatias.ld29.level.Level;
import io.github.lucariatias.ld29.level.LevelPanel;
import io.github.lucariatias.ld29.player.KeyboardPlayerController;
import io.github.lucariatias.ld29.player.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Descent extends JPanel implements Runnable {

    private DescentFrame frame;

    public static final long DELAY = 25L;

    private Thread thread;

    private LevelPanel levelPanel;

    private KeyboardPlayerController playerController;
    private Player player;

    public Descent(DescentFrame frame) {
        this.frame = frame;
        CardLayout layout = new CardLayout();
        setLayout(layout);
        setBackground(new Color(48, 0, 48));
        setPreferredSize(new Dimension(640, 480));
        setDoubleBuffered(true);
        try {
            player = new Player(ImageIO.read(getClass().getResourceAsStream("/player.png")));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        playerController = new KeyboardPlayerController(player);
        frame.addKeyListener(playerController);
        BufferedImage map = null;
        try {
            map = ImageIO.read(getClass().getResourceAsStream("/map.png"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        if (map != null) {
            Level level = new Level(this, map);
            this.levelPanel = new LevelPanel(level);
            add(levelPanel);
        }
    }

    public Player getPlayer() {
        return player;
    }

    private void doTick() {
        levelPanel.onTick();
    }

    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();
        while (true) {
            doTick();
            repaint();
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;
            if (sleep < 0) {
                sleep = 2;
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            beforeTime = System.currentTimeMillis();
        }
    }

    @Override
    public void addNotify() {
        super.addNotify();
        thread = new Thread(this);
        thread.start();
    }

}
