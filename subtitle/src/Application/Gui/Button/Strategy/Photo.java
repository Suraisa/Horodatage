package Application.Gui.Button.Strategy;

import Application.*;
import Application.Gui.Button.*;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

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
    private String myObj;
    private int timeRead = 0;
    private int minute = 0;
    private int second = 0;
    private int milliSecond = 0;

    
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
        Calendar calendar = Calendar.getInstance();

        if(fieldNumber == null)
        {
            myObj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(calendar.getTimeInMillis());
            camera.read(image);
            timeCalibration(info);
        }
        else
        {
            timeRead = Integer.parseInt(fieldNumber.getText());
            minute = timeRead % 10^6;
            second = (timeRead - minute*10^6)%10^4;
            milliSecond = timeRead - minute*10^6 - second*10^4;

            myObj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(calendar.getTimeInMillis());
            camera.read(image);
            takeTimedPhoto();
        }

        image = new Mat();
        camera.release();
        camera = null;
        photoNumber++;
        return info;
    }
}