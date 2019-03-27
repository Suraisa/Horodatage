import org.opencv.core.Core;
import org.opencv.highgui.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
class App {
  static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

  public static void main(String[] args)
  {
    ImageSubtitled img = new ImageSubtitled("img/fractale.png", "img/sub_fractale.png", "img/fractale.sub");
    JFrame frame = HighGui.createJFrame("window", HighGui.WINDOW_AUTOSIZE );
    frame.setLayout(new FlowLayout());
    frame.setTitle("Horodatage");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ImageIcon guy = new ImageIcon("img/sub_fractale.png");
    JLabel pn = new JLabel(guy);
    JButton bouton = new JButton("Cliquez ici !");
    frame.add(pn);
    frame.add(bouton);

    frame.pack();
    frame.setVisible(true);


    
    // // HighGui.imshow("window", img.GetImage());
    // HighGui.waitKey(0);
  }
}