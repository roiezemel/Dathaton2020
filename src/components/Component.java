package components;

import java.awt.*;
import shapes.Rectangle;
import shapes.RoundRectangle;
import shapes.Shape;

import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;

public abstract class Component implements MouseMotionListener, MouseListener, KeyListener {

    private Rectangle bounds = new Rectangle(0, 0, 100, 50);
    private Shape shape = new RoundRectangle();
    LinkedList<ActionListener> actionListeners = new LinkedList<>();
    private boolean dragAble = false;
    private boolean visible = true;
    public static Component selected = null;

    //  Graphics
    private Color[] bgColor;
    private Color[] borderColor;
    private Color[] textColor;
    private BasicStroke[] border;
    private Font[] font;

    private String text = "Component";

    private boolean blurredBorder = true;
    private boolean mouseOver = false;
    private boolean onDrag = false;
    protected static boolean showSelected = true;

    public Component() {
        this.bgColor = new Color[] {Color.WHITE, new Color(241, 241, 255)};
        this.borderColor = new Color[] {Color.BLUE, new Color(76, 138, 250)};
        Color textColor = Color.BLACK;
        this.textColor = new Color[] {textColor, textColor};
        this.border = new BasicStroke[] {new BasicStroke(1), new BasicStroke(2)};
        Font font = new Font("Ariel", Font.BOLD, 15);
        this.font = new Font[] {font, font};
    }

    public Component(ActionListener actionListener) {
        this.actionListeners.add(actionListener);
        this.bgColor = new Color[] {Color.WHITE, new Color(241, 241, 255)};
        this.borderColor = new Color[] {Color.BLUE, new Color(76, 138, 250)};
        Color textColor = Color.BLACK;
        this.textColor = new Color[] {textColor, textColor};
        this.border = new BasicStroke[] {new BasicStroke(1), new BasicStroke(2)};
        Font font = new Font("Ariel", Font.BOLD, 15);
        this.font = new Font[] {font, font};
    }

    private Color[] swap(Color[] colors) {
        Color o1 = colors[0];
        Color o2 = colors[1];
        return new Color[] {o2, o1};
    }

    private BasicStroke[] swap(BasicStroke[] strokes) {
        BasicStroke o1 = strokes[0];
        BasicStroke o2 = strokes[1];
        return new BasicStroke[] {o2, o1};
    }

    private Font[] swap(Font[] fonts) {
        Font o1 = fonts[0];
        Font o2 = fonts[1];
        return new Font[] {o2, o1};
    }

    public void drawComponent(Graphics2D g2d) {
        if (visible) {
            // Background
            g2d.setColor(bgColor[0]);
            this.shape.fillShape(g2d);

            // Border
            if (blurredBorder)
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(border[0]);
            g2d.setColor(borderColor[0]);
            this.shape.drawShape(g2d);

            // Text
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setFont(font[0]);
            g2d.setColor(textColor[0]);
            FontMetrics fm = g2d.getFontMetrics();
            Rectangle2D r = fm.getStringBounds(text, g2d);

            int x = (getBounds().getWidth() - (int) r.getWidth()) / 2 + getBounds().getX();
            int y = (getBounds().getHeight() - (int) r.getHeight()) / 2 + fm.getAscent() + getBounds().getY();

            g2d.drawString(text, x, y);

            // Selected
            if (this == selected && showSelected) {
                g2d.setStroke(new BasicStroke(1));
                g2d.setColor(Color.lightGray);
                g2d.drawRect(x - 1, y - fm.getAscent() - 1, (int) r.getWidth() + 1, (int) r.getHeight() + 1);
            }
        }
    }

    public void addActionListener(ActionListener actionListener) {
        this.actionListeners.add(actionListener);
    }

    public static void showSelected(boolean showSelected) {
        Component.showSelected = showSelected;
    }

    protected java.awt.Rectangle getAwtRect(){
        return new java.awt.Rectangle(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
        this.shape.setBounds(bounds);
    }

    public void setBounds(int x, int y, int width, int height) {
        this.bounds = new Rectangle(x, y, width, height);
        this.shape.setBounds(bounds);
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
        this.shape.setBounds(bounds);
    }

    public boolean isDragAble() {
        return dragAble;
    }

    public void setDragAble(boolean dragAble) {
        this.dragAble = dragAble;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isSelected() {
        return selected == this;
    }

    public void setSelected(boolean selected) {
        Component.selected = selected ? this : Component.selected;
    }

    public Color[] getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color... bgColor) {
        this.bgColor = bgColor;
    }

    public Color[] getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color... borderColor) {
        this.borderColor = borderColor;
    }

    public Color[] getTextColor() {
        return textColor;
    }

    public void setTextColor(Color... textColor) {
        this.textColor = textColor;
    }

    public BasicStroke[] getBorder() {
        return border;
    }

    public void setBorder(BasicStroke... border) {
        this.border = border;
    }

    public Font[] getFont() {
        return font;
    }

    public void setFont(Font... font) {
        this.font = font;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isBlurredBorder() {
        return blurredBorder;
    }

    public void setBlurredBorder(boolean blurredBorder) {
        this.blurredBorder = blurredBorder;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(getAwtRect().intersects(new java.awt.Rectangle(e.getX(), e.getY(), 1, 1))){
            onDrag = true;
            bgColor = swap(bgColor);
            for(int i = 0; i<actionListeners.size(); i++){
                actionListeners.get(i).onPress(this);
            }
            setSelected(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(isDragAble()){
            System.out.println(getText() + " Bounds: " + getBounds().getX() + ", " + getBounds().getY() + ", "
                    + getBounds().getWidth() + ", " + getBounds().getHeight());
        }
        if(onDrag){
            bgColor = swap(bgColor);
            for(int i = 0; i<actionListeners.size(); i++){
                actionListeners.get(i).onRelease(this);
            }
        }
        onDrag = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(onDrag && isDragAble()){
            setBounds(e.getX() - getBounds().getWidth()/2, e.getY() - getBounds().getHeight()/2 , getBounds().getWidth(), getBounds().getHeight());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(getAwtRect().intersects(new java.awt.Rectangle(e.getX(), e.getY(), 1, 1)) && !mouseOver){
            mouseOver = true;
            borderColor = swap(borderColor);
            border = swap(border);
            for (int i = 0; i<actionListeners.size(); i++){
                actionListeners.get(i).onMouseOver(this);
            }
        }
        else if (!getAwtRect().intersects(new java.awt.Rectangle(e.getX(), e.getY(), 1, 1)) && mouseOver){
            mouseOver = false;
            borderColor = swap(borderColor);
            border = swap(border);
            for(int i = 0; i<actionListeners.size(); i++){
                actionListeners.get(i).onMouseNotOver(this);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(selected == this) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                bgColor = swap(bgColor);
                for (int i = 0; i < actionListeners.size(); i++) {
                    actionListeners.get(i).onPress(this);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(selected == this) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                bgColor = swap(bgColor);
                for (int i = 0; i < actionListeners.size(); i++) {
                    actionListeners.get(i).onRelease(this);
                }
            }
        }
    }
}
