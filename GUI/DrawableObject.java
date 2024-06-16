package GUI;

import java.awt.*;
import java.awt.image.*;

public class DrawableObject {
    private Component panel;
    private int[] location;
    private BufferedImage image;

    public DrawableObject(Component panel, BufferedImage image, int x, int y) {
        int[] loc = {x, y};

        this.panel = panel;
        this.image = image;
        location = loc;
    }
    
    public DrawableObject(Component panel, BufferedImage image, int[] location) {
        this.panel = panel;
        this.image = image;
        this.location = location;
    }

    public Component getPanel() {
        return panel;
    }

    public int[] getLocation() {
        return location;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setLocation(int x, int y) {
        location[0] = x;
        location[1] = y;
    }

    public void drawImage(Graphics g) {
        g.drawImage(image, location[0], location[1], panel);
    }
}
