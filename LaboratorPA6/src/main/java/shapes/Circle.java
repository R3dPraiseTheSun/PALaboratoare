package shapes;

import java.awt.*;

public class Circle extends Shape {

    public Circle(int x, int y, int width, int height, Color c) {
        super(x, y, width, height, c);
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setColor(getColor());
        g2d.drawOval(getX(), getY(), getWidth(), getHeight());
    }
}
