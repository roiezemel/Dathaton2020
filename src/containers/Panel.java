package containers;

import components.Component;

import java.awt.*;

import shapes.Shape;
import tools.Wait;

import javax.swing.JPanel;
import java.util.LinkedList;

public class Panel extends JPanel {

    LinkedList<Component> components = new LinkedList<>();
    LinkedList<Shape> shapes = new LinkedList<>();

    Color color = Color.WHITE;

    public void add(Component component) {
        components.add(component);
        this.addMouseListener(component);
        this.addMouseMotionListener(component);
        this.addKeyListener(component);
        this.requestFocus();
        this.setFocusable(true);
    }

    public void add(Shape shape){
        shapes.add(shape);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(color);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < components.size(); i++) {
            components.get(i).drawComponent(g2d);
        }

        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).drawShape(g2d);
        }
    }

    public void setBackgroundColor(Color color) {
        this.color = color;
    }

    public void editMode(boolean editMode) {
        for (int i = 0; i < components.size(); i++) {
            components.get(i).setDragAble(editMode);
        }
        while(editMode) {
            Wait.time(10);
            repaint();
        }
    }
}
