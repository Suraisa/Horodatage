package Application.Gui.Button.Strategy;

import Application.*;
import Application.Gui.Button.*;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Window;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class PhotoFinding extends ActionManager
{
    private JFileChooser fileChooser;
    private File[] files = new File[2];
    private ImageSubtitled subtitleProcess;

    public PhotoFinding(JFrame frame)
    {
        super(frame);
    }

    private File getFile(JLabel info)
    {
        File file = null;
        int returnVal = 0;
        fileChooser = new JFileChooser();

        try
        {
            returnVal = fileChooser.showOpenDialog(frame);
        }
        catch (HeadlessException e)
        {
            returnVal = -1;
        }
        finally
        {
            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                file = fileChooser.getSelectedFile();
                info.setText("File " + file.getPath() + " choosed");
            }
            else
            {
                info.setText("Can't open the file");
            }
        }
        return file;
    }

    @Override
    public JLabel actionControler(JLabel info)
    {
        int i;
        for (i = 0; i < files.length; i++)
        {
            files[i] = getFile(info);
            info.setText("Get: " + files[i].getName());
        }
        subtitleProcess = new ImageSubtitled(files[0].getPath(),
            files[0].getPath().replaceFirst("[.][^.]+$", "") + "Sub.png", files[1].getPath());
        
        return info;
    }
}