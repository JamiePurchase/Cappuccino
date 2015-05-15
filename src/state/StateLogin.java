package state;

import module.Dashboard.state.StateDashboard;
import engine.Game;
import graphics.Drawing;
import java.awt.Color;
import java.awt.Graphics;

public class StateLogin extends State
{
    private String[] account;
    
    public StateLogin()
    {
        // Build array of accounts in memory from local file
        buildNexus();
    }
    
    private void buildNexus()
    {
        Game.getInputMouse().nexusClear();
        Game.getInputMouse().nexusAdd("loginAccount1", 350, 300, 250, 250);
    }
    
    public void render(Graphics g)
    {
        renderBackground(g);
        renderAccounts(g);
    }
    
    public void renderAccounts(Graphics g)
    {
        g.drawImage(Drawing.getImage("avatars/avatar1.png"), 350, 300, null);
    }
    
    public void renderBackground(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1366, 768);
        g.drawImage(Drawing.getImage("system/logoCappucino.png"), 478, 50, null);
    }
    
    public void tick()
    {
        tickMouse();
    }
    
    public void tickMouse()
    {
        if(Game.getInputMouse().mouseActionPressedL==true)
        {
            String ref = Game.getInputMouse().nexusCheckRef();
            if(ref.equals("loginAccount1"))
            {
                Game.getModule().setState(new StateDashboard());
                Game.getInputMouse().mouseActionDone();
            }
            //if(ref
        }
    }
}