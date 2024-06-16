package Panels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import Utils.ImageUtils;
import inputs.TutorialMouseInput;
import main.GameWindow;

public class TutorialPanel extends JPanel {
    private BufferedImage background_image;

    public TutorialPanel(GameWindow window) {
        setBackgroundImage("HTM-Tutorial");
        TutorialMouseInput input = new TutorialMouseInput(window, this);
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
