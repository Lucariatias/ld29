package io.github.lucariatias.ld29.sprite;

import java.awt.image.BufferedImage;

public class Sprite {

    private BufferedImage[] frames;
    private int currentFrame;

    private final int frameDelay;
    private int frameTicks;

    public Sprite(int frameDelay, BufferedImage... frames) {
        this.frameDelay = frameDelay;
        this.frames = frames;
    }

    public void onTick() {
        frameTicks = frameTicks + 1 < frameDelay ? frameTicks + 1 : 0;
        if (frameTicks == 0) {
            nextFrame();
        }
    }

    public void nextFrame() {
        currentFrame = currentFrame + 1 < frames.length - 1 ? currentFrame + 1 : 0;
    }

    public BufferedImage getImage() {
        return frames[currentFrame];
    }

}
