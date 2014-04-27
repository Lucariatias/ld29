package io.github.lucariatias.ld29.pickup;

import io.github.lucariatias.ld29.Descent;
import io.github.lucariatias.ld29.level.Level;

import java.awt.image.BufferedImage;

public class LifePickup extends Pickup {

    public LifePickup(Descent descent, Level level, BufferedImage image) {
        super(descent, level, image);
        setName("Life");
    }

    @Override
    public void onPickup() {
        super.onPickup();
        getDescent().getPlayer().setLives(getDescent().getPlayer().getLives() + 1);
        die();
    }

}
