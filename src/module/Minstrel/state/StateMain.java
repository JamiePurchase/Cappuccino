package module.Minstrel.state;

import engine.Game;
import graphics.Drawing;
import graphics.Fonts;
import java.awt.Color;
import java.awt.Graphics;
import module.ModuleDashboard;
import state.State;
import state.StateDashboard;

public class StateMain extends State
{

    public StateMain()
    {
        // Audio
        //Game.audio.playMusic("music1");
    }

    public void render(Graphics g)
    {
        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1366, 768);
        
        // Logo
        //g.drawImage(Drawing.getImage("interface/logo.png", "SteelSkirmish"), 396, 50, null);
        
        // Title
        g.setFont(Game.getFont("MinstrelTitle"));
        g.setColor(Color.WHITE);
        g.drawString("Minstrel", 500, 50);
        
        // Options
        g.setFont(Game.getFont("Standard"));
        g.setColor(Color.WHITE);
        g.drawString("Press the spacebar to continue", 500, 500);
    }

    public void tick()
    {
        tickKey();
        tickMouse();
    }

    public void tickKey()
    {
        if(Game.getInputKeyboard().getKeyPressed() == "Escape")
        {
            Game.getInputKeyboard().keyPressedDone();
            Game.setModule(new ModuleDashboard());
        }
    }
    
    public void tickMouse()
    {
        if(Game.getInputMouse().mouseActionPressedL==true)
        {
            Game.getInputMouse().mouseActionDone();
            Game.setModule(new ModuleDashboard());
        }
    }
}