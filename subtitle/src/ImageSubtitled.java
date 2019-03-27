import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.*;
import org.opencv.imgproc.Imgproc;

import java.awt.image.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



class ImageSubtitled
{
    private Mat img;
    private String subtitle;

    private BufferedReader buffer = null;
    private FileReader file = null;

    public ImageSubtitled(String fileNameOpen, String subtitledFile)
    {
        this.img = Imgcodecs.imread(fileNameOpen);

        try
        {
            file = new FileReader(subtitledFile);
            buffer = new BufferedReader(file);
            
            String lineBuffer = null;

            this.subtitle = lineBuffer;

            while ((lineBuffer = buffer.readLine()) != null)
            {
                this.subtitle += "\n"+lineBuffer;
			}
        }
        catch(IOException error)
        {
            error.printStackTrace();
        }
        finally
        {

            try
            {
                if (buffer != null)
                {
                    buffer.close();
                }

                if (file != null)
                {
                    file.close();                    
                }
            } 
            
            catch (IOException ex) 
            {
				ex.printStackTrace();
            }
        }
        putTextLineHandle();
    }

    public ImageSubtitled(String fileNameOpen, String fileNameSave, String subtitledFile)
    {
        this(fileNameOpen, subtitledFile);
        saveImage(fileNameSave);
    }

    public void saveImage(String fileNameSave)
    {
        Imgcodecs.imwrite(fileNameSave, this.img);
    }

    private void putTextLineHandle()
    {
        if(this.subtitle != null)
        {
        
            Size imgSize = this.img.size();
            double y0 = imgSize.height-8;
            double dy = 15;
            String[] lines = this.subtitle.split("\n");

            int index;
            for(index = lines.length-1; index>0; index--)
            {
                Imgproc.putText(this.img, lines[index], new Point(5, y0-dy*(lines.length-1-index)), 4, 0.5, new Scalar(0,0,255));

            }
        }
    }

    public static BufferedImage Mat2BufferedImage(Mat m)
    {
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (m.channels() > 1)
        {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = m.channels()*m.cols()*m.rows();
        byte[] b = new byte[bufferSize];
        m.get(0, 0, b); // get all the pixels
        BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(b, 0, targetPixels, 0, b.length);  
        return image;
    }

    public Mat GetImage()
    {
        return this.img;
    }
}