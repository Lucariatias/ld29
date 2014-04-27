package io.github.lucariatias.ld29.menu;

import io.github.lucariatias.ld29.Descent;

public class MainMenu extends Menu {


    public MainMenu(final Descent descent) {
        super(descent);
        setTitle("DESCENT");
        addMenuItem("Play", new Runnable() {
            @Override
            public void run() {
                descent.setPanel("level");
            }
        });
        addMenuItem("Options", new Runnable() {
            @Override
            public void run() {}
        });
        addMenuItem("Exit", new Runnable() {
            @Override
            public void run() {
                System.exit(0);
            }
        });
    }
}
