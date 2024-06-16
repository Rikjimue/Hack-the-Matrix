package main;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.*;

import Panels.*;

public class GameWindow {
    private JFrame frame;
    private JPanel panel;

    public GameWindow() {
        frame = new JFrame("HTM");
        panel = new MenuPanel(this);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
        frame.requestFocusInWindow();
        frame.setAlwaysOnTop(true);
        frame.setAutoRequestFocus(true);
    }

    public void setWindowSize(int width, int height) {
        frame.setSize(width, height);
    }

    public void setPanel(int panel_num) {
        panel.setVisible(false);
        switch (panel_num) {
            case 0:  panel = new MenuPanel(this);
                     frame.setSize(600, 450);
                     break;
            case 1:  panel = new DifficultyPanel(this);
                     frame.setSize(600, 450);
                     break;
            case 2:  panel = new GamePanel(this, 1); // Default
                     break;
            case 9:  panel = new GamePanel(this, 0); // Easy | For some reason 10 doesn't work. God help me.
                     break;
            case 11: panel = new GamePanel(this, 1); // Medium
                     break;
            case 12: panel = new GamePanel(this, 2); // Hard
                     break;
            case 3:  GamePanel gp1 = (GamePanel) panel; // Temporary variable name
                     gp1.getTimer().forceStopTimer();
                     panel = new EndPanel(this, "Win", gp1.difficulty);
                     frame.setSize(600, 450);
                     break;
            case 4:  GamePanel gp2 = (GamePanel) panel;
                     gp2.getTimer().forceStopTimer();
                     panel = new EndPanel(this, "Lost", gp2.difficulty);
                     frame.setSize(600, 450);
                     break;
            case 5:  panel = new TutorialPanel(this);
                     frame.setSize(600, 450);
                     break;
            default: panel = null;
                     break;
        }
        frame.add(panel);
        frame.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }
}
