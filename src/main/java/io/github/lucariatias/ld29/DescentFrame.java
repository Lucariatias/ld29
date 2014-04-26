package io.github.lucariatias.ld29;

import javax.swing.*;
import java.awt.*;

public class DescentFrame extends JFrame {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exception) {
            exception.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new DescentFrame();
                frame.setVisible(true);
            }
        });
    }

    public DescentFrame() {
        add(new Descent(this));
        setTitle("Harmonic Moon");
        setResizable(false);
        setFocusable(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
