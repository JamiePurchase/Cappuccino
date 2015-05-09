package module.Minstrel.module;

import engine.Game;
import graphics.Fonts;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.Module;
import module.Minstrel.state.StateMain;
import module.SteelSkirmish.graphics.ModuleFonts;
import state.State;

public class ModuleMinstrel extends Module
{
    private State moduleState;
    
    public ModuleMinstrel()
    {
        // Initial State
        this.setState(new StateMain());
        
        // Unique ID (this should be changed to the newer, larger unique ID that is saved in a froth file
        Game.setModuleID(2);
        
        // Update the cloud
        System.out.println("Interacted with the cloud");
        try {Game.getAccountObject().networkUpdate();}
        catch (Exception ex) {Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    public Fonts getFont()
    {
        return new ModuleFonts();
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