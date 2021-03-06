package module.Dashboard.ui;

import graphics.Drawing;
import input.InputMouseNexus;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import module.Module;

public class AppTile
{
    private String appTitle;
    private BufferedImage appImage;
    
    public AppTile(String title, BufferedImage image)
    {
        this.appTitle = title;
        this.appImage = image;
    }
    
    public InputMouseNexus getMouseNexus()
    {
        // NOTE: where do the x and y bits come from?
        int x = 100;
        int y = 200;
        return new InputMouseNexus("AppTile-" + this.appTitle, x, y, 100, 100);
    }
    
    public void render(Graphics g)
    {
        g.drawImage(Drawing.getImage("system/tileBkg.png"), 200, 400, null);
        //g.drawImage(Drawing.getImage("interface/iconDashboard.png", "SteelSkirmish"), 200, 400, null);
    }
}