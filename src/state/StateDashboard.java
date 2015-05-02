package state;

import engine.Game;
import graphics.Drawing;
import graphics.Fonts;
import module.SteelSkirmish.module.ModuleSteelSkirmish;
import input.InputKeyboard;
import java.awt.Color;
import java.awt.Graphics;

public class StateDashboard extends State
{
    
    public StateDashboard()
    {
        
    }
    
    public void render(Graphics g)
    {
        renderBackground(g);
        renderContentPane(g);
        renderAccountInfo(g);
    }
    
    public void renderAccountInfo(Graphics g)
    {
        g.setColor(Drawing.getColorRGB(170, 100, 150));
        g.fillRect(100, 75, 250, 100);
        g.setColor(Color.BLACK);
        g.drawRect(100, 75, 250, 100);
        g.setFont(Fonts.getFont("standard"));
        g.setColor(Color.BLACK);
        g.drawString(Game.getAccountObject().getUsername(), 125, 110);
        // Mail (shows amount unread?)
        // Friends (shows amount online?)
    }
    
    public void renderBackground(Graphics g)
    {
        g.drawImage(Drawing.getImage("system/bkg1.png"), 0, 0, null);
    }
    
    public void renderContentPane(Graphics g)
    {
        g.drawImage(Drawing.getImage("system/tileBkg.png"), 200, 400, null);
        g.drawImage(Drawing.getImage("interface/iconDashboard.png", "SteelSkirmish"), 200, 400, null);
    }
    
    public void tick()
    {
        if(Game.getInputKeyboard().getKeyPressed() == "Space")
        {
            Game.getInputKeyboard().keyPressedDone();
            Game.setModule(new ModuleSteelSkirmish());
        }
    }
}