package input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class InputMouseWheel extends MouseAdapter implements MouseWheelListener
{
    private boolean wheelAction;
    private String wheelDirection;
    private int wheelRotation;
    
    public InputMouseWheel()
    {
        this.setActionDone();
    }
    
    public boolean getAction()
    {
        return this.wheelAction;
    }
    
    public String getDirection()
    {
        return this.wheelDirection;
    }
    
    public int getRotation()
    {
        return this.wheelRotation;
    }
    
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        this.wheelAction = true;
        this.wheelRotation = e.getWheelRotation();
        if (this.wheelRotation < 0)
        {
            this.wheelDirection = "UP";
            this.wheelRotation = 0 - this.wheelRotation;
        }
        else {this.wheelDirection = "DOWN";}
        System.out.println("Mouse wheel moved " + this.wheelDirection + " " + this.wheelRotation + " notch(es)");
    }
    
    public void setActionDone()
    {
        this.wheelAction = false;
        this.wheelDirection = "NONE";
        this.wheelRotation = 0;
    }
    
}