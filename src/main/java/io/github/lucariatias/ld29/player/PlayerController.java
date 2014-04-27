package io.github.lucariatias.ld29.player;

public abstract class PlayerController {

    private static final int TURNING_SPEED = 5;

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
        if (approachingAngle > player.getAngle()) {
            if (approachingAngle - player.getAngle() >= 180) player.setAngle(player.getAngle() - TURNING_SPEED); else player.setAngle(player.getAngle() + TURNING_SPEED);
        } else if (approachingAngle < player.getAngle()) {
            if (player.getAngle() - approachingAngle >= 180) player.setAngle(player.getAngle() + TURNING_SPEED); else player.setAngle(player.getAngle() - TURNING_SPEED);
        }
        while (player.getAngle() >= 360) {
            player.setAngle(player.getAngle() - 360);
        }
        while (player.getAngle() < 0) {
            player.setAngle(player.getAngle() + 360);
        }
    }

    public void reset() {
        approachingAngle = 0;
    }

}
