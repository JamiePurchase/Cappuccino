package module.Earthland.state;

import engine.Game;
import graphics.Drawing;
import java.awt.Color;
import java.awt.Graphics;
import state.State;

public class StateWar extends State
{
    public StateWar()
    {
        
    }

    public void render(Graphics g)
    {
        // Background
        g.drawImage(Drawing.getImage("graphics/interface/map01.png", "Earthland"), 0, 0, null);
    }

    public void tick()
    {
    }
}