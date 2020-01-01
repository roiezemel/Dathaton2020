package components;

import tools.Wait;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.net.URL;

public class Image extends Component {

    java.awt.Image image;
    ImageObserver imageObserver;
    String path;

    public Image(ImageObserver imageObserver) {
        super();
        this.imageObserver = imageObserver;
        init();
    }

    public Image(ActionListener actionListener, ImageObserver imageObserver) {
        super(actionListener);
        this.imageObserver = imageObserver;
        init();
    }

    public Image(String path, ImageObserver imageObserver) {
        setImage(path);
        this.imageObserver = imageObserver;
        init();
    }

    public Image(String path, ActionListener actionListener, ImageObserver imageObserver) {
        super(actionListener);
        setImage(path);
        this.imageObserver = imageObserver;
        init();
    }

    private void init() {
        setBorder(null, null);
        setText(path);
        setDefaultBounds();
    }

    public java.awt.Image getImage(String path) {
        java.awt.Image tempImage = null;
        try {
            tempImage = Toolkit.getDefaultToolkit().getImage(this.getClass().getClassLoader().getResource(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempImage;
    }

    @Override
    public void drawComponent(Graphics2D g2d) {
        if (isVisible()) {
            g2d.drawImage(image, getBounds().getX(), getBounds().getY(),
                    getBounds().getWidth(), getBounds().getHeight(), imageObserver);

            // Border
            if (getBorder()[0] != null) {
                if (isBlurredBorder())
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setStroke(getBorder()[0]);
                g2d.setColor(getBorderColor()[0]);
                getShape().drawShape(g2d);
            }

            // Text
            if (!getText().equals(path)) {
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setFont(getFont()[0]);
                g2d.setColor(getTextColor()[0]);
                FontMetrics fm = g2d.getFontMetrics();
                Rectangle2D r = fm.getStringBounds(getText(), g2d);

                int x = (getBounds().getWidth() - (int) r.getWidth()) / 2 + getBounds().getX();
                int y = (getBounds().getHeight() - (int) r.getHeight()) / 2 + fm.getAscent() + getBounds().getY();

                g2d.drawString(getText(), x, y);

                // Selected
                if (this == Component.selected && showSelected) {
                    g2d.setStroke(new BasicStroke(1));
                    g2d.setColor(Color.lightGray);
                    g2d.drawRect(x - 1, y - fm.getAscent() - 1, (int) r.getWidth() + 1, (int) r.getHeight() + 1);
                }
            }
        }
    }

    public void setDefaultBounds() {
        while(image.getWidth(imageObserver) == -1);
        setBounds(getBounds().getX(), getBounds().getY(),
                image.getWidth(imageObserver), image.getHeight(imageObserver));
    }

    public void setImage(String path) {
        image = getImage(path);
        this.path = path;
    }

    public java.awt.Image getImage() {
        return image;
    }

    public ImageObserver getImageObserver() {
        return imageObserver;
    }

    public void setImageObserver(ImageObserver imageObserver) {
        this.imageObserver = imageObserver;
    }
}
