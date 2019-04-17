package Application.Gui.Button.Strategy;

import Application.Gui.Button.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class Photo extends ActionManager
{
    VideoCapture camera;
    Mat image = new Mat();

    
    public Photo(JFrame frame)
    {
        super(frame);
    }

    public JLabel actionControler(JLabel info)
    {
        if(camera == null)
        {
            camera = new VideoCapture(0);
        }
        
        camera.read(image); 
        Imgcodecs.imwrite("img/testzrovhkeur.png", image);
        return info;
    }
}