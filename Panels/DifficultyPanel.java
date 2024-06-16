package Panels;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JPanel;

import Utils.ImageUtils;
import inputs.DifficultyMouseInput;
import main.GameWindow;

public class DifficultyPanel extends JPanel {
    private BufferedImage background_image;

    public DifficultyPanel(GameWindow window) {
        setBackgroundImage("HTM-Difficulty");
        DifficultyMouseInput input = new DifficultyMouseInput(window, this);
        addMouseListener(input);
        addMouseMotionListener(input);
    }

    public BufferedImage getBackgroundImage() {
        return background_image;
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

