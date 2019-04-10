import java.io.File;

import javax.swing.JFileChooser;

class PhotoFindingWindow implements ActionManager
{
    JFileChooser fileChooser = new JFileChooser();
    File[] files = new File[3];

    private void getFile()
    {
        int returnVal = fileChooser.showOpenDialog(ChooseWindow.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            //This is where a real application would open the file.
            log.append("Opening: " + file.getName() + "." + newline);
        } else {
            log.append("Open command cancelled by user." + newline);
        }
    }

    @Override
    public void actionControler()
    {
    }
}