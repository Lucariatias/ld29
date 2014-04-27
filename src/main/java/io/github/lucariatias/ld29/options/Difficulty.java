package io.github.lucariatias.ld29.options;

public enum Difficulty {

    EASY(10), NORMAL(5), HARD(2), INSANE(1);

    private int turningSpeed;

    private Difficulty(int turningSpeed) {
        this.turningSpeed = turningSpeed;
    }

    public int getTurningSpeed() {
        return turningSpeed;
    }

}
