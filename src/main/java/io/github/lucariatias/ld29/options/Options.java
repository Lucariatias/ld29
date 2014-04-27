package io.github.lucariatias.ld29.options;

import io.github.lucariatias.ld29.Descent;

public class Options {

    private Descent descent;

    private Difficulty difficulty = Difficulty.NORMAL;
    private boolean lightingEnabled = true;
    private boolean musicEnabled = true;
    private boolean soundEffectsEnabled = true;

    public Options(Descent descent) {
        this.descent = descent;
    }

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

    public boolean isMusicEnabled() {
        return musicEnabled;
    }

    public void setMusicEnabled(boolean musicEnabled) {
        this.musicEnabled = musicEnabled;
    }

    public boolean isSoundEffectsEnabled() {
        return soundEffectsEnabled;
    }

    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        this.soundEffectsEnabled = soundEffectsEnabled;
    }

}
