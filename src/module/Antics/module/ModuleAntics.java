package module.Antics.module;

import engine.Game;
import static engine.Game.getAccountObject;
import graphics.Fonts;
import graphics.SystemFonts;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.Antics.state.StateBattle;
import module.Antics.state.StateBoard;
import module.Antics.state.StateTitle;
import module.Module;
import state.State;

public class ModuleAntics extends Module
{
    private State moduleState;
    private State moduleStateMemory;
    
    public ModuleAntics()
    {
        // Initial State
        //this.setState(new StateTitle(this));
        //this.setState(new StateBoard());
        this.setState(new StateBattle());
        
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
    
    public void revertState()
    {
        this.moduleState = this.moduleStateMemory;
    }
    
    public void setState(State newState)
    {
        this.moduleState = newState;
    }
    
    public void switchState(State newState)
    {
        this.moduleStateMemory = this.moduleState;
        this.moduleState = newState;
    }
    
    public void tick()
    {
        this.getState().tick();
    }
}