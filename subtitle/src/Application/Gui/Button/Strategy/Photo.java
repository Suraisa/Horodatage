package Application.Gui.Button.Strategy;

import Application.*;
import Application.Gui.Button.*;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class Photo extends ActionManager
{
    private VideoCapture camera;
    private JTextField fieldNumber;
    private JLabel picLabel;
    private Mat image = new Mat();
    private int photoNumber = 0;
    private long timePassed;

    
    public Photo(JFrame frame)
    {
        super(frame);
    }

    private void setupCamera()
    {
        if(camera == null)
        {
            camera = new VideoCapture(0);
            camera.set(Videoio.CAP_PROP_EXPOSURE,-13);
        }
    }

    private void timeCalibration(JLabel info)
    {
        fieldNumber = new JTextField(8);
        this.frame.add(fieldNumber, BorderLayout.SOUTH);
        this.frame.revalidate();
        this.frame.repaint();
        this.frame.setVisible(true);
        info.setText("Write the number:");
        picLabel = new JLabel(new ImageIcon(ImageSubtitled.Mat2BufferedImage(image)));
        JOptionPane.showMessageDialog(null, picLabel, "PhotoTest", JOptionPane.PLAIN_MESSAGE, null);
    }

    private void takeTimedPhoto()
    {
        ImageSubtitled.putTextLineHandle(image, fieldNumber.getText());
        picLabel = new JLabel(new ImageIcon(ImageSubtitled.Mat2BufferedImage(image)));
        // JOptionPane.showMessageDialog(null, picLabel, "result", JOptionPane.PLAIN_MESSAGE, null);
        Imgcodecs.imwrite("img/photo_"+photoNumber+".png", image);
    }

    public JLabel actionControler(JLabel info)
    {
        setupCamera();

        camera.read(image);
        timePassed = System.nanoTime();
        if(fieldNumber == null)
        {
            timeCalibration(info);
            timePassed = System.nanoTime() - timePassed;
            System.out.println("calibration: " +timePassed);
        }
        else
        {
            takeTimedPhoto();
            timePassed = System.nanoTime() - timePassed;
            System.out.println("\nTime passed: "+timePassed);
        }
        image = new Mat();
        camera.release();
        camera = null;
        photoNumber++;
        return info;
    }
}