package state;

import engine.Game;
import file.FileRead;
import graphics.Drawing;
import graphics.Fonts;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import web.Web;

public class StateIntro extends State
{
    private boolean tickIntro;
    private int tickCount;
    private int tickFrame;
    
    public StateIntro()
    {
        tickIntro = true;
        tickCount = 0;
        tickFrame = 1;
    }
    
    public void render(Graphics g)
    {
        // Background
        renderBackground(g);
        
        // Phase 1: Logo appears in the centre
        if(tickFrame == 1) {renderLogo(g, 478, 310);}
        
        // Phase 2: Logo moves upwards
        if(tickFrame == 2) {renderLogo(g, 478, (310 - (tickCount * 2)));}
        
        // Phase 3: Logo rests at the top
        if(tickFrame == 3) {renderLogo(g, 478, 50);}
    }
    
    public void renderBackground(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1366, 768);
    }
    
    public void renderLogo(Graphics g, int posX, int posY)
    {
        g.drawImage(Drawing.getImage("system/logoCappucino.png"), posX, posY, null);
        //g.drawImage(Drawing.getImage("system/logoJava.png"), 627, 400, null);
    }
    
    public void tick()
    {
        if(tickIntro == true) {tickIntro();}
    }
    
    public void tickIntro()
    {
        // Animation
        tickCount += 1;
        if(tickFrame == 1 && tickCount >= 50)
        {
            tickFrame += 1;
            tickCount = 0;
        }
        if(tickFrame == 2 && tickCount >= 140)
        {
            tickFrame += 1;
            tickCount = 0;
        }
        if(tickFrame == 3 && tickCount >= 30)
        {
            tickIntro = false;
            tickLogin();
        }
    }
    
    public void tickLogin()
    {
        //Game.setState(new StateTitle());
        FileRead fileRead = new FileRead("login.froth");
        try
        {
            String[] fileData = fileRead.FileReadData();
            System.out.println(fileData[0]);
            if(fileData[0] == "1")
            {
                tickLoginCheck(fileData[1], fileData[2]);
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(StateIntro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tickLoginCheck(String username, String password)
    {
        try
        {
            String myData = Web.request("account/login.php?username=" + username + "&password=" + password);
            if(myData == "0")
            {
                System.out.println("Login failed");
            }
            else
            {
                Game.setAccount(Integer.parseInt(myData));
                Game.getModule().setState(new StateTitle());
            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(StateTitle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}