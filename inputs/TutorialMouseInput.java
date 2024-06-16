package inputs;

import java.awt.*;
import java.awt.event.*;

import Utils.ImageUtils;
import main.GameWindow;
import Panels.TutorialPanel;

public class TutorialMouseInput implements MouseListener, MouseMotionListener {
    private TutorialPanel panel;
    private GameWindow window;
    private String background;

    private int back_x_min = 240; private int back_x_max = 355;
    private int back_y_min = 350; private int back_y_max = 390;

    public TutorialMouseInput(GameWindow window, TutorialPanel panel) {
        this.panel = panel;
        this.window = window;
        this.background = "HTM-Tutorial";
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        if (
            (back_x_min <= e.getX() &&  e.getX() <= back_x_max)
            && (back_y_min <= e.getY() && e.getY() <= back_y_max)) {
                if (!background.equals("HTM-Tutorial-Back")){
                    panel.setBackgroundImage("HTM-Tutorial-Back");
                    background = "HTM-Tutorial-Back";
                }
            }
        else {
            if (!background.equals("HTM-Tutorial")) {
                panel.setBackgroundImage("HTM-Tutorial");
                background = "HTM-Tutorial";
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if (
            (back_x_min <= e.getX() &&  e.getX() <= back_x_max)
            && (back_y_min <= e.getY() && e.getY() <= back_y_max)) {
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
