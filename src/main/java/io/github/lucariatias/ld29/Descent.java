package io.github.lucariatias.ld29;

import io.github.lucariatias.ld29.event.EventManager;
import io.github.lucariatias.ld29.event.tick.TickEvent;
import io.github.lucariatias.ld29.level.Level;
import io.github.lucariatias.ld29.level.LevelPanel;
import io.github.lucariatias.ld29.menu.*;
import io.github.lucariatias.ld29.notification.NotificationManager;
import io.github.lucariatias.ld29.options.Options;
import io.github.lucariatias.ld29.player.KeyboardPlayerController;
import io.github.lucariatias.ld29.player.Player;
import io.github.lucariatias.ld29.player.PlayerController;
import io.github.lucariatias.ld29.plugin.PluginManager;
import io.github.lucariatias.ld29.sound.SoundPlayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Logger;

public class Descent extends JPanel implements Runnable {

    private DescentFrame frame;

    public static final long DELAY = 25L;

    private Thread thread;

    private Logger logger;

    private Options options;

    private LevelPanel levelPanel;

    private EventManager eventManager;
    private NotificationManager notificationManager;
    private PluginManager pluginManager;

    private SoundPlayer soundPlayer;

    private KeyboardPlayerController playerController;
    private Player player;

    private Font titleFont;
    private Font font;

    public Descent(DescentFrame frame) {
        this.frame = frame;
        CardLayout layout = new CardLayout();
        setLayout(layout);
        setBackground(new Color(48, 0, 48));
        setPreferredSize(new Dimension(640, 480));
        setDoubleBuffered(true);
        this.logger = Logger.getLogger("Descent");
        this.options = new Options(this);
        try {
            this.titleFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/slkscr.ttf")).deriveFont(48F);
            this.font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/slkscr.ttf")).deriveFont(16F);
        } catch (FontFormatException | IOException exception) {
            exception.printStackTrace();
        }
        this.eventManager = new EventManager(this);
        this.notificationManager = new NotificationManager(this);
        this.pluginManager = new PluginManager(this);
        this.soundPlayer = new SoundPlayer();
        MainMenu menu = new MainMenu(this);
        add(menu, "menu");
        BufferedImage map = null;
        try {
            map = ImageIO.read(getClass().getResourceAsStream("/map.png"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        if (map != null) {
            Level level = new Level(this);
            try {
                player = new Player(this, level, ImageIO.read(getClass().getResourceAsStream("/player.png")));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            playerController = new KeyboardPlayerController(this, player);
            frame.addKeyListener(playerController);
            level.populate(map);
            this.levelPanel = new LevelPanel(this, level, player);
            add(levelPanel, "level");
        }
        setPanel("menu");
        SettingsMenu settingsMenu = new SettingsMenu(this);
        add(settingsMenu, "settings");
        SettingsDifficultyMenu settingsDifficultyMenu = new SettingsDifficultyMenu(this);
        add(settingsDifficultyMenu, "settings.difficulty");
        SettingsLightingMenu settingsLightingMenu = new SettingsLightingMenu(this);
        add(settingsLightingMenu, "settings.lighting");
        SettingsSoundMenu settingsSoundMenu = new SettingsSoundMenu(this);
        add(settingsSoundMenu, "settings.sound");
        pluginManager.loadPlugins();
    }

    public DescentFrame getFrame() {
        return frame;
    }

    public void setPanel(String panel) {
        CardLayout layout = (CardLayout) getLayout();
        layout.show(this, panel);
    }

    public Logger getLogger() {
        return logger;
    }

    public Options getOptions() {
        return options;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public NotificationManager getNotificationManager() {
        return notificationManager;
    }

    public PluginManager getPluginManager() {
        return pluginManager;
    }

    public SoundPlayer getSoundPlayer() {
        return soundPlayer;
    }

    public LevelPanel getLevelPanel() {
        return levelPanel;
    }

    public void setLevelPanel(LevelPanel levelPanel) {
        this.levelPanel = levelPanel;
    }

    public Player getPlayer() {
        return player;
    }

    private void doTick() {
        eventManager.dispatchEvent(new TickEvent());
        playerController.onTick();
        levelPanel.onTick();
        notificationManager.onTick();
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

    public PlayerController getPlayerController() {
        return playerController;
    }

    public Font getTitleFont() {
        return titleFont;
    }

    @Override
    public Font getFont() {
        return font;
    }
}
