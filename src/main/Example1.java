package main;

import android_components.AndroidButton;
import components.ActionListener;
import components.Button;
import components.Component;
import containers.Panel;
import containers.Window;
import shapes.Oval;
import shapes.Rectangle;
import shapes.RoundRectangle;
import shapes.Shape;

import java.awt.*;

public class Example1 extends Panel implements ActionListener {

    public Example1() {

        AndroidButton button = new AndroidButton(this);
        button.setText("Click Me!");
        button.setShape(new RoundRectangle());
        button.setBounds(46, 481, 100, 30);
        add(button);

        AndroidButton orangeButton = new AndroidButton(this);
        orangeButton.setText("I'm Orange!");
        orangeButton.setColor(Color.orange);
        orangeButton.setBounds(150, 481, 100, 30);
        orangeButton.setShape(new RoundRectangle());
        add(orangeButton);

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
