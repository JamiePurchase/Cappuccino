package module.Dashboard.state;

import application.Functions;
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
import module.AnticsEditor.ui.AppTile;
import module.Module;
import module.ModuleStub;
import state.State;

public class StateDashboard extends State
{
    // Modules
    private ModuleStub[] moduleStub;
    private AppTile[] moduleTile;
    
    public StateDashboard()
    {
        this.moduleStub = Game.getModuleRegistry().getModules();
        this.initTiles();
    }
    
    private void appLaunch(int app)
    {
        Game.setModule(this.moduleStub[app].getModuleID());
    }
    
    public void initTiles()
    {
        Game.getInputMouse().nexusClear();
        for(int x = 0; x < this.moduleStub.length; x++)
        {
            Functions.arrayAppend(this.moduleTile, this.moduleStub[x].getAppTile());
            Game.getInputMouse().nexusAdd(this.moduleTile[x].getMouseNexus());
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
        for(int x = 0; x < this.moduleStub.length; x++)
        {
            this.moduleTile[x].render(g);
        }
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