package main;

import android_components.AndroidButton;
import components.ActionListener;
import components.Button;
import components.Component;
import components.Text;
import containers.Panel;
import containers.Window;
import shapes.Oval;
import shapes.Rectangle;
import shapes.RoundRectangle;
import shapes.Shape;

import java.awt.*;

public class Example1 extends Panel implements ActionListener {

    public Example1() {

        Text text = new Text("Hello World!", this);
        add(text);

        Window window = new Window("Example");
        window.setSize(600, 600);
        window.appear();
        window.add(this);

        editMode(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }

    public static void main(String[] args) {
        new Example1();
    }

    @Override
    public void onPress(Component component) {
        repaint();
    }

    @Override
    public void onRelease(Component component) {
        repaint();
    }

    @Override
    public void onMouseOver(Component component) {
        repaint();
    }

    @Override
    public void onMouseNotOver(Component component) {
        repaint();
    }
}
