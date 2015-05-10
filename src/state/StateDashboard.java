package state;

import engine.Game;
import file.FileRead;
import file.FileWrite;
import graphics.Drawing;
import graphics.Fonts;
import module.SteelSkirmish.module.ModuleSteelSkirmish;
import input.InputKeyboard;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.Antics.module.ModuleAntics;
import module.Module;

public class StateDashboard extends State
{
    private int[] moduleID;
    private String[] moduleTitle;
    private Module[] moduleObject;
    
    public StateDashboard()
    {
        appList();
    }
    
    private void appLaunch(int app)
    {
        Game.setModule(moduleObject[app]);
    }
    
    private void appList()
    {
        // Get list of apps from local data
        String[] fileData = new String[50];
        FileRead fr = new FileRead("modules.froth");
        try
        {
            fileData = fr.FileReadData();
        }
        catch (IOException ex) {Logger.getLogger(StateDashboard.class.getName()).log(Level.SEVERE, null, ex);}
        
        // return appCount;
        int appCount = fileData.length;
        
        // Set size of arrays
        moduleID = new int[appCount];
        moduleTitle = new String[appCount];
        moduleObject = new Module[appCount];
        
        // Store data about the apps
        for(int x = 0; x < appCount; x++)
        {
            String[] fileInfo = fileData[x].split("\\|");
            moduleID[x] = Integer.parseInt(fileInfo[0]);
            moduleTitle[x] = fileInfo[1];
            //moduleVersion[x] = Integer.parseInt(fileInfo[2]);
            
            // Gave up trying to cast a string class name to an object
            if(fileInfo[3] == "SteelSkirmish") {moduleObject[x] = new ModuleSteelSkirmish();}
            if(fileInfo[3] == "Antics") {moduleObject[x] = new ModuleAntics();}
            
            new ModuleSteelSkirmish();
        }
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
        g.setFont(Game.getFont("Standard"));
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
            appLaunch(0);
        }
    }
}