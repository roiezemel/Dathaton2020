package shapes;

import java.awt.*;

public class Rectangle extends Shape {


    public Rectangle(){}

    public Rectangle(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    @Override
    public void drawShape(Graphics2D g2d) {
            g2d.drawRect(x, y, width, height);
    }

    @Override
    public void fillShape(Graphics2D g2d) {
            g2d.fillRect(x, y, width, height);
    }
}
