package module.Ignition.module;

import engine.Game;
import graphics.Fonts;
import graphics.SystemFonts;
import java.awt.Graphics;
import module.Ignition.state.StateBattlefield;
import module.Module;
import state.State;
import module.Ignition.state.StateTitle;

public class ModuleIgnition extends Module
{
    private State moduleState;
    
    public ModuleIgnition()
    {
        // Initial State
        this.setState(new StateTitle());
        
        // Unique ID
        Game.setModuleID("GAM-IGNITION");
        
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
        this.moduleState = newState;
    }
    
    public void tick()
    {
        this.getState().tick();
    }
}