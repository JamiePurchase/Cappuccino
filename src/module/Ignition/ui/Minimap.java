package module.Ignition.ui;

import engine.Game;
import java.awt.Color;
import java.awt.Graphics;
import module.Ignition.battlefield.Battlefield;

public class Minimap
{
    private Battlefield battlefield;
    
    public Minimap()
    {
        
    }
    
    public void render(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(Game.width - 250, 125, 150, 150);
    }
    
}