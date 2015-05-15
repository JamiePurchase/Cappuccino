package graphics;

import java.awt.image.BufferedImage;

public class Tileset
{
    private BufferedImage tileSheet;
    private int tileWide;
    private int tileHigh;
    private int tileCols;
    private int tileRows;
    private int tileCount;
    
    public Tileset(BufferedImage sheetFile, int imgWide, int imgHigh, int imgCols, int imgRows)
    {
        this.tileSheet = sheetFile;
        this.tileCols = imgCols;
        this.tileRows = imgRows;
        this.tileWide = imgWide;
        this.tileHigh = imgHigh;
        this.tileCount = imgCols * imgRows;
    }
    
    public Tileset(String tilesetRef)
    {
        String[] tileset = tilesetRef.split("\\|");
        this.tileSheet = Drawing.getImage(tileset[0], tileset[1]);
        this.tileCols = Integer.parseInt(tileset[2]);
        this.tileRows = Integer.parseInt(tileset[3]);
        this.tileWide = Integer.parseInt(tileset[4]);
        this.tileHigh = Integer.parseInt(tileset[5]);
        this.tileCount = this.tileCols * this.tileRows;
    }
    
    public BufferedImage getTileAt(int col, int row)
    {
        if(col <= this.tileCols && row <= this.tileRows)
        {
            int tilePosX = (col - 1) * this.tileWide;
            int tilePosY = (row - 1) * this.tileHigh;
            return this.tileSheet.getSubimage(tilePosX, tilePosY, this.tileWide, this.tileHigh);
        }
        return this.tileSheet.getSubimage(0, 0, this.tileWide, this.tileHigh);
    }
    
    public BufferedImage[] getTileset()
    {
        BufferedImage[] tilesetArray = new BufferedImage[this.tileCount];
        int tilesetCount = 0;
        for(int row = 1; row <= this.tileRows; row++)
        {
            for(int col = 1; col <= this.tileCols; col++)
            {
                tilesetArray[tilesetCount] = this.getTileAt(col, row);
                tilesetCount += 1;
            }
        }
        return tilesetArray;
    }
    
}