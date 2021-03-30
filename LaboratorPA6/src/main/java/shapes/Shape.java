package shapes;

import java.awt.*;

public abstract class Shape {

    private int x, y;
    private int width, height;
    private Color c;

    public Shape(int x, int y, int width, int height, Color c) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return c;
    }

    public abstract void paint(Graphics2D g2d);
}
