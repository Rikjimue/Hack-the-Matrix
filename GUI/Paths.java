package GUI;

import java.awt.*;
import java.awt.image.BufferedImage;

import Utils.FontUtils;
import main.Cell;
import main.Matrix;
import main.Path;

public class Paths extends DrawableObject {
    private Path[] paths;
    private Matrix matrix;
    
    public Paths(Component panel, Grid grid) {
        super(panel, null, grid.getLocation()[0] + 44 * grid.getMatrix().getMatrix().length + 50, 100);
        paths = grid.getMatrix().getPaths();
        this.matrix = grid.getMatrix();
    }

    public Path[] getPaths() {
        return paths;
    }

    public void drawImage(Graphics g) {
        Graphics2D g3 = (Graphics2D) g;
        g3.setFont(FontUtils.getTextFont(18f));
        g3.setColor(Color.WHITE);
        g3.drawString("Override Routines", super.getLocation()[0], super.getLocation()[1] - 5);

        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(FontUtils.getClockFont(24f));

        int spacing = 4;
        for (int i = 0; i < paths.length; i++) {
            Cell[] path = paths[i].getPath();
            for (int j = 0; j < path.length; j++) {
                BufferedImage image = path[j].getBorderFile();
                g.drawImage(
                    image, 
                    super.getLocation()[0] + (image.getWidth(null) + spacing) * j, 
                    super.getLocation()[1] + (image.getHeight(null) + spacing) * i,
                    super.getPanel()
                );

                g2.setColor(path[j].getColor());

                g2.drawString(
                    path[j].getLetter(), 
                    super.getLocation()[0] + (image.getWidth(null) + spacing) * j + 5, 
                    super.getLocation()[1] + (image.getHeight(null) + spacing) * i + 30
                );
            }
        }
    }
    
}
