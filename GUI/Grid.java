package GUI;

import java.awt.*;
import java.awt.image.BufferedImage;

import main.Cell;
import main.Matrix;
import Utils.FontUtils;

public class Grid extends DrawableObject {
    private Matrix matrix;

    public Grid(Component panel, BufferedImage image, int x, int y, int size) {
        super(panel, image, x, y);
        matrix = new Matrix(size);
    }

    public Grid(Component panel, int x, int y, int size) {
        super(panel, null, x, y);
        matrix = new Matrix(size);
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void drawImage(Graphics g) {
        Graphics2D g3 = (Graphics2D) g;
        g3.setFont(FontUtils.getTextFont(18f));
        g3.drawString("Memory Matrix", super.getLocation()[0], super.getLocation()[1] - 5);

        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(FontUtils.getClockFont(24f));

        Cell[][] arr = matrix.getMatrix();
        BufferedImage image = arr[0][0].getBorderFile();
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        int spacing = 4;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                // Drawing grid
                g.drawImage(
                    image, 
                    super.getLocation()[0] + (width + spacing) * j, 
                    super.getLocation()[1] + (height + spacing) * i,
                    super.getPanel()
                );

                // Draw letters
                g2.setColor(arr[i][j].getColor());

                g2.drawString(
                    arr[i][j].getLetter(), 
                    super.getLocation()[0] + (width + spacing) * j + 5, 
                    super.getLocation()[1] + (height + spacing) * i + 30
                );
            }
        }
    }
}
