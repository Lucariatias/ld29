package io.github.lucariatias.ld29;

import io.github.lucariatias.ld29.level.LevelPanel;

import javax.swing.*;
import java.awt.*;

public class Descent extends JPanel implements Runnable {

    private DescentFrame frame;

    public static final long DELAY = 25L;

    private Thread thread;

    private LevelPanel levelPanel;

    public Descent(DescentFrame frame) {
        this.frame = frame;
        CardLayout layout = new CardLayout();
        setLayout(layout);
        setBackground(new Color(48, 0, 48));
        setPreferredSize(new Dimension(640, 480));
        setDoubleBuffered(true);

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
