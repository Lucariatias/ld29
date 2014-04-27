package io.github.lucariatias.ld29.menu;

import io.github.lucariatias.ld29.Descent;

public class SettingsMenu extends Menu {

    public SettingsMenu(Descent descent) {
        super(descent);
        setTitle("Settings");
        addMenuItem("Change difficulty", new Runnable() {
            @Override
            public void run() {
                getDescent().setPanel("settings.difficulty");
            }
        });
        addMenuItem("Lighting settings", new Runnable() {
            @Override
            public void run() {
                getDescent().setPanel("settings.lighting");
            }
        });
        addMenuItem("Main menu", new Runnable() {
            @Override
            public void run() {
                getDescent().setPanel("menu");
            }
        });
    }



}
