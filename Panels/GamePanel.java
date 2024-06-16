package Panels;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import GUI.*;
import inputs.MouseInput;
import main.GameWindow;
import Utils.FontUtils;
import Utils.ImageUtils;

public class GamePanel extends JPanel {
    private Grid grid;
    private Overflow overflow;
    private Paths paths;
    private Target target;
    private GameTimer timer;
    private Abort abort;
    public int difficulty;

    public GamePanel(GameWindow window, int difficulty) {
        int arr_size;
        int grid_size;
        int seconds;
        this.difficulty = difficulty;
        switch (difficulty) {
            case 0:  grid_size = 3;
                     arr_size = 4;
                     seconds = 60;
                     break;
            case 2:  grid_size = 7;
                     arr_size = 4;
                     seconds = 100;
                     break;
            default: grid_size = 5;
                     arr_size = 4;
                     seconds = 90;
                     break;
        }
        int width = 175 + 2 * 44 * grid_size;
        int height = 225 + 44 * grid_size;
        window.setWindowSize(width, height);
        grid = new Grid(this, 100, 100, grid_size);
        overflow = new Overflow(window, this, arr_size);
        paths = new Paths(this, grid);
        target = new Target(this, grid, overflow);
        timer = new GameTimer(window, this, grid, seconds);
        abort = new Abort(this, grid);
        MouseInput input = new MouseInput(window, this, grid, overflow, paths, target, timer, abort);
        addMouseListener(input);
        addMouseMotionListener(input);
    }

    public int getDifficulty() {
        return difficulty;
    }

    public GameTimer getTimer() {
        return timer;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.setFont(FontUtils.getClockFont(24f));
        
        BufferedImage menu_image = ImageUtils.getBufferedImage("resources/HTM-Background.jpg");
        g.drawImage(menu_image, 0, 0, null);

        grid.drawImage(g);
        overflow.drawImage(g);
        paths.drawImage(g);
        timer.drawImage(g);
        abort.drawImage(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.YELLOW);
        g2.setStroke(new BasicStroke(2));
        target.drawImage(g2);
    }
}