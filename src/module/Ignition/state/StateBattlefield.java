package module.Ignition.state;

import engine.Game;
import graphics.Drawing;
import graphics.Tileset;
import java.awt.Color;
import java.awt.Graphics;
import module.Ignition.ui.Minimap;
import state.State;

public class StateBattlefield extends State
{
    // Information Display
    private Minimap infoMinimap;
    
    public StateBattlefield()
    {
        System.out.println("Module:Ingition, State:Battlefield");
        infoMinimap = new Minimap();
    }
    
    public void render(Graphics g)
    {
        g.setColor(Drawing.getColorRGB(218, 198, 135));
        g.fillRect(0, 0, Game.width, Game.height);
        
        Tileset temp01 = new Tileset(Drawing.getImage("temp/temp001.png", "Ignition"), 42, 52, 1, 1);
        g.drawImage(temp01.getTileAt(1, 1), 50, 50, null);
        
        infoMinimap.render(g);
        
        // Temp Message
        g.setColor(Color.WHITE);
        g.fillRect(75, 25, Game.width - 150, 50);
        
        // Temp Morale
        g.fillRect(75, 100, Game.width - 150, 35);
        
        // Temp Allied Army
        g.fillRect(0, Game.height / 2, 350, 100);
        
        // Temp Allied Team
        g.fillRect(0, Game.height - 125, 350, 100);
        
        // Temp Enemy Team
        g.fillRect(Game.width - 350, Game.height - 125, 350, 100);
    }
    
    public void tick()
    {
        
    }
}