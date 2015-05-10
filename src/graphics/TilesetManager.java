package graphics;

import graphics.Drawing;
import graphics.Tileset;
import java.awt.image.BufferedImage;

public class TilesetManager
{
    private static String[] tilesetReference;
    private static Tileset[] tilesetObject;
    private static int tilesetCount;
    
    public TilesetManager()
    {
        
    }
    
    public static void clear()
    {
        tilesetReference = new String[50];
        tilesetObject = new Tileset[50];
        tilesetCount = 0;
    }
    
    private static BufferedImage getTerrainSheet(String folder, String file)
    {
        // NOTE: Since we don't use any tileset objects in the main system, this needs to be considered
        return Drawing.getImage("something/" + folder + "/" + file);
    }
    
    private static BufferedImage getTerrainSheet(String folder, String file, String module)
    {
        return Drawing.getImage("graphics/terrain/" + folder + "/" + file, module);
    }
    
    public static Tileset getTileset(String reference)
    {
        for(int set = 0; set < tilesetCount; set++)
        {
            if(tilesetReference[set].equals(reference))
            {
                return tilesetObject[set];
            }
        }
        return new Tileset(Drawing.getImage("graphics/terrain/Mongun8/exterior01.png", "Supernova"), 128, 64, 1, 1);
    }
    
    public static void load(String ref, BufferedImage sheetFile, int imgWide, int imgHigh, int imgCols, int imgRows)
    {
        tilesetReference[tilesetCount] = ref;
        tilesetObject[tilesetCount] = new Tileset(sheetFile, imgWide, imgHigh, imgCols, imgRows);
        tilesetCount += 1;
    }

}