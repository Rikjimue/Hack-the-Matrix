package inputs;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import main.GameWindow;
import main.Matrix;
import main.Path;
import main.Cell;
import Utils.ImageUtils;
import Panels.GamePanel;
import GUI.*;

public class MouseInput implements MouseListener, MouseMotionListener {
    private GameWindow window;
    private GamePanel component;
    private Grid grid;
    private Overflow overflow;
    private Paths paths;
    private Target target;
    private GameTimer timer;
    private Abort abort;
    private Matrix matrix;
    private Cell[][] matrix_arr;

    private int abort_x_min; private int abort_x_max;
    private int abort_y_min; private int abort_y_max;

    private int grid_x_min; private int grid_x_max;
    private int grid_y_min; private int grid_y_max;

    public MouseInput(GameWindow window, GamePanel component, Grid grid, Overflow overflow, Paths paths, Target target, GameTimer timer, Abort abort) {
        this.window = window;
        this.component = component;
        this.grid = grid;
        this.overflow = overflow;
        this.paths = paths;
        this.target = target;
        this.timer = timer;
        this.abort = abort;
        this.matrix = grid.getMatrix();
        this.matrix_arr = matrix.getMatrix();

        abort_x_min = abort.getLocation()[0]; abort_x_max = abort_x_min + 100;
        abort_y_min = abort.getLocation()[1]; abort_y_max = abort_y_min + 35;

        grid_x_min = 100; grid_x_max = grid_x_min + 44 * matrix_arr.length;
        grid_y_min = 100; grid_y_max = grid_y_min + 44 * matrix_arr[0].length;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Override
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Cell[][] placeholder = matrix.getMatrix();
        BufferedImage image = placeholder[0][0].getBorderFile();

        if (
            (abort_x_min <= e.getX() &&  e.getX() <= abort_x_max)
            && (abort_y_min <= e.getY() && e.getY() <= abort_y_max)) {
                window.setPanel(4);
            }
        else if (
            (grid_x_min <= e.getX() &&  e.getX() <= grid_x_max)
            && (grid_y_min <= e.getY() && e.getY() <= grid_y_max))  {

            for (int i = 0; i < placeholder.length; i++) {
                for (int j = 0; j < placeholder[i].length; j++) {

                    int x_min = grid.getLocation()[0] + (image.getWidth() + 4) * j;
                    int x_max = grid.getLocation()[0] + (image.getWidth() + 4) * (j+1) - 4;
                    int y_min = grid.getLocation()[1] + (image.getHeight() + 4) * i;
                    int y_max = grid.getLocation()[1] + (image.getHeight() + 4) * (i+1) - 4;
                    
                    if (
                        (x_min <= e.getX() && e.getX() <= x_max) 
                        && (y_min <= e.getY() && e.getY() <= y_max)) {

                            if (!timer.getTimerStarted()) {
                                timer.startTimer();
                            }

                            // Do something with the clicked cell
                            target.inTarget(i, j);
                            target.swapOrientation();
                            target.setCords(i, j);
                            if (target.checkWin()) {
                                window.setPanel(3);
                            }
                    }
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Override
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Image cursor_image = ImageUtils.getBufferedImage("resources/HTM-Crosshair.png");
        Cursor custom_cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursor_image, new Point(22, 22), "Crosshair");
        component.setCursor(custom_cursor);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Override
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Override
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Path[] paths_arr = matrix.getPaths();
        BufferedImage image = paths_arr[0].getPath()[0].getBorderFile();

        for (int i = 0; i < paths_arr.length; i++) {
            Cell[] path = paths_arr[i].getPath();
            for (int j = 0; j < path.length; j++) {

                int x_min = paths.getLocation()[0] + (image.getWidth() + 4) * j;
                int x_max = paths.getLocation()[0] + (image.getWidth() + 4) * (j+1) - 4;
                int y_min = paths.getLocation()[1] + (image.getHeight() + 4) * i;
                int y_max = paths.getLocation()[1] + (image.getHeight() + 4) * (i+1) - 4;

                if (
                    (x_min <= e.getX() && e.getX() <= x_max) 
                    && (y_min <= e.getY() && e.getY() <= y_max)) {
                        for (int z = 0; z < matrix_arr.length; z++) {
                            for (int y = 0; y < matrix_arr.length; y++) {
                                if (!matrix_arr[z][y].getLetter().equals(path[j].getLetter())) {
                                    matrix_arr[z][y].setColor(Color.GRAY);
                                }
                                else {
                                    matrix_arr[z][y].setColor(Color.WHITE);
                                }
                            }
                        }
                        return;
                }
                for (int z = 0; z < matrix_arr.length; z++) {
                    for (int y = 0; y < matrix_arr.length; y++) {
                        matrix_arr[z][y].setColor(Color.WHITE);
                    }
                }
            }
        }
    }
    
}
