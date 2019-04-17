package Application.Gui.Window.Screen;

import Application.Gui.Window.*;
import Application.Gui.Button.*;
import Application.Gui.Button.Strategy.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public final class ComputerCommandWindow implements WindowCreator
{
    @Override
    public JLabel CreateWindow(JFrame frame)
    {
        frame.getContentPane().removeAll();
        JLabel infoLabel = new JLabel("You'll work with the GPS's data from the computer.");
        Button buttonGPS = new Button("GPS", new Gps(frame), infoLabel);
        Button buttonReturn = new Button("Back", new Return(frame), infoLabel);
        Button buttonPhoto = new Button("Photo", new Photo(frame), infoLabel);
        frame.add(buttonGPS, BorderLayout.CENTER);
        frame.add(buttonPhoto, BorderLayout.CENTER);
        frame.add(buttonReturn, BorderLayout.SOUTH);
        frame.add(infoLabel, BorderLayout.SOUTH);
        return infoLabel;
    }
}