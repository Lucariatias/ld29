package io.github.lucariatias.ld29;

import javax.swing.*;
import java.awt.*;

public class DescentApplet extends JApplet {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exception) {
            exception.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JApplet applet = new DescentApplet();
                applet.setVisible(true);
            }
        });
    }

    public DescentApplet() {
        add(new Descent(this));
        setFocusable(true);
    }

}
