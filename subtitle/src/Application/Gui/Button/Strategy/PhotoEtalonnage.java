package Application.Gui.Button.Strategy;

import Application.*;
import Application.Gui.Button.*;
import java.awt.BorderLayout;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class PhotoEtalonnage extends ActionManager
{
    private VideoCapture camera;
    private JTextField fieldNumber;
    private JLabel picLabel;
    private Mat image = new Mat();
    private int photoNumber = 0;
    private long globalTime = 0;
    private long timeRead = 0;
    private long minute = 0;
    private long second = 0;
    private long milliSecond = 0;
    private boolean timeSetup = false;
    private Calendar calendar;

    public PhotoEtalonnage(JFrame frame)
    {
        super(frame);
    }

    private void setupCamera()
    {
        if (camera == null)
        {
            camera = new VideoCapture(0);
            camera.set(Videoio.CAP_PROP_EXPOSURE, -13);
        }
    }

    private void timeCalibration(JLabel info)
    {
        fieldNumber = new JTextField(8);
        this.frame.add(fieldNumber, BorderLayout.AFTER_LAST_LINE);
        this.frame.revalidate();
        this.frame.repaint();
        this.frame.setVisible(true);
        info.setText("Ecris le temps lu :");
        picLabel = new JLabel(new ImageIcon(ImageSubtitled.Mat2BufferedImage(image)));
        JOptionPane.showMessageDialog(null, picLabel, "Image étalonnage", JOptionPane.PLAIN_MESSAGE, null);
    }

    private void takeTimedPhoto()
    {
        ImageSubtitled.putTextLineHandle(image, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(globalTime));
        picLabel = new JLabel(new ImageIcon(ImageSubtitled.Mat2BufferedImage(image)));
        Imgcodecs.imwrite("img/photo_" + photoNumber + ".png", image);
    }

    private void setReadTime()
    {
        timeRead = Long.parseLong(fieldNumber.getText());
        timeRead = timeRead % (long)Math.pow(10, 5) + Math.round(timeRead / (long)Math.pow(10, 5)) * 60 * (long)Math.pow(10, 3);

        timeRead -= (long)(globalTime % ((long)Math.pow(10, 5) * 6));
        minute = timeRead / ((long)Math.pow(10, 4) * 6);
        if (timeRead < 0)
        {
            minute = minute + 10;
        }
        second = (Math.abs(timeRead) % ((long)Math.pow(10, 4) * 6)) / (long)Math.pow(10, 3);
        milliSecond = (Math.abs(timeRead) % ((long)Math.pow(10, 3)));
    }

    private void setTime()
    {
        calendar.add(calendar.MILLISECOND, Math.toIntExact(milliSecond));
        calendar.add(calendar.SECOND, Math.toIntExact(second));
        calendar.add(calendar.MINUTE, Math.toIntExact(minute));
    }

    public JLabel actionControler(JLabel info)
    {
        setupCamera();
        if (!timeSetup && globalTime != 0)
        {
            setReadTime();
            timeSetup = true;
        }
        calendar = Calendar.getInstance();
        globalTime = calendar.getTimeInMillis();
        camera.read(image);
        if (fieldNumber == null)
        {
            timeCalibration(info);
        }
        else
        {
            setTime();
            globalTime = calendar.getTimeInMillis();
            takeTimedPhoto();
        }

        image = new Mat();
        camera.release();
        camera = null;
        photoNumber++;
        return info;
    }
}