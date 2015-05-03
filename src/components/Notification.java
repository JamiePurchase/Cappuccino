package components;

import graphics.Drawing;
import graphics.Fonts;
import java.awt.Color;
import java.awt.Graphics;

public class Notification
{
    private String message;
    private boolean active;
    private int activeTick;
    
    public Notification(String message, int tick)
    {
        this.message = message;
        this.active = true;
        this.activeTick = tick;
    }
    
    public boolean getActive()
    {
        return this.active;
    }
    
    public void render(Graphics g)
    {
        if(this.active)
        {
            g.drawImage(Drawing.getImage("system/frame200x100.png"), 583, 334, null);
            g.setFont(Fonts.getFont("standard"));
            g.setColor(Color.BLACK);
            g.drawString(this.message, 600, 360);
        }
    }
    
    public void tick()
    {
        if(this.active)
        {
            this.activeTick -= 1;
            if(activeTick < 1)
            {
                this.active = false;
            }
        }
    }
}