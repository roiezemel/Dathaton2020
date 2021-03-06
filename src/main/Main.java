package main;

import android_components.AndroidButton;
import components.ActionListener;
import components.Component;
import components.Image;
import components.Text;
import containers.Panel;
import containers.Window;

import java.awt.*;

public class Main extends Panel implements ActionListener {

    Text text;

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

        Image textBubble = new Image("text.png", this, this);
        textBubble.setBounds(7, 32, 350, 100);
        add(textBubble);

        Image back = new Image("back.png", this, this);
        back.setBounds(257, 154, 100, 50);
        add(back);

        text = new Text("Is your character male?", this);
        text.setFont(new Font("Ariel", Font.BOLD, 20));
        text.setBounds(155, 54, 100, 50);
        add(text);

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
