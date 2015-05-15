package module.Antics.board;

import graphics.Tileset;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BoardTile
{
    private BufferedImage terrainImage;
    private String terrainFile;
    private boolean tileSolid;
    private boolean scenery;
    private BufferedImage sceneryImage;
    private String sceneryFile;
    
    public BoardTile(String ref, int id, int tileX, int tileY)
    {
        this.terrainImage = new Tileset(ref).getTileAt(tileX, tileY);
        this.terrainFile = id + "|" + tileX + "|" + tileY;
        this.tileSolid = false;
        this.scenery = false;
        this.sceneryFile = "";
    }
    
    public boolean getScenery()
    {
        return this.scenery;
    }
    
    public String getSceneryFile()
    {
        return this.sceneryFile;
    }
    
    public String getTerrainFile()
    {
        return this.terrainFile;
    }
    
    public void render(Graphics g, int drawX, int drawY)
    {
        g.drawImage(this.terrainImage, drawX, drawY, null);
        if(this.scenery) {g.drawImage(this.sceneryImage, drawX, drawY, null);}
    }
    
    public void setScenery(BufferedImage image, boolean solid)
    {
        this.scenery = true;
        this.sceneryImage = image;
        this.tileSolid = true;
    }
    
    public void setTerrain(BufferedImage image)
    {
        this.terrainImage = image;
    }
    
    public void tick()
    {
        
    }
}