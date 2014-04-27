package io.github.lucariatias.ld29.options;

public enum Difficulty {

    EASY(10, 5, 1), NORMAL(5, 3, 2), HARD(2, 1, 5), INSANE(1, 1, 10);

    private int turningSpeed;
    private int lives;
    private int scoreMultiplier;

    private Difficulty(int turningSpeed, int lives, int scoreMultiplier) {
        this.turningSpeed = turningSpeed;
        this.lives = lives;
    }

    public int getTurningSpeed() {
        return turningSpeed;
    }

    public int getLives() {
        return lives;
    }

    public int getScoreMultiplier() {
        return scoreMultiplier;
    }

}
