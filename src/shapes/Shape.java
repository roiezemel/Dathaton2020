package shapes;

import java.awt.*;

public abstract class Shape {

    int x;
    int y;
    int width;
    int height;
    boolean fill = false;

    public Shape(){}

    public Shape(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setBounds(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setBounds(Rectangle rect){
        x = rect.x;
        y = rect.y;
        width = rect.width;
        height = rect.height;
    }

    public void setFill(boolean fill){
        this.fill = fill;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isFilled(){
        return fill;
    }

    public abstract void drawShape(Graphics2D g2d);

    public abstract void fillShape(Graphics2D g2d);

}
