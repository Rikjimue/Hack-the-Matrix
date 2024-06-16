package inputs;

import java.awt.*;
import java.awt.event.*;

import Utils.ImageUtils;
import main.GameWindow;
import Panels.MenuPanel;

public class MenuMouseInput implements MouseListener, MouseMotionListener {
    private MenuPanel panel;
    private GameWindow window;
    private String background;

    private int play_x_min = 250; private int play_x_max = 360;
    private int play_y_min = 260; private int play_y_max = 300;

    private int tutorial_x_min = 227; private int tutorial_x_max = 385;
    private int tutorial_y_min = 327; private int tutorial_y_max = 369;

    public MenuMouseInput(GameWindow window, MenuPanel panel) {
        this.panel = panel;
        this.window = window;
        this.background = "HTM-Menu";
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        if ( // If it is over play button
            (play_x_min <= e.getX() &&  e.getX() <= play_x_max)
            && (play_y_min <= e.getY() && e.getY() <= play_y_max)) {
                if (!background.equals("HTM-Menu-Play")) {
                    panel.setBackgroundImage("HTM-Menu-Play");
                    background = "HTM-Menu-Play";
                }
            }
        else if ( // if it is over tutorial button
            (tutorial_x_min <= e.getX() &&  e.getX() <= tutorial_x_max)
            && (tutorial_y_min <= e.getY() && e.getY() <= tutorial_y_max))  {
                if (!background.equals("HTM-Menu-Tutorial")) {
                    panel.setBackgroundImage("HTM-Menu-Tutorial");
                    background = "HTM-Menu-Tutorial";
                }
            }
        else {
            if (!background.equals("HTM-Menu")) {
                panel.setBackgroundImage("HTM-Menu");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if ( // If it is over play button
            (play_x_min <= e.getX() &&  e.getX() <= play_x_max)
            && (play_y_min <= e.getY() && e.getY() <= play_y_max)) {
                window.setPanel(1);
            }
        else if ( // if it is over tutorial button
            (tutorial_x_min <= e.getX() &&  e.getX() <= tutorial_x_max)
            && (tutorial_y_min <= e.getY() && e.getY() <= tutorial_y_max))  {
                window.setPanel(5);
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
