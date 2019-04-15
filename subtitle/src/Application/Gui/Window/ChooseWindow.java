package Application.Gui.Window;

import Application.Gui.Button.*;
import Application.Gui.Button.Strategy.*;

import org.opencv.highgui.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChooseWindow
{
    private JFrame frame;
    private Button photoButton;
    private Button videoButton;
    private JLabel infoLabel;
    private ActionManager photoAction = new PhotoFindingWindow(frame);
    private ActionManager videoAction = null;

    public ChooseWindow()
    {
        frame = HighGui.createJFrame("window", HighGui.WINDOW_AUTOSIZE);
        frame.setLayout(new FlowLayout());
        frame.setTitle("Horodatage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 120);

        infoLabel = new JLabel();
        photoButton = new Button("Photo", photoAction, infoLabel);
        videoButton = new Button("Vidéo", videoAction);
        frame.add(photoButton, BorderLayout.CENTER);
        frame.add(videoButton, BorderLayout.CENTER);
        frame.add(infoLabel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}