package module.Ignition.state;

import engine.Game;
import graphics.Drawing;
import java.awt.Color;
import java.awt.Graphics;
import module.Dashboard.module.ModuleDashboard;
import state.State;

public class StateCampaign extends State
{
    
    public StateCampaign()
    {
        System.out.println("Module:Ingition, State:Campaign");
    }
    
    public void render(Graphics g)
    {
        Drawing.fillScreen(g);
        g.setFont(Game.getFont("Standard"));
        g.setColor(Color.WHITE);
        g.drawString("Ignition - Campaign Menu", 25, 25);
        g.drawString("Press space to jump straight in!", 300, 400);
    }
    
    public void tick()
    {
        if(Game.getInputKeyboard().getKeyPressed() == "Space")
        {
            Game.getInputKeyboard().keyPressedDone();
            Game.getModule().setState(new StateBattlefield());
        }
        if(Game.getInputKeyboard().getKeyPressed() == "Escape")
        {
            Game.getInputKeyboard().keyPressedDone();
            Game.getModule().setState(new StateTitle());
        }
    }
    
}