package module.Supernova.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Command
{
    public abstract void renderIcon(Graphics g, int posX, int posY);
    
    private String commandTitle;
    private BufferedImage commandIcon;
    private String commandType;
    
    public BufferedImage getIcon()
    {
        return this.commandIcon;
    }
    
    public void setIcon(BufferedImage icon)
    {
        this.commandIcon = icon;
    }
}