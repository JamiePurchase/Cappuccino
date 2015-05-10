package module.Supernova.entity;

import graphics.Drawing;
import java.awt.Graphics;

public class EntitySentientUnit extends EntitySentient
{
    
    public EntitySentientUnit()
    {
        
    }
    
    public void render(Graphics g)
    {
        g.drawImage(Drawing.getImage("graphics/units/temp/temp1.png", "Supernova"), 50, 50, null);
    }
    
    public void tick()
    {
        
    }
}
