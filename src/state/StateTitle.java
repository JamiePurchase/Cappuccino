package state;

import engine.Game;
import graphics.Drawing;
import graphics.Fonts;
import input.InputKeyboard;
import web.Web;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StateTitle extends State
{

    public StateTitle()
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
        g.drawImage(Drawing.getImage("system/logoCappucino.png"), 478, 50, null);
        
        // Options
        g.setFont(Game.getFont("Standard"));
        g.setColor(Color.WHITE);
        g.drawString("This is the title screen", 500, 300);
    }

    public void tick()
    {
        tickKey();
    }

    public void tickKey()
    {
        //if(Game.getInputKeyboard().getKeyPressed()=="")
        //Game.setStateChange(new StateGame());

        if(Game.getInputKeyboard().getKeyPressed() == "Escape")
        {
            Game.getInputKeyboard().keyPressedDone();
            System.exit(0);
        }
    }
}