package Utils;

import java.io.IOException;
import java.net.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import main.Game;

public class ImageUtils {
    
    public static BufferedImage getBufferedImage(String file_path) {
        BufferedImage image = null;
        try {
            URL url = Game.class.getClassLoader().getResource(file_path);
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }
}
