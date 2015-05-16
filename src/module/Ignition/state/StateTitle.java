package module.Ignition.state;

import engine.Game;
import graphics.Drawing;
import java.awt.Color;
import java.awt.Graphics;
import module.Dashboard.module.ModuleDashboard;
import module.Ignition.state.StateBattlefield;
import state.State;

public class StateTitle extends State
{
    public StateTitle()
    {
        System.out.println("Module:Ingition, State:Title");
    }

    public void render(Graphics g)
    {
        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.width, Game.height);
        
        // Logo
        //g.drawImage(Drawing.getImage("interface/logo.png", "SteelSkirmish"), 396, 50, null);
        
        // Options
        g.setFont(Game.getFont("Standard"));
        g.setColor(Color.WHITE);
        g.drawString("Ignition - Title Screen", 25, 25);
        g.drawString("Press the spacebar to continue", 500, 500);
    }

    public void tick()
    {
        tickKey();
        tickMouse();
    }

    public void tickKey()
    {
        if(Game.getInputKeyboard().getKeyPressed() == "Space")
        {
            Game.getInputKeyboard().keyPressedDone();
            Game.getModule().setState(new StateCampaign());
        }
        if(Game.getInputKeyboard().getKeyPressed() == "Escape")
        {
            Game.getInputKeyboard().keyPressedDone();
            Game.setModule(new ModuleDashboard());
        }
    }
    
    public void tickMouse()
    {
        
    }
}