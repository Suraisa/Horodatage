package Application.Gui.Button.Strategy;

import Application.Gui.Window.Screen.*;
import Application.Gui.Button.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Return extends ActionManager
{
    public Return(JFrame frame)
    {
        super(frame);
    }

    public JLabel actionControler(JLabel info)
    {
        JLabel newInfo = new HomeWindow().CreateWindow(frame);
        return newInfo;
    }
}