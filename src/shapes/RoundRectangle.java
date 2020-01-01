package shapes;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundRectangle extends Shape {

    int arcW = 10;
    int arcH = 10;

    public RoundRectangle(){}

    public RoundRectangle(int arcW, int arcH) {
        this.arcW = arcW;
        this.arcH = arcH;
    }

    public RoundRectangle(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    @Override
    public void drawShape(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.draw(new RoundRectangle2D.Double(x, y, width, height, arcW, arcH));
    }

    @Override
    public void fillShape(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fill(new RoundRectangle2D.Double(x, y, width, height, arcW, arcH));
    }
}
