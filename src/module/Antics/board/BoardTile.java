package module.Antics.board;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BoardTile
{
    private int tilePosX;
    private int tilePosY;
    private BufferedImage tileImage;
    private boolean tileSolid;
    
    public BoardTile(BufferedImage image, int posX, int posY, boolean solid)
    {
        this.tilePosX = posX;
        this.tilePosY = posY;
        this.tileImage = image;
        this.tileSolid = solid;
    }
    
    public void render(Graphics g)
    {
        g.drawImage(this.tileImage, this.tilePosX, this.tilePosY, null);
        // NOTE: Positions should consider the current board scroll view
    }
    
    public void tick()
    {
        
    }
}