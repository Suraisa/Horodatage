package Application.Gui.Button.Strategy;

import Application.Gui.Button.*;
import Application.Gui.Window.Screen.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Computer extends ActionManager {
    private Button buttonReturn;
    private Button buttonGPS;
    private Button buttonPhoto;

    public Computer(JFrame frame) {
        super(frame);
    }

    public JLabel actionControler(JLabel info) {
        return new ComputerCommandWindow().CreateWindow(this.frame);
    }
}