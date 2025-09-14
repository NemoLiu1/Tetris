package net.liuwenbo.tetris;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Block {
    private int row;
    private int column;
    private BufferedImage image;

    public Block(int row, int column, BufferedImage image) {
        this.row = row;
        this.column = column;
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int setRow(int newRow) {
        int temp = row;
        row = newRow;
        return temp;
    }

    public int setColumn(int newColumn) {
        int temp = column;
        column = newColumn;
        return temp;
    }

    public void paint(Graphics g) {
        paint(g, 40, 270);
    }

    public void paint(Graphics g, int initialRow_Y, int initialColumn_X) {
        int x = initialColumn_X + column * 26;
        int y = initialRow_Y + row * 26;
        g.drawImage(image, x, y, null);
    }
}


