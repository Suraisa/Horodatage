package Application.Gui.Window.Screen;

import Application.Gui.Button.*;
import Application.Gui.Button.Strategy.*;
import Application.Gui.Window.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public final class ComputerCommandWindow implements WindowCreator
{
    @Override
    public JLabel CreateWindow(JFrame frame)
    {
        frame.getContentPane().removeAll();
        JLabel infoLabel = new JLabel("<html>L'intervalle te permet de régler à la main<br>Le temps d'erreur de la photo.<br><br>"
            + "Etalonnage te permet de régler le temps avec une<br> source de temps externe (supposée absolue)</html>");
        Button buttonGPS = new Button("Intervalle", new PhotoIntervalle(frame), infoLabel);
        Button buttonReturn = new Button("Retour", new Return(frame), infoLabel);
        Button buttonPhoto = new Button("Etalonnage", new PhotoEtalonnage(frame), infoLabel);
        frame.add(buttonGPS, BorderLayout.CENTER);
        frame.add(buttonPhoto, BorderLayout.CENTER);
        frame.add(buttonReturn, BorderLayout.CENTER);
        frame.add(infoLabel, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);

        return infoLabel;
    }
}