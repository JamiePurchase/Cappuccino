package graphics;

import engine.Game;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Drawing
{
	public static void drawImageOpaque(Graphics g, BufferedImage image, int posX, int posY, float alpha)
	{
		// Set Opacity
		Graphics2D g2D = (Graphics2D) g;
		AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		g2D.setComposite(composite);
		
		// Draw Image
		g2D.drawImage(image, posX, posY, null);
		
		// Clear Opacity
		composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
		g2D.setComposite(composite);
	}
        
        public static void fadeScreen(Graphics g)
        {
            Drawing.drawImageOpaque(g, getImage("system/fadeBlack.png"), 0, 0, 0.75f);
        }
	
	public static Color getColorRGB(int r, int g, int b)
	{
		float hsb[] = Color.RGBtoHSB(r,g,b,null);
		return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
	}
	
	public static BufferedImage getImage(String filepath)
	{
            return getImageFile(Game.getResourcePath() + "src/resources/" + filepath);
	}
        
        public static BufferedImage getImage(String filepath, String module)
        {
            return getImageFile(Game.getResourcePath() + "src/module/" + module + "/resources/" + filepath);
        }
        
        public static BufferedImage getImageFile(String filepath)
        {
            BufferedImage image = null;
            try
            {
                    image = ImageIO.read(new File(filepath));
            }
            catch (IOException e)
            {
                    System.out.println(e);
            }
            return image;
        }
}