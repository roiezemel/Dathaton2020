package shapes;

import java.awt.*;

public class Oval extends Shape {

    public Oval(){}

    public Oval(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    @Override
    public void drawShape(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawOval(x, y, width, height);
    }

    @Override
    public void fillShape(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x, y, width, height);
    }

}
