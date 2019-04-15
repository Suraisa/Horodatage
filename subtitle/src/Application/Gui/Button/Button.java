package Application.Gui.Button;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Button extends JButton implements MouseListener
{
    private JLabel info;
    private ActionManager action;
    public Button(String name)
    {
        super(name);
        this.addMouseListener(this);
    }

    public Button(String name, ActionManager action)
    {
        this(name);
        this.action = action;
    }

    public Button(String name, ActionManager action, JLabel info)
    {
        this(name, action);
        this.info = info;
    }

    public void setAction(ActionManager action)
    {
        this.action = action;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        this.action.actionControler(this.info);
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }
}