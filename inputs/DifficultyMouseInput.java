package inputs;

import java.awt.*;
import java.awt.event.*;

import Panels.DifficultyPanel;
import Utils.ImageUtils;
import main.*;

public class DifficultyMouseInput implements MouseListener, MouseMotionListener {
    private DifficultyPanel panel;
    private GameWindow window;
    private String background;

    private int easy_x_min = 240; private int easy_x_max = 350;
    private int easy_y_min = 165; private int easy_y_max = 205;

    private int medium_x_min = 220; private int medium_x_max = 375;
    private int medium_y_min = 230; private int medium_y_max = 275;

    private int hard_x_min = 240; private int hard_x_max = 355;
    private int hard_y_min = 295; private int hard_y_max = 335;

    public DifficultyMouseInput(GameWindow window, DifficultyPanel panel) {
        this.panel = panel;
        this.window = window;
        this.background = "HTM-Difficulty";
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        if (
            (easy_x_min <= e.getX() &&  e.getX() <= easy_x_max)
            && (easy_y_min <= e.getY() && e.getY() <= easy_y_max)) {
                if (!background.equals("HTM-Difficulty-Easy")){
                    panel.setBackgroundImage("HTM-Difficulty-Easy");
                    background = "HTM-Difficulty-Easy";
                }
            }
        else if (
            (medium_x_min <= e.getX() &&  e.getX() <= medium_x_max)
            && (medium_y_min <= e.getY() && e.getY() <= medium_y_max)) {
                if (!background.equals("HTM-Difficulty-Medium")){
                    panel.setBackgroundImage("HTM-Difficulty-Medium");
                    background = "HTM-Difficulty-Medium";
                }
            }
        else if (
            (hard_x_min <= e.getX() &&  e.getX() <= hard_x_max)
            && (hard_y_min <= e.getY() && e.getY() <= hard_y_max)) {
                if (!background.equals("HTM-Difficulty-Hard")){
                    panel.setBackgroundImage("HTM-Difficulty-Hard");
                    background = "HTM-Difficulty-Hard";
                }
            }
        else {
            if (!background.equals("HTM-Difficulty")) {
                panel.setBackgroundImage("HTM-Difficulty");
                background = "HTM-Difficulty";
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if (
            (easy_x_min <= e.getX() &&  e.getX() <= easy_x_max)
            && (easy_y_min <= e.getY() && e.getY() <= easy_y_max)) {
                window.setPanel(9);
            }
        else if (
            (medium_x_min <= e.getX() &&  e.getX() <= medium_x_max)
            && (medium_y_min <= e.getY() && e.getY() <= medium_y_max)) {
                window.setPanel(11);
            }
        else if (
            (hard_x_min <= e.getX() &&  e.getX() <= hard_x_max)
            && (hard_y_min <= e.getY() && e.getY() <= hard_y_max)) {
                window.setPanel(12);
            }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        Image cursor_image = ImageUtils.getBufferedImage("resources/HTM-Crosshair.png");
        Cursor custom_cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursor_image, new Point(22, 22), "Crosshair");
        panel.setCursor(custom_cursor);
    }

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
