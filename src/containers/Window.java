package containers;

import javax.swing.*;

public class Window extends JFrame {

    public Window() {}

    public Window(String title) {
        super(title);
    }

    public void appear() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
