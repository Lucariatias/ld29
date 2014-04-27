package io.github.lucariatias.ld29.options;

import io.github.lucariatias.ld29.Descent;

public class Options {

    private Descent descent;

    private Difficulty difficulty = Difficulty.NORMAL;
    private boolean lightingEnabled = true;

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        descent.getPlayerController().setTurningSpeed(difficulty.getTurningSpeed());
        descent.getPlayer().setLives(difficulty.getLives());
    }

    public boolean isLightingEnabled() {
        return lightingEnabled;
    }

    public void setLightingEnabled(boolean lightingEnabled) {
        this.lightingEnabled = lightingEnabled;
    }

}
