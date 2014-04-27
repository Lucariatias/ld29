package io.github.lucariatias.ld29.options;

public enum Difficulty {

    EASY(10, 5), NORMAL(5, 3), HARD(2, 0), INSANE(1, 0);

    private int turningSpeed;
    private int lives;

    private Difficulty(int turningSpeed, int lives) {
        this.turningSpeed = turningSpeed;
        this.lives = lives;
    }

    public int getTurningSpeed() {
        return turningSpeed;
    }

    public int getLives() {
        return lives;
    }
}
