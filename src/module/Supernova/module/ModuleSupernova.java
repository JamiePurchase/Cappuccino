package module.Supernova.module;

import engine.Game;
import graphics.Fonts;
import java.awt.Font;
import java.awt.Graphics;
import module.Module;
import module.Supernova.state.StateWar;
import state.State;

public class ModuleSupernova extends Module
{
    private State moduleState;

    public ModuleSupernova()
    {
        // Initial State
        this.setState(new StateWar());
        
        // Unique ID
        Game.setModuleID("GAM-SUPERNOV");
        
        // Update the cloud
        /*System.out.println("Interacted with the cloud");
        try {Game.getAccountObject().networkUpdate();}
        catch (Exception ex) {Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);}*/
    }
    
    public Fonts getFonts()
    {
        return new Fonts();
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