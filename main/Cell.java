package main;

import java.awt.*;
import java.awt.image.BufferedImage;

import Utils.ImageUtils;

public class Cell {
    private BufferedImage borderFile;
    private String borderColor;
    private String letter;
    private Color color;

    public Cell(String borderColor, String letter, Color color) {
        setBorderColor(borderColor);
        this.letter = letter;
        this.color = color;
    }

    public void setBorderColor(String color) {
        String fileName = "resources/HTM-" + color + "-Border.png";
        this.borderFile = ImageUtils.getBufferedImage(fileName);
        this.borderColor = color;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void setColor(Color c) {
        color = c;
    }

    public BufferedImage getBorderFile() {
        return borderFile;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public Color getColor() {
        return color;
    }

    public String getLetter() {
        return letter;
    }
}
