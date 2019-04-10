import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

class Button extends JButton implements MouseListener
{
    private ActionManager action;
    public Button(String name, ActionManager action)
    {
        super(name);
        this.addMouseListener(this);
        this.action = action;
    }

    public void setAction(ActionManager action)
    {
        this.action = action;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        this.action.actionControler();
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