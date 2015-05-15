package module.Dashboard.module;

import engine.Game;
import graphics.Fonts;
import static engine.Game.getAccountObject;
import graphics.SystemFonts;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.Module;
import state.State;
import module.Dashboard.state.StateDashboard;
import state.StateLogin;

public class ModuleDashboard extends Module
{
    private State moduleState;
    
    public ModuleDashboard()
    {
        //this.moduleState = new StateDashboard();
        this.setState(new StateLogin());
        
        // Unique ID
        Game.setModuleID("SYS-HOMEDASH");
        
        // Update the cloud
        System.out.println("Interacted with the cloud");
        try {Game.getAccountObject().networkUpdate();}
        catch (Exception ex) {Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    public Fonts getFonts()
    {
        return new SystemFonts();
    }
    
    public State getState()
    {
        return moduleState;
    }
    
    public void render(Graphics g)
    {
        this.getState().render(g);
    }
    
    public void setState(State newState)
    {
        moduleState = newState;
    }
    
    public void tick()
    {
        this.getState().tick();
    }
}