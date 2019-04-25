package Application.Gui.Window;

import Application.Gui.Window.Screen.*;

import Application.Gui.Button.*;
import Application.Gui.Button.Strategy.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.highgui.*;

public class ChooseWindow
{
    private JFrame frame;
    private JLabel info;


    public ChooseWindow()
    {
        frame = HighGui.createJFrame("window", HighGui.WINDOW_AUTOSIZE);
        frame.setLayout(new FlowLayout());
        frame.setTitle("Horodatage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        info = new HomeWindow().CreateWindow(frame);

        frame.setVisible(true);
    }
}