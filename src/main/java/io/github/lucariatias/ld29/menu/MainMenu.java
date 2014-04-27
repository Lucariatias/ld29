package io.github.lucariatias.ld29.menu;

import io.github.lucariatias.ld29.Descent;

public class MainMenu extends Menu {

    public MainMenu(Descent descent) {
        super(descent);
        setTitle("DESCENT");
        addMenuItem("Play", new Runnable() {
            @Override
            public void run() {
                getDescent().setPanel("level"); getDescent().getLevelPanel().setActive(true);
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
