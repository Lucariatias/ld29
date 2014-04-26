package io.github.lucariatias.ld29.player;

public abstract class PlayerController {

    private static final int TURNING_SPEED = 1;

    private Player player;

    private int approachingAngle;

    public PlayerController(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getApproachingAngle() {
        return approachingAngle;
    }

    public void setApproachingAngle(int approachingAngle) {
        this.approachingAngle = approachingAngle;
    }

    public void onTick() {
        if (approachingAngle > player.getAngle()) player.setAngle(player.getAngle() + TURNING_SPEED);
        if (approachingAngle < player.getAngle()) player.setAngle(player.getAngle() - TURNING_SPEED);
    }
}
