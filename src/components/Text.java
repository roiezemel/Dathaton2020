package components;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Text extends Component {

    public Text() {
        super();
        init();
    }

    public Text(ActionListener actionListener) {
        super(actionListener);
        init();
    }

    public Text(String text) {
        super();
        setText(text);
        init();
    }

    public Text(String text, ActionListener actionListener) {
        super(actionListener);
        setText(text);
        init();
    }

    private void init() {
        setBorder(null, null);
        showSelected(false);
    }

    @Override
    public void drawComponent(Graphics2D g2d) {
        if (isVisible()) {
            // Border
            if (getBorder()[0] != null) {
                if (isBlurredBorder())
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setStroke(getBorder()[0]);
                g2d.setColor(getBorderColor()[0]);
                getShape().drawShape(g2d);
            }

            // Text
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setFont(getFont()[0]);
            g2d.setColor(getTextColor()[0]);
            FontMetrics fm = g2d.getFontMetrics();
            Rectangle2D r = fm.getStringBounds(getText(), g2d);

            int x = (getBounds().getWidth() - (int) r.getWidth()) / 2 + getBounds().getX();
            int y = (getBounds().getHeight() - (int) r.getHeight()) / 2 + fm.getAscent() + getBounds().getY();

            g2d.drawString(getText(), x, y);

            // Selected
            if (this == selected && showSelected) {
                g2d.setStroke(new BasicStroke(1));
                g2d.setColor(Color.lightGray);
                g2d.drawRect(x - 1, y - fm.getAscent() - 1, (int) r.getWidth() + 1, (int) r.getHeight() + 1);
            }
        }
    }

}
