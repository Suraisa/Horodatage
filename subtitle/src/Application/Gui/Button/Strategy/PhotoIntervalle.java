package Application.Gui.Button.Strategy;

import Application.Gui.Button.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PhotoIntervalle extends ActionManager
{
    public PhotoIntervalle(JFrame frame)
    {
        super(frame);
    }

    public JLabel actionControler(JLabel info)
    {
        return info;
    }
}