package module.Supernova.entity;

import engine.Game;
import graphics.Drawing;
import graphics.Tileset;
import graphics.TilesetManager;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import module.Supernova.game.War;

public class EntityUnit
{
    // Entity
    private War entityWar;
    private String entityTitle;
    private int entityForce;
    private int entityUnit;
    private EntityAction entityAction;
    
    // Drawing
    private String drawFile;
    private int drawPosX;
    private int drawPosY;
    private int drawWide;
    private int drawHigh;
    private String drawFace;
    private int drawAnimTick;
    private int drawAnimTickMax;
    private int drawAnimFrame;
    private int drawAnimFrameMax;
    private Tileset drawAnimTileset;
    
    // Audio
    private String audioFile;
    
    // Selected
    private boolean selectActive;
    
    // Mouse
    private String mouseNexusRef;
    
    public EntityUnit(War war, int force, int unit)
    {
        // Entity
        this.entityWar = war;
        this.entityTitle = "Knight";
        this.entityForce = force;
        this.entityUnit = unit;
        this.entityAction = new EntityActionIdle();
        
        // Drawing
        this.drawPosX = 100;
        this.drawPosY = 100;
        this.drawWide = 48;
        this.drawHigh = 96;
        this.drawFace = "SE";
        this.drawAnimTick = 0;
        this.drawAnimTickMax = 20;
        this.drawAnimFrame = 1;
        this.drawAnimFrameMax = 4;
        this.drawAnimTileset = TilesetManager.getTileset("Character01");
        
        // Temp
        this.selectActive = false;
    }
    
    public EntityAction getAction()
    {
        return this.entityAction;
    }
    
    private int getAnimPosX()
    {
        return this.getDrawPosX() - this.entityWar.getLandscape().getBoardViewX();
    }
    
    private int getAnimPosY()
    {
        return this.getDrawPosY() - this.entityWar.getLandscape().getBoardViewX();
    }
    
    private BufferedImage getAnimImage(int zoom)
    {
        int posX = this.drawAnimFrame;
        int posY = 1;
        if(this.drawFace == "SW") {posY = 2;}
        if(this.drawFace == "NE") {posY = 3;}
        if(this.drawFace == "NW") {posY = 4;}
        BufferedImage image = this.drawAnimTileset.getTileAt(posX, posY);
        if(zoom > 1)
        {
            return Drawing.resize(image, (this.getDrawWide() / zoom), (this.getDrawHigh() / zoom));
        }
        return image;
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
    
    public boolean getSelected()
    {
        return this.selectActive;
    }
    
    public String getTitle()
    {
        return this.entityTitle;
    }
    
    public void mouseNexus(String ref)
    {
        Game.getInputMouse().nexusAdd(ref, this.getAnimPosX(), this.getAnimPosY(), this.getDrawWide(), this.getDrawHigh());
        this.mouseNexusRef = ref;
    }
    
    public void move(String direction)
    {
        this.setDrawPosX(this.getDrawPosX() + 1);
    }
    
    public void render(Graphics g, int zoom)
    {
        g.drawImage(this.getAnimImage(zoom), this.getAnimPosX(), this.getAnimPosY(), null);
    }
    
    public void setAction(EntityAction action)
    {
        this.entityAction = action;
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
    
    public void setTitle(String title)
    {
        this.entityTitle = title;
    }
    
    public void setSelected(boolean value)
    {
        this.selectActive = value;
    }
    
    public void tick()
    {
        // Debug
        //System.out.println("Unit (F" + this.entityForce + " U" + this.entityUnit + ") tick" + this.debugWarTick);
        
        this.tickAction();
    }
    
    private void tickAction()
    {
        // Action
        this.getAction().tick();
        
        // Tick
        if(this.drawAnimTickMax > 0)
        {
            this.drawAnimTick += 1;
            if(this.drawAnimTick > this.drawAnimTickMax)
            {
                this.drawAnimTick = 0;
                this.drawAnimFrame += 1;
                if(this.drawAnimFrame > this.drawAnimFrameMax)
                {
                    this.drawAnimFrame = 1;
                    // NOTE: Was this a one time action that was preventing input?
                    // or are we repeating the action over and over until something else?
                }
            }
        }
    }
}