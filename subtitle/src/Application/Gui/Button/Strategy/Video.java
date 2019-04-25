package Application.Gui.Button.Strategy;

import Application.Gui.Button.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Video extends ActionManager {
    public Video(JFrame frame) {
        super(frame);
    }

    public JLabel actionControler(JLabel info) {
        return info;
    }
}