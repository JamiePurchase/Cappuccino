package module.Supernova.world;

import engine.Game;
import graphics.Drawing;
import graphics.Tileset;
import graphics.TilesetManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Landscape
{
    // Background
    private Color bkgColour;
    
    // Border/Dimensions/Limit/Edge
    //private ??
    
    // Terrain
    private BufferedImage[][] terrainImage;
    private boolean[][] terrainSolid;
    
    // Tileset
    private Tileset tilesetMain;
    private TilesetManager tilesetManager;

    public Landscape()
    {
        // Temp
        this.bkgColour = Drawing.getColorRGB(180, 197, 133);
        
        // Temp
        this.tilesetMain = Game.getTileset("Mongun8-Exterior01");
        this.terrainImage = new BufferedImage[6][6];
        this.terrainImage[0][0] = this.tilesetMain.getTileAt(1, 1);
    }
    
    public void render(Graphics g)
    {
        renderBackground(g);
        renderTerrain(g);
    }
    
    public void renderBackground(Graphics g)
    {
        g.setColor(this.bkgColour);
        g.fillRect(0, 0, Game.width, Game.height);
    }
    
    public void renderTerrain(Graphics g)
    {
        
    }
}