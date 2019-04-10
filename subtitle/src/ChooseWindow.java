import org.opencv.core.Core;
import org.opencv.highgui.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

class ChooseWindow
{
    private JFrame frame;
    private JButton photoButton;
    private JButton videoButton;

    public ChooseWindow()
    {
        frame = HighGui.createJFrame("window", HighGui.WINDOW_AUTOSIZE);
        frame.setLayout(new FlowLayout());
        frame.setTitle("Horodatage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 100);

        photoButton = new JButton("Photo");
        videoButton = new JButton("Vidéo");
        frame.add(photoButton, BorderLayout.CENTER);
        frame.add(videoButton, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}