package io.github.lucariatias.ld29.options;

public class Options {

    private Difficulty difficulty = Difficulty.NORMAL;
    private boolean lightingEnabled = true;

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isLightingEnabled() {
        return lightingEnabled;
    }

    public void setLightingEnabled(boolean lightingEnabled) {
        this.lightingEnabled = lightingEnabled;
    }

}
