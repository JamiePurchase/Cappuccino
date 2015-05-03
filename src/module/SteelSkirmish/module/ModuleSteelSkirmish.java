package module.SteelSkirmish.module;

import engine.Game;
import static engine.Game.getAccountObject;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.Module;
import module.SteelSkirmish.state.StateTitle;
import state.State;

public class ModuleSteelSkirmish extends Module
{
    private State moduleState;
    
    public ModuleSteelSkirmish()
    {
        // Initial State
        this.setState(new StateTitle());
        
        // Unique ID
        Game.setModuleID(2);
        
        // Update the cloud
        System.out.println("Interacted with the cloud");
        try {Game.getAccountObject().networkUpdate();}
        catch (Exception ex) {Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);}
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