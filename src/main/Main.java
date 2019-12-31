package main;

import android_components.AndroidButton;
import components.ActionListener;
import components.Button;
import components.Component;
import containers.Panel;
import containers.Window;
import shapes.Oval;

import javax.swing.*;
import java.awt.*;

public class Main extends Panel implements ActionListener {

    public Main() {

        setBackgroundColor(new Color(0, 100, 255));

        AndroidButton button = new AndroidButton(this);
        button.setFont(new Font("Ariel", Font.BOLD, 70));
        button.setColor(Color.RED);
        button.setTextColor(Color.black);
        button.setBounds(185, 362, 200, 200);
        button.setText("NO");
        add(button);

        AndroidButton button2 = new AndroidButton(this);
        button2.setFont(new Font("Ariel", Font.BOLD, 70));
        button2.setColor(Color.GREEN);
        button2.setTextColor(Color.black);
        button2.setBounds(-13, 362, 200, 200);
        button2.setText("YES");
        add(button2);

        Window window = new Window("Test JGameV2");
        window.setSize(400, 600);
        window.add(this);
        window.appear();

        editMode(false);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;


    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void onPress(Component component) {
        repaint();
        System.out.println(component.getText() + "!!");
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
