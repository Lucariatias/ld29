package io.github.lucariatias.ld29.menu;

import io.github.lucariatias.ld29.Descent;

public class SettingsLightingMenu extends Menu {

    public SettingsLightingMenu(Descent descent) {
        super(descent);
        setTitle("Lighting settings");
        addMenuItem("Enable lighting", new Runnable() {
            @Override
            public void run() {
                getDescent().getOptions().setLightingEnabled(true);
                getDescent().setPanel("settings");
            }
        });
        addMenuItem("Disable lighting", new Runnable() {
            @Override
            public void run() {
                getDescent().getOptions().setLightingEnabled(false);
                getDescent().setPanel("settings");
            }
        });
    }

}
