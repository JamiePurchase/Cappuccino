package module.Supernova.entity;

import engine.Game;
import graphics.Drawing;
import graphics.Tileset;
import graphics.TilesetManager;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import state.State;

public class EntitySentientUnit extends Entity
{
    // Drawing
    private String drawFace;
    private int drawAnimTick;
    private int drawAnimTickMax;
    private int drawAnimFrame;
    private int drawAnimFrameMax;
    private Tileset drawAnimTileset;
    
    // Selected
    private boolean selectActive;
    
    // Mouse
    private String mouseNexusRef;
    
    public EntitySentientUnit()
    {
        // Temp
        this.setEntityTitle("Knight");
        
        // Temp
        /*this.actionType = "IDLE";
        this.actionTick = 0;*/
        
        // Temp
        this.setDrawPosX(100);
        this.setDrawPosY(100);
        this.setDrawWide(48);
        this.setDrawHigh(96);
        
        // Temp
        this.drawFace = "SE";
        this.drawAnimTick = 0;
        this.drawAnimTickMax = 20;
        this.drawAnimFrame = 1;
        this.drawAnimFrameMax = 4;
        this.drawAnimTileset = TilesetManager.getTileset("Character01");
        
        // Temp
        this.selectActive = false;
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
    
    public boolean getSelected()
    {
        return this.selectActive;
    }
    
    public void mouseNexus(String ref)
    {
        Game.getInputMouse().nexusAdd(ref, 100, 100, 48, 96);
        this.mouseNexusRef = ref;
    }
    
    public void render(Graphics g, int zoom)
    {
        g.drawImage(this.getAnimImage(zoom), this.getDrawPosX(), this.getDrawPosY(), null);
    }
    
    public void setSelected(boolean value)
    {
        this.selectActive = value;
    }
    
    public void tick()
    {
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