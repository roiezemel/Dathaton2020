package shapes;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundRectangle extends Shape {

    public RoundRectangle(){}

    public RoundRectangle(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    @Override
    public void drawShape(Graphics2D g2d) {
            g2d.draw(new RoundRectangle2D.Double(x, y, width, height, 10, 10));
    }

    @Override
    public void fillShape(Graphics2D g2d) {
            g2d.fill(new RoundRectangle2D.Double(x, y, width, height, 10, 10));
    }
}
