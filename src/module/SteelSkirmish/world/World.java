package module.SteelSkirmish.world;

import graphics.Drawing;
import java.awt.Graphics;
import module.SteelSkirmish.unit.Unit;

public class World
{
    // Battle Data
    private int battleID;
    private int battleTurn;
    private boolean battlePlayer;
    
    // Unit Data
    private Unit[] unitAllies;
    private Unit[] unitEnemies;
    
    public World()
    {
        
    }
    
    public void render(Graphics g)
    {
        renderBackground(g);
        renderUnits(g);
        renderInterface(g);
    }
    
    public void renderBackground(Graphics g)
    {
        for(int x = 0; x < 12; x++)
        {
            for(int y = 0; y < 8; y++)
            {
                int posX = x * 100;
                int posY = y * 100;
                g.drawImage(Drawing.getImage("terrain/grass1a.png", "SteelSkirmish"), posX, posY, null);
            }
        }
    }
    
    public void renderInterface(Graphics g)
    {
        
    }
    
    public void renderUnits(Graphics g)
    {
        g.drawImage(Drawing.getImage("unit/knight/idle1A1.png", "SteelSkirmish"), 200, 100, null);
    }
    
    public void tick()
    {
        
    }
    
}