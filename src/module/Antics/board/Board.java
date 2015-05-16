package module.Antics.board;

import engine.Game;
import file.FileWrite;
import graphics.Drawing;
import graphics.Tileset;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.Antics.entity.Player;

public class Board
{
    // Details
    private String boardTitle;
    private int boardDrawX;
    private int boardDrawY;
    private int boardSizeX;
    private int boardSizeY;
    private int boardViewX;
    private int boardViewY;
    private BoardTile[][] boardTiles;
    private String[] boardTileset = new String[3];
    // Note: Make a tile class to hold layered animations, elevation, collision, footsteps, etc...
    
    // Entities
    private Player entityPlayer;
    
    // Encounters
    private boolean boardEncounters;
    
    // Audio
    //
    
    public Board(String title, int sizeX, int sizeY)
    {
        this.boardTitle = title;
        this.boardDrawX = 0;
        this.boardDrawY = 0;
        this.boardSizeX = sizeX;
        this.boardSizeY = sizeY;
        this.boardViewX = 0;
        this.boardViewY = 0;
        
        // Tilesets
        this.boardTileset[0] = "texture/Shumak01.png|Antics|32|32|6|5";
        this.boardTileset[1] = "tileset/Shumak01.png|Antics|32|32|6|5";
        this.boardTileset[2] = "tileset/Shumak02.png|Antics|32|32|4|4";
        
        // Tiles
        this.boardTiles = new BoardTile[sizeX][sizeY];
        this.buildTiles("texture/Shumak01.png|Antics|32|32|6|5", 0, 2, 1);
        // NOTE: buildTiles is filling the entire board with this terrain
        // we need to instead use each line of the board froth file
        
        // Player
        this.entityPlayer = new Player(this, 6, 9, "S");
        
        // Temp
        this.fileSave();
    }
    
    public void buildTiles(String tilesetName, int tilesetID, int tileX, int tileY)
    {
        Tileset tileset00 = new Tileset(this.boardTileset[0]);
        Tileset tileset01 = new Tileset(this.boardTileset[1]);
        Tileset tileset02 = new Tileset(this.boardTileset[2]);
        
        for(int x = 0; x < this.getBoardSizeX(); x++)
        {
            for(int y = 0; y < this.getBoardSizeY(); y++)
            {
                this.boardTiles[x][y] = new BoardTile(tilesetName, tilesetID, tileX, tileY);
            }
        }
        
        // Temp Tree
        this.boardTiles[0][0].setScenery(tileset02.getTileAt(1, 1), true);
        this.boardTiles[0][1].setScenery(tileset02.getTileAt(1, 2), true);
        
        // Temp House
        this.boardTiles[5][3].setScenery(tileset01.getTileAt(1, 1), true);
        this.boardTiles[6][3].setScenery(tileset01.getTileAt(2, 1), true);
        this.boardTiles[7][3].setScenery(tileset01.getTileAt(5, 1), true);
        this.boardTiles[8][3].setScenery(tileset01.getTileAt(6, 1), true);
        this.boardTiles[5][4].setScenery(tileset01.getTileAt(1, 2), true);
        this.boardTiles[6][4].setScenery(tileset01.getTileAt(2, 2), true);
        this.boardTiles[7][4].setScenery(tileset01.getTileAt(5, 2), true);
        this.boardTiles[8][4].setScenery(tileset01.getTileAt(6, 2), true);
        this.boardTiles[5][5].setScenery(tileset01.getTileAt(1, 3), true);
        this.boardTiles[6][5].setScenery(tileset01.getTileAt(2, 3), true);
        this.boardTiles[7][5].setScenery(tileset01.getTileAt(5, 3), true);
        this.boardTiles[8][5].setScenery(tileset01.getTileAt(6, 3), true);
        this.boardTiles[5][6].setScenery(tileset01.getTileAt(1, 5), true);
        this.boardTiles[6][6].setScenery(tileset01.getTileAt(3, 5), true);
        this.boardTiles[7][6].setScenery(tileset01.getTileAt(5, 5), true);
        this.boardTiles[8][6].setScenery(tileset01.getTileAt(6, 5), true);
    }
    
    public void fileSave()
    {
        // Overwrite existing file with one line
        FileWrite fileWrite = new FileWrite(this.getFile(), false);
        try
        {
            fileWrite.FileWriteLine(this.boardTitle);
        }
        catch (IOException ex)
        {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Append other lines
        fileWrite = new FileWrite(this.getFile(), true);
        try
        {
            fileWrite.FileWriteLine(this.boardSizeX + "|" + this.boardSizeY);
            fileWrite.FileWriteLine("!! Tilesets");
            fileWrite.FileWriteLine(this.boardTileset[0]);
            fileWrite.FileWriteLine(this.boardTileset[1]);
            fileWrite.FileWriteLine(this.boardTileset[2]);
            fileWrite.FileWriteLine("!! Grid");
            for(int y = 0; y < this.boardSizeY; y++)
            {
                for(int x = 0; x < this.boardSizeX; x++)
                {
                    String terrain = this.boardTiles[x][y].getTerrainFile();
                    String scenery = "false";
                    if(this.boardTiles[x][y].getScenery())
                    {
                        scenery = "true|" + this.boardTiles[x][y].getSceneryFile();
                    }
                    fileWrite.FileWriteLine(terrain + "|" + scenery);
                }
            }
            fileWrite.FileWriteLine("!! End of file");
        }
        catch (IOException ex)
        {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getBoardDrawX()
    {
        return this.boardDrawX;
    }
    
    public int getBoardDrawY()
    {
        return this.boardDrawY;
    }
    
    public int getBoardSizeX()
    {
        return this.boardSizeX;
    }
    
    public int getBoardSizeY()
    {
        return this.boardSizeY;
    }
    
    public String getBoardTitle()
    {
        return this.boardTitle;
    }
    
    public int getBoardViewX()
    {
        return this.boardViewX;
    }
    
    public int getBoardViewY()
    {
        return this.boardViewY;
    }
    
    public int getDrawPositionX(int posX)
    {
        return (posX * 32) + this.boardDrawX - (32 * this.boardViewX);
    }
    
    public int getDrawPositionY(int posY)
    {
        return (posY * 32) + this.boardDrawY - (32 * this.boardViewY);
    }
    
    public String getFile()
    {
        return "GAM-ANTICS01/board/" + this.getBoardTitle() + ".froth";
    }
    
    public Player getPlayer()
    {
        return this.entityPlayer;
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
        //g.fillRect(0, 0, 1366, 768);
    }
    
    public void renderPlayer(Graphics g)
    {
        this.entityPlayer.render(g);
    }
    
    public void renderTiles(Graphics g)
    {
        for(int x = 0; x < this.getBoardSizeX(); x++)
        {
            for(int y = 0; y < this.getBoardSizeY(); y++)
            {
                this.boardTiles[x][y].render(g, this.getDrawPositionX(x), this.getDrawPositionY(y));
            }
        }
    }
    
    public void setDrawPosition(int drawX, int drawY)
    {
        this.boardDrawX = drawX;
        this.boardDrawY = drawY;
    }
    
    public void tick()
    {
        this.entityPlayer.tick();
    }
}