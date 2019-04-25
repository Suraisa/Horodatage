package Application.Gui.Button;

import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class ActionManager {
    protected JFrame frame;

    public ActionManager(JFrame frame) {
        this.frame = frame;
    }

    abstract public JLabel actionControler(JLabel info);
}