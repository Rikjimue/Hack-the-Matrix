package Panels;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JPanel;

import Utils.ImageUtils;
import inputs.EndMouseInput;
import main.GameWindow;

public class EndPanel extends JPanel {
    private BufferedImage background_image;
    private GameWindow window;
    private String condition;
    private int prevDifficulty;

    public EndPanel(GameWindow window, String condition, int prevDifficulty) {
        this.window = window;
        this.condition = condition;
        this.prevDifficulty = prevDifficulty;
        String file_str = "HTM-End-" + condition; // Condition should either be Win or Lost
        setBackgroundImage(file_str);

        EndMouseInput input = new EndMouseInput(window, this);
        addMouseListener(input);
        addMouseMotionListener(input);
    }

    public BufferedImage getBackgroundImage() {
        return background_image;
    }

    public String getCondition() {
        return condition;
    }

    public int getPrevDifficulty() {
        return prevDifficulty;
    }

    public void setBackgroundImage(String file_str) {
        file_str = "resources/" + file_str + ".jpg";
        background_image = ImageUtils.getBufferedImage(file_str);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background_image, 0, 0, null);
    }
}