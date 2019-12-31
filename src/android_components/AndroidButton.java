package android_components;

import components.ActionListener;
import components.Component;
import shapes.Rectangle;

import java.awt.*;

public class AndroidButton extends Component {

    int darkenAmount = 20;
    Color color = new Color(220, 70, 170);
    Color darker = darker(color, darkenAmount);

    Font font = new Font("Ariel", Font.BOLD, 13);

    public AndroidButton() {
        setShape(new Rectangle());
        setBounds(100, 100, 100, 30);
        setColor(color);
        setTextColor(Color.white, Color.white);
        setBorder(new BasicStroke(0), new BasicStroke(0));
        setFont(font, font);
        showSelected(false);
    }

    public AndroidButton(ActionListener actionListener) {
        addActionListener(actionListener);
        setShape(new Rectangle());
        setBounds(100, 100, 100, 30);
        setColor(color);
        setTextColor(Color.white, Color.white);
        setBorder(new BasicStroke(0), new BasicStroke(0));
        setFont(font, font);
        showSelected(false);
    }

    public void setColor(Color color) {
        this.color = color;
        this.darker = darker(color, darkenAmount);
        setBgColor(color, darker);
        setBorderColor(color, color);
    }

    public void setDarkenAmount(int darkenAmount) {
        this.darkenAmount = darkenAmount;
    }

    public Color darker(Color color, int amount) {
        int r = color.getRed() - amount;
        int g = color.getGreen() - amount;
        int b = color.getBlue() - amount;
        r = r < 0 ? 0 : r;
        g = g < 0 ? 0 : g;
        b = b < 0 ? 0 : b;
        return new Color(r, g, b);
    }

}
