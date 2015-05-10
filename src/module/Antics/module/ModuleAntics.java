package module.Antics.module;

import engine.Game;
import static engine.Game.getAccountObject;
import graphics.Fonts;
import graphics.SystemFonts;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.Antics.state.StateBoard;
import module.Module;
import state.State;

public class ModuleAntics extends Module
{
    private State moduleState;
    
    public ModuleAntics()
    {
        // Initial State
        this.setState(new StateBoard());
        
        // Unique ID
        Game.setModuleID("GAM-ANTICS01");
        
        // Update the cloud
        /*System.out.println("Interacted with the cloud");
        try {Game.getAccountObject().networkUpdate();}
        catch (Exception ex) {Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);}*/
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