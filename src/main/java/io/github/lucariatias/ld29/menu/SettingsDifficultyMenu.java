package io.github.lucariatias.ld29.menu;

import io.github.lucariatias.ld29.Descent;
import io.github.lucariatias.ld29.options.Difficulty;

public class SettingsDifficultyMenu extends Menu {

    public SettingsDifficultyMenu(Descent descent) {
        super(descent);
        setTitle("Difficulty settings");
        addMenuItem("Easy", new Runnable() {
            @Override
            public void run() {
                getDescent().getOptions().setDifficulty(Difficulty.EASY);
                getDescent().setPanel("settings");
            }
        });
        addMenuItem("Normal", new Runnable() {
            @Override
            public void run() {
                getDescent().getOptions().setDifficulty(Difficulty.NORMAL);
                getDescent().setPanel("settings");
            }
        });
        addMenuItem("Hard", new Runnable() {
            @Override
            public void run() {
                getDescent().getOptions().setDifficulty(Difficulty.HARD);
                getDescent().setPanel("settings");
            }
        });
        addMenuItem("Insane", new Runnable() {
            @Override
            public void run() {
                getDescent().getOptions().setDifficulty(Difficulty.INSANE);
                getDescent().setPanel("settings");
            }
        });
    }

}
