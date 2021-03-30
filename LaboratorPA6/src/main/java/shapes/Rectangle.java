package shapes;

import java.awt.*;

public class Rectangle extends Shape {

    public Rectangle(int x, int y, int width, int height, Color c) {
        super(x, y, width, height, c);
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setColor(getColor());
        g2d.drawRect(getX(), getY(), getWidth(), getHeight());
    }
}
