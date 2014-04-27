package io.github.lucariatias.ld29.menu;

import io.github.lucariatias.ld29.Descent;
import io.github.lucariatias.ld29.options.Difficulty;

public class SettingsDifficultyMenu extends Menu {

    public SettingsDifficultyMenu(Descent descent) {
        super(descent);
        setTitle("Difficulty settings");
        addMenuItem(new MenuItem("Easy", new Runnable() {
            @Override
            public void run() {
                getDescent().getOptions().setDifficulty(Difficulty.EASY);
                getDescent().getPlayerController().setTurningSpeed(Difficulty.EASY.getTurningSpeed());
                getDescent().setPanel("settings");
            }
        }));
        addMenuItem(new MenuItem("Normal", new Runnable() {
            @Override
            public void run() {
                getDescent().getOptions().setDifficulty(Difficulty.NORMAL);
                getDescent().getPlayerController().setTurningSpeed(Difficulty.NORMAL.getTurningSpeed());
                getDescent().setPanel("settings");
            }
        }));
        addMenuItem(new MenuItem("Hard", new Runnable() {
            @Override
            public void run() {
                getDescent().getOptions().setDifficulty(Difficulty.HARD);
                getDescent().getPlayerController().setTurningSpeed(Difficulty.HARD.getTurningSpeed());
                getDescent().setPanel("settings");
            }
        }));
        addMenuItem(new MenuItem("Insane", new Runnable() {
            @Override
            public void run() {
                getDescent().getOptions().setDifficulty(Difficulty.INSANE);
                getDescent().getPlayerController().setTurningSpeed(Difficulty.INSANE.getTurningSpeed());
                getDescent().setPanel("settings");
            }
        }));
    }

}
