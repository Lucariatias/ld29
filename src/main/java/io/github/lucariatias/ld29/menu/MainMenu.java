package io.github.lucariatias.ld29.menu;

import io.github.lucariatias.ld29.Descent;
import io.github.lucariatias.ld29.level.Level;
import io.github.lucariatias.ld29.level.LevelPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainMenu extends Menu {

    public MainMenu(Descent descent) {
        super(descent);
        setTitle("DESCENT");
        addMenuItem("Play", new Runnable() {
            @Override
            public void run() {
                BufferedImage map;
                try {
                    map = ImageIO.read(getClass().getResourceAsStream("/map.png"));
                    Level level = new Level(getDescent());
                    getDescent().getPlayer().reset();
                    level.populate(map);
                    getDescent().getPlayer().setLevel(level);
                    LevelPanel levelPanel = new LevelPanel(getDescent(), level, getDescent().getPlayer());
                    getDescent().remove(getDescent().getLevelPanel());
                    getDescent().add(levelPanel, "level");
                    getDescent().setPanel("level");
                    getDescent().setLevelPanel(levelPanel);
                    levelPanel.setActive(true);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });
        addMenuItem("Play custom level", new Runnable() {
            @Override
            public void run() {
                BufferedImage map;
                try {
                    JFileChooser fileChooser = new JFileChooser(".");
                    fileChooser.setFileFilter(new FileNameExtensionFilter("Portable Network Graphics", "png"));
                    int result = fileChooser.showOpenDialog(getDescent());
                    if (result == JFileChooser.APPROVE_OPTION) {
                        map = ImageIO.read(fileChooser.getSelectedFile());
                        Level level = new Level(getDescent());
                        getDescent().getPlayer().reset();
                        level.populate(map);
                        getDescent().getPlayer().setLevel(level);
                        LevelPanel levelPanel = new LevelPanel(getDescent(), level, getDescent().getPlayer());
                        getDescent().remove(getDescent().getLevelPanel());
                        getDescent().add(levelPanel, "level");
                        getDescent().setPanel("level");
                        getDescent().setLevelPanel(levelPanel);
                        levelPanel.setActive(true);
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });
        addMenuItem("Options", new Runnable() {
            @Override
            public void run() {
                getDescent().setPanel("settings");
            }
        });
        addMenuItem("Exit", new Runnable() {
            @Override
            public void run() {
                System.exit(0);
            }
        });
    }
}
