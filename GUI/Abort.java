package GUI;

import java.awt.*;

import Utils.FontUtils;

public class Abort extends DrawableObject{

    public Abort(Component panel, Grid grid) {
        super(panel, null, grid.getLocation()[0] + 44 * grid.getMatrix().getMatrix().length + 50, 30);
    }

    public void drawImage(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.RED);
        g2.setFont(FontUtils.getTextFont(24f));

        g2.drawRect(super.getLocation()[0], super.getLocation()[1], 100, 35);
        g2.drawString("ABORT", super.getLocation()[0] + 20, super.getLocation()[1] + 25);
    }
    
}
