package graphics;

import engine.Game;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
        
        public static BufferedImage flipImage(BufferedImage image)
        {
            AffineTransform transform1 = AffineTransform.getScaleInstance(-1, 1);
            transform1.translate(-image.getWidth(null), 0);
            AffineTransformOp transform2 = new AffineTransformOp(transform1, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            return transform2.filter(image, null);
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
        
        public static BufferedImage resize(BufferedImage imgOld, int newW, int newH)
        { 
            Image imgTemp = imgOld.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
            BufferedImage imgNew = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = imgNew.createGraphics();
            g2d.drawImage(imgTemp, 0, 0, null);
            g2d.dispose();
            return imgNew;
        }
}