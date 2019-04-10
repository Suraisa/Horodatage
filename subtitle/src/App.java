import org.opencv.core.Core;
import org.opencv.highgui.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

class App {
  static {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
  }

  public static void main(String[] args) {
    ImageSubtitled img = new ImageSubtitled("img/fractale.png", "img/sub_fractale.png", "img/fractale.sub");

    // ImageIcon guy = new ImageIcon("img/sub_fractale.png");
    // JLabel pn = new JLabel(guy);
    // frame.add(pn);


    // frame.pack();
    ChooseWindow window = new ChooseWindow();
    // // HighGui.imshow("window", img.GetImage());
    // HighGui.waitKey(0);
  }
}