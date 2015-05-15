package module.Ignition.state;

import engine.Game;
import graphics.Drawing;
import graphics.Tileset;
import java.awt.Graphics;
import state.State;

public class StateBattlefield extends State
{
    public StateBattlefield()
    {
        
    }
    
    public void render(Graphics g)
    {
        g.setColor(Drawing.getColorRGB(218, 198, 135));
        g.fillRect(0, 0, Game.width, Game.height);
        
        Tileset temp01 = new Tileset(Drawing.getImage("temp/temp001.png", "Ignition"), 42, 52, 1, 1);
        g.drawImage(temp01.getTileAt(1, 1), 50, 50, null);
    }
    
    public void tick()
    {
        
    }
}