package io.github.lucariatias.ld29.notification;

import java.awt.*;

public class NotificationManager {

    private static final int NOTIFICATION_TICKS = 40;
    private static final int NOTIFICATION_SPEED = 4;

    private int y;
    private String message = "";
    private int tick;
    private boolean active;

    public NotificationManager() {
        this.y = 480;
    }

    public void render(Graphics graphics) {
        if (active) {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0, y, 640, 64);
            graphics.setColor(Color.WHITE);
            graphics.drawRect(0, y, 639, 64);
            graphics.drawRect(8, y + 8, 623, 48);
            graphics.drawString(message, 16, y + 16 + graphics.getFontMetrics().getMaxAscent() + graphics.getFontMetrics().getLeading());
        }
    }

    public void onTick() {
        if (active) {
            if (y > 416 && tick < NOTIFICATION_TICKS) {
                y -= NOTIFICATION_SPEED;
            } else {
                if (tick >= NOTIFICATION_TICKS) {
                    if (y <= 480) y += NOTIFICATION_SPEED; else active = false;
                } else {
                    tick++;
                }
            }
        }
    }

    public void showMessage(String message) {
        this.message = message;
        this.tick = 0;
        this.y = 480;
        this.active = true;
    }

}
