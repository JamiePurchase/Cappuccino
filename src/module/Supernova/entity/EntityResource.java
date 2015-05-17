package module.Supernova.entity;

import engine.Game;
import graphics.Drawing;
import java.awt.Graphics;
import module.Supernova.game.War;

public class EntityResource
{
    // Entity
    private War entityWar;
    
    // Resource
    private String resourceType;
    private int resourceTotal;
    
    // Drawing (NOTE: should we animate the crystal desposit getting smaller as it is collected?)
    private String drawFile;
    private int drawPosX;
    private int drawPosY;
    private int drawWide;
    private int drawHigh;
    
    // Selected
    private boolean selectActive;
    
    // Mouse
    private String mouseNexusRef;
        
    public EntityResource(War war, String resourceType, int resourceTotal, String file, int posX, int posY, int wide, int high)
    {
        this.entityWar = war;
        this.resourceType = resourceType;
        this.resourceTotal = resourceTotal;
        this.drawFile = file;
        this.drawPosX = posX;
        this.drawPosY = posY;
        this.drawWide = wide;
        this.drawHigh = high;
        this.selectActive = false;
    }
    
    private int getAnimPosX()
    {
        return this.getDrawPosX() - this.entityWar.getLandscape().getBoardViewX();
    }
    
    private int getAnimPosY()
    {
        return this.getDrawPosY() - this.entityWar.getLandscape().getBoardViewX();
    }
    
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
    
    public String getTitle()
    {
        // TEMP
        return "Sternumite Deposit";
    }
    
    public void mouseNexus(String ref)
    {
        Game.getInputMouse().nexusAdd(ref, this.getAnimPosX(), this.getAnimPosY(), this.getDrawWide(), this.getDrawHigh());
        this.mouseNexusRef = ref;
    }
    
    public void render(Graphics g, int zoom)
    {
        g.drawImage(Drawing.getImage(this.drawFile, "Supernova"), this.getAnimPosX(), this.getAnimPosY(), null);
    }
    
    public void setSelected(boolean value)
    {
        this.selectActive = value;
    }
}