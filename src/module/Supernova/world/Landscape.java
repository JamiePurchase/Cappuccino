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
    
    // Board
    private int boardSizeX;
    private int boardSizeY;
    private int boardViewX;
    private int boardViewY;
    private int boardZoom;
    
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
        this.boardSizeX = 5;
        this.boardSizeY = 5;
        this.boardViewX = 0;
        this.boardViewY = 0;
        this.boardZoom = 1;
        
        // Temp
        this.tilesetMain = Game.getTileset("Mongun8-Exterior01");
        this.terrainImage = new BufferedImage[6][6];
        this.terrainSetAll(this.tilesetMain.getTileAt(2, 1));
    }
    
    public int getBoardZoom()
    {
        return this.boardZoom;
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
        for(int cellY = 0; cellY < this.terrainImage.length; cellY++)
        {
            for(int cellX = 0; cellX < this.terrainImage[cellY].length; cellX++)
            {
                int screenX = (cellX * 128  / 2) + (cellY * 128  / 2);
                int screenY = (cellY * 64 / 2) - (cellX * 64 / 2);
                g.drawImage(this.terrainImage[cellX][cellY], screenX, screenY, null);
            }
        }
    }
    
    public void setBoardZoom(int value)
    {
        if(value >= 1 && value <= 3)
        {
            this.boardZoom = value;
        }
    }
    
    public void terrainSetAll(BufferedImage tile)
    {
        for(int tileX = 0; tileX < 5; tileX++)
        {
            for(int tileY = 0; tileY < 5; tileY++)
            {
                this.terrainImage[tileX][tileY] = tile;
            }
        }
    }
}