package GUI;

import java.awt.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

import Panels.GamePanel;
import main.GameWindow;
import main.Cell;
import Utils.FontUtils;

public class Overflow extends DrawableObject {
    private ArrayList<Cell> cells;
    private GameWindow window;

    public Overflow(GameWindow window, GamePanel panel, int size) {
        super(panel, null, 100, 30);
        this.window = window;
        cells = new ArrayList<Cell>(size);
        for (int i = 0; i < 4; i++) {
            cells.add(new Cell("Green", null, Color.RED));
        }
    }

    public void addLetter(String letter) {
        for (int i = 0; i < cells.size(); i++) {
            if (cells.get(i).getLetter() == null) {
                cells.get(i).setLetter(letter);
                return;
            }
        }
        
        window.setPanel(4);
    }

    public void drawImage(Graphics g) {
        Graphics2D g3 = (Graphics2D) g;
        g3.setColor(Color.WHITE);
        g3.setFont(FontUtils.getTextFont(18f));
        g3.drawString("Buffer Overflow", super.getLocation()[0], super.getLocation()[1] - 5);

        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(FontUtils.getClockFont(24f));

        int spacing = 4;
        for (int i = 0; i < cells.size(); i++) {
            BufferedImage image = cells.get(i).getBorderFile();
            g.drawImage(
                image,
                super.getLocation()[0] + (image.getWidth(null) + spacing) * i,
                super.getLocation()[1],
                super.getPanel()
            );

            if (cells.get(i).getLetter() != null) {
                g2.setColor(cells.get(i).getColor());

                g2.drawString(
                    cells.get(i).getLetter(), 
                    super.getLocation()[0] + (image.getWidth(null) + spacing) * i + 5, 
                    super.getLocation()[1] + 30
                );
            }
        }
    }
}
