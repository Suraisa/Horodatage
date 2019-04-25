package Application.Gui.Window.Screen;

import Application.Gui.Window.*;
import Application.Gui.Button.*;
import Application.Gui.Button.Strategy.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public final class HomeWindow implements WindowCreator
{
    @Override
    public JLabel CreateWindow(JFrame frame)
    {
        frame.getContentPane().removeAll();
        JLabel infoLabel = new JLabel();
        Button photoButton = new Button("PhotoTreatment", new Computer(frame), infoLabel);
        Button videoButton = new Button("VideoTreatment", new VideoFinding(frame), infoLabel);
        frame.add(photoButton, BorderLayout.CENTER);
        frame.add(videoButton, BorderLayout.CENTER);
        frame.add(infoLabel, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
        return infoLabel;
    }
}