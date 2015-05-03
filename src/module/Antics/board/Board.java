package module.Antics.board;

import graphics.Drawing;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Board
{
    // Details
    private String boardName;
    private int boardSizeX;
    private int boardSizeY;
    private BoardTile[][] boardTiles;
    // Note: Make a tile class to hold layered animations, elevation, collision, footsteps, etc...
    
    // Entities
    //
    
    // Encounters
    private boolean boardEncounters;
    
    // Audio
    //
    
    public Board(String name, int sizeX, int sizeY)
    {
        this.boardName = name;
        this.boardSizeX = sizeX;
        this.boardSizeY = sizeY;
        this.boardTiles = new BoardTile[sizeX][sizeY];
    }
    
    public void buildTiles()
    {
        for(int x = 0; x < this.getBoardSizeX(); x++)
        {
            for(int y = 0; y < this.getBoardSizeY(); y++)
            {
                this.boardTiles[x][y] = new BoardTile(Drawing.getImage("texture/grass1.png", "Antics"), x+1, y+1, false);
            }
        }
    }
    
    public int getBoardSizeX()
    {
        return this.boardSizeX;
    }
    
    public int getBoardSizeY()
    {
        return this.boardSizeY;
    }
    
    public void render(Graphics g)
    {
        renderBackground(g);
        renderTiles(g);
        renderPlayer(g);
        renderEntities(g);
    }
    
    public void renderEntities(Graphics g)
    {
        
    }
    
    public void renderBackground(Graphics g)
    {
        g.setColor(Drawing.getColorRGB(154, 228, 71));
        g.fillRect(0, 0, 1366, 768);
    }
    
    public void renderPlayer(Graphics g)
    {
        
    }
    
    public void renderTiles(Graphics g)
    {
        for(int x = 0; x < this.getBoardSizeX(); x++)
        {
            for(int y = 0; y < this.getBoardSizeY(); y++)
            {
                //this.boardTiles[x][y].render(g);
            }
        }
    }
    
    public void tick()
    {
        
    }
}