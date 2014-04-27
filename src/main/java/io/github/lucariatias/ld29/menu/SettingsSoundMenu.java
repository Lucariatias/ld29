package io.github.lucariatias.ld29.menu;

import io.github.lucariatias.ld29.Descent;

public class SettingsSoundMenu extends Menu {

    public SettingsSoundMenu(Descent descent) {
        super(descent);
        setTitle("Sound settings");
        addMenuItem("Enable music", new Runnable() {
            @Override
            public void run() {
                getDescent().getOptions().setMusicEnabled(true);
                getDescent().setPanel("settings");
            }
        });
        addMenuItem("Disable music", new Runnable() {
            @Override
            public void run() {
                getDescent().getOptions().setMusicEnabled(false);
                getDescent().setPanel("settings");
            }
        });
        addMenuItem("Enable sound effects", new Runnable() {
            @Override
            public void run() {
                getDescent().getOptions().setSoundEffectsEnabled(true);
                getDescent().setPanel("settings");
            }
        });
        addMenuItem("Disable sound effects", new Runnable() {
            @Override
            public void run() {
                getDescent().getOptions().setSoundEffectsEnabled(false);
            }
        });
    }

}
