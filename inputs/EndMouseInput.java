package inputs;

import java.awt.*;
import java.awt.event.*;

import Panels.EndPanel;
import Utils.ImageUtils;
import main.GameWindow;

public class EndMouseInput implements MouseListener, MouseMotionListener {
    private EndPanel panel;
    private GameWindow window;

    private int play_x_min = 200; private int play_x_max = 390;
    private int play_y_min = 285; private int play_y_max = 330;

    private int menu_x_min = 210; private int menu_x_max = 385;
    private int menu_y_min = 345; private int menu_y_max = 385;

    public EndMouseInput(GameWindow window, EndPanel panel) {
        this.panel = panel;
        this.window = window;
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        if (
            (play_x_min <= e.getX() &&  e.getX() <= play_x_max)
            && (play_y_min <= e.getY() && e.getY() <= play_y_max)) {
                String condition = panel.getCondition();
                String file_str = "HTM-End-" + condition + "-Play";
                panel.setBackgroundImage(file_str);
            }
        else if (
            (menu_x_min <= e.getX() &&  e.getX() <= menu_x_max)
            && (menu_y_min <= e.getY() && e.getY() <= menu_y_max))  {
                String condition = panel.getCondition();
                String file_str = "HTM-End-" + condition + "-Menu";
                panel.setBackgroundImage(file_str);
            }
        else {
            String condition = panel.getCondition();
            String file_str = "HTM-End-" + condition;
            panel.setBackgroundImage(file_str);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if (
            (play_x_min <= e.getX() &&  e.getX() <= play_x_max)
            && (play_y_min <= e.getY() && e.getY() <= play_y_max)) {
                switch (panel.getPrevDifficulty()) {
                    case 0: window.setPanel(9);
                            break;
                    case 1: window.setPanel(11);
                            break;
                    case 2: window.setPanel(12);
                            break;
                }
            }
        else if (
            (menu_x_min <= e.getX() &&  e.getX() <= menu_x_max)
            && (menu_y_min <= e.getY() && e.getY() <= menu_y_max))  {
                window.setPanel(0);
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

