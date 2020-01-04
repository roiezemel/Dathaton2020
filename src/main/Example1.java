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

    Text text;
    String full = "Roie is the King";
    int index = 1;
    AndroidButton button;

    public Example1() {

        setBackgroundColor(new Color(0, 120, 0));

        text = new Text("R", this);
        text.setTextColor(Color.ORANGE);
        text.setBounds(119, 248, 100, 50);
        add(text);

        button = new AndroidButton(this);
        button.setText("Click Here");
        button.setBounds(116, 298, 100, 30);
        add(button);

        Window window = new Window("Example");
        window.setSize(350, 600);
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
        text.setText(text.getText() + full.charAt(index));
        index++;
        if (index == full.length())
            index = 0;
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
