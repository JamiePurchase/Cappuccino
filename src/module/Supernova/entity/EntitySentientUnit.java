package module.Supernova.entity;

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
    private int drawAnimFrame;
    private Tileset drawAnimTileset;
    
    public EntitySentientUnit()
    {
        // Temp
        this.drawFace = "SE";
        this.drawAnimTick = 0;
        this.drawAnimFrame = 1;
        this.drawAnimTileset = TilesetManager.getTileset("Character01");
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
    
    public void render(Graphics g)
    {
        g.drawImage(this.getAnimImage(), 50, 50, null);
    }
    
    public void tick()
    {
        
    }
}
