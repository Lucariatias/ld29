package io.github.lucariatias.ld29.pickup;

import io.github.lucariatias.ld29.Descent;
import io.github.lucariatias.ld29.level.Level;

import java.awt.image.BufferedImage;

public class ArtefactPickup extends Pickup {

    public ArtefactPickup(Descent descent, Level level, BufferedImage image) {
        super(descent, level, image);
        setName("Artefact");
    }

    @Override
    public void onPickup() {
        super.onPickup();
        getDescent().getPlayer().setArtefactsCollected(getDescent().getPlayer().getArtefactsCollected() + 1);
        die();
    }

}
