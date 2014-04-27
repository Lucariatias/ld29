package io.github.lucariatias.ld29.player;

import io.github.lucariatias.ld29.Descent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class KeyboardPlayerController extends PlayerController implements KeyListener {

    private Descent descent;

    public KeyboardPlayerController(Descent descent, Player player) {
        super(player);
        this.descent = descent;
    }

    @Override
    public void keyTyped(KeyEvent event) {}

    @Override
    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()) {
            case VK_RIGHT:case VK_D: setApproachingAngle(0); break;
            case VK_DOWN:case VK_S: setApproachingAngle(90); break;
            case VK_LEFT:case VK_A: setApproachingAngle(180); break;
            case VK_UP:case VK_W: setApproachingAngle(270); break;
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        switch (event.getKeyCode()) {
            case VK_R: descent.getLevelPanel().reset(); break;
        }
    }

}
