package components;

public class Button extends Component{

    public Button() {
        setText("Button");
    }

    public Button(ActionListener actionListener) {
        super(actionListener);
        setText("Button");
    }

}
