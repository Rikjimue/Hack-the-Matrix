package Utils;

import java.awt.Font;
import java.io.InputStream;

public class FontUtils {

    private FontUtils() {}

    public static Font getClockFont(float size) {
        Font font = null;
        try {
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("resources/CursedTimer.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(size);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return font;
    }

    public static Font getTextFont(float size) {
        Font font = null;
        try {
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("resources/digital-7.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(size);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return font;
    }
    
}
