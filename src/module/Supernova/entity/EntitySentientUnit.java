package module.Supernova.entity;

import engine.Game;
import graphics.Drawing;
import graphics.Tileset;
import graphics.TilesetManager;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
        this.drawFace = "SE";
        this.drawAnimTick = 0;
        this.drawAnimTickMax = 5;
        this.drawAnimFrame = 1;
        this.drawAnimFrameMax = 3;
        this.drawAnimTileset = TilesetManager.getTileset("Character01");
        
        // Temp
        this.selectActive = false;
    }
    
    private BufferedImage getAnimImage()
    {
        int tileX = this.drawAnimFrame;
        int tileY = 1;
        if(this.drawFace == "SW") {tileY = 2;}
        if(this.drawFace == "NE") {tileY = 3;}
        if(this.drawFace == "NW") {tileY = 4;}
        return this.drawAnimTileset.getTileAt(tileX, tileY);
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
    
    public void render(Graphics g)
    {
        g.drawImage(this.getAnimImage(), 100, 100, null);
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