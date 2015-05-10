package module.Supernova.entity;

import java.awt.Graphics;

public abstract class Entity
{
    public abstract void render(Graphics g, int zoom);
    public abstract void tick();
    
    // Details
    private String entityTitle;
    
    // Drawing
    private String drawFile;
    private int drawPosX;
    private int drawPosY;
    private int drawWide;
    private int drawHigh;
    
    // Audio
    private String audioFile;
    
    public int getDrawHigh()
    {
        return this.drawHigh;
    }
    
    public int getDrawPosX()
    {
        return this.drawPosX;
    }
    
    public int getDrawPosY()
    {
        return this.drawPosY;
    }
    
    public int getDrawWide()
    {
        return this.drawWide;
    }
    
    public String getEntityTitle()
    {
        return this.entityTitle;
    }
    
    public void setDrawHigh(int value)
    {
        this.drawHigh = value;
    }
    
    public void setDrawPosX(int value)
    {
        this.drawPosX = value;
    }
    
    public void setDrawPosY(int value)
    {
        this.drawPosY = value;
    }
    
    public void setDrawWide(int value)
    {
        this.drawWide = value;
    }
    
    public void setEntityTitle(String title)
    {
        this.entityTitle = title;
    }
}