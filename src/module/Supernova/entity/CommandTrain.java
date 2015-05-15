package module.Supernova.entity;

import graphics.Drawing;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class CommandTrain extends Command
{
    // NOTE: do we want a string or a template? an actual unit isn't correct
    private String trainUnit;
    
    public CommandTrain(String icon)
    {
        this.setIcon(Drawing.getImage("graphics/icons/train/" + icon + ".png", "Supernova"));
    }
    
    public void renderIcon(Graphics g, int posX, int posY)
    {
        g.drawImage(this.getIcon(), posX, posY, null);
    }
}