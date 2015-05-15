package module.Supernova.entity;

import engine.Game;
import graphics.Drawing;
import java.awt.Graphics;
import module.Supernova.game.War;

public class EntityScenery
{
    // Entity
    private War entityWar;
    
    // Drawing
    private String drawFile;
    private int drawPosX;
    private int drawPosY;
    private int drawWide;
    private int drawHigh;
    
    public EntityScenery(War war, String file, int posX, int posY, int wide, int high)
    {
        this.entityWar = war;
        this.drawFile = file;
        this.drawPosX = posX;
        this.drawPosY = posY;
        this.drawWide = wide;
        this.drawHigh = high;
    }
    
    private int getAnimPosX()
    {
        return this.getDrawPosX() - this.entityWar.getLandscape().getBoardViewX();
    }
    
    private int getAnimPosY()
    {
        return this.getDrawPosY() - this.entityWar.getLandscape().getBoardViewX();
    }
    
    public int getDrawPosX()
    {
        return this.drawPosX;
    }
    
    public int getDrawPosY()
    {
        return this.drawPosY;
    }
    
    public void render(Graphics g, int zoom)
    {
        g.drawImage(Drawing.getImage(this.drawFile, "Supernova"), this.getAnimPosX(), this.getAnimPosY(), null);
    }
}
