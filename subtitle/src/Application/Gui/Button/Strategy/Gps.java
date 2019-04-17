package Application.Gui.Button.Strategy;

import Application.Gui.Button.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gps extends ActionManager
{
    public Gps(JFrame frame)
    {
        super(frame);
    }

    public JLabel actionControler(JLabel info)
    {
        return info;
    }
}