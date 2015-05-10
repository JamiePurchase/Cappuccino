package module.Supernova.entity;

import java.awt.Graphics;

public abstract class Entity
{
    public abstract void render(Graphics g);
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
}