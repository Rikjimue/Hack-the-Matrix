package GUI;

import java.awt.*;
import java.awt.image.BufferedImage;

import main.Cell;
import main.Path;


public class Target extends DrawableObject{
    private Cell[][] arr;
    private String orientation;
    private Path[] paths;
    private Overflow overflow;
    private int width;
    private int height;
    private int spacing;
    private int x_cord;
    private int y_cord;
    private int row;
    private int col;

    public Target(Component panel, Grid grid, Overflow o) {
        super(panel, null, grid.getLocation());
        this.arr = grid.getMatrix().getMatrix();
        this.orientation = "Horizontal";
        this.paths = grid.getMatrix().getPaths();
        this.overflow = o;

        BufferedImage image = arr[0][0].getBorderFile();
        width = image.getWidth(null);
        height = image.getHeight(null);
        spacing = 4;
        setCords(0, 0);
    }

    public boolean checkWin() {
        for (int i = 0; i < paths.length; i++) {
            if (!paths[i].getComplete()) {
                return false;
            }
        }
        return true;
    }

    public void inTarget(int row, int col) {
        boolean found = false;
        if (orientation.equals("Horizontal")) {
            if (this.row == row) {
                for (int i = 0; i < paths.length; i++) {
                    if (!paths[i].getComplete()) {
                        Cell[] path = paths[i].getPath();
                        int index = paths[i].getIndex();
                        if (arr[row][col].getLetter().equals(path[index].getLetter())) {
                            found = true;
                            paths[i].incrementIndex();
                        }
                        else {
                            paths[i].resetIndex();
                        }
                    }
                }
            }
            // Reset all paths when clicked outside of target
            else {
                for (int i = 0; i < paths.length; i++) {
                    paths[i].resetIndex();
                }
            }
        }
        else {
            if (this.col == col) {
                for (int i = 0; i < paths.length; i++) {
                    Cell[] path = paths[i].getPath();
                    int index = paths[i].getIndex();
                    if (!paths[i].getComplete()) {
                        if (arr[row][col].getLetter().equals(path[index].getLetter())) {
                            paths[i].incrementIndex();
                            found = true;
                        }
                        else {
                            paths[i].resetIndex();
                        }
                    }
                }
            }
            else {
                for (int i = 0; i < paths.length; i++) {
                    paths[i].resetIndex();
                }
            }
        }
        if (found == false) {
            overflow.addLetter(arr[row][col].getLetter());
        }
    }

    public void setCords(int row, int col) {
        this.row = row;
        this.col = col;
        if (orientation.equals("Horizontal")) {
            x_cord = super.getLocation()[0];
            y_cord = super.getLocation()[1] + (height + spacing) * row;
            for (int i = 0; i < paths.length; i++) {
                if (paths[i].getComplete()) {
                    continue;
                }
                Cell[] path = paths[i].getPath();
                int index = paths[i].getIndex();
                path[index].setColor(Color.WHITE);
                for (int j = 0; j < arr[row].length; j++) {
                    if (arr[row][j].getLetter().equals(path[index].getLetter())) {
                        path[index].setColor(Color.YELLOW);
                    }
                }
            }
        }
        else {
            x_cord = super.getLocation()[0] + (width + spacing) * col;
            y_cord = super.getLocation()[1];
            for (int i = 0; i < paths.length; i++) {
                if (paths[i].getComplete()) {
                    continue;
                }
                Cell[] path = paths[i].getPath();
                int index = paths[i].getIndex();
                path[index].setColor(Color.WHITE);
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j][col].getLetter().equals(path[index].getLetter())) {
                        path[index].setColor(Color.YELLOW);
                    }
                }
            }
        }
    }

    public void swapOrientation() {
        if (orientation.equals("Horizontal")) {
            orientation = "Vertical";
        }
        else {
            orientation = "Horizontal";
        }
    }

    public void drawImage(Graphics g) {
        // Horizontal
        if (orientation.equals("Horizontal")) {
            g.drawRect(
            x_cord, y_cord, 
            (width + spacing) * arr.length - spacing, height
        );
        }
        // Vertical
        else {
            g.drawRect(
            x_cord, y_cord, 
            width, (height + spacing) * arr.length - spacing
        );
        } 
    }
}
