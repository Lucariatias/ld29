package io.github.lucariatias.ld29.pickup;

import io.github.lucariatias.ld29.Descent;
import io.github.lucariatias.ld29.level.Level;

import java.awt.image.BufferedImage;

public class LaserPickup extends Pickup {

    public LaserPickup(Descent descent, Level level, BufferedImage image) {
        super(descent, level, image);
        setName("Laser");
    }

    @Override
    public void onPickup() {
        super.onPickup();
        getDescent().getNotificationManager().queueMessage("Use SPACE to use the laser.");
        getDescent().getPlayer().setLaserEnabled(true);
        die();
    }

}
