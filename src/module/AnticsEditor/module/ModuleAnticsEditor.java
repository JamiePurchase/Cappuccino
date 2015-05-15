package module.AnticsEditor.module;

import engine.Game;
import graphics.Fonts;
import java.awt.Graphics;
import module.AnticsEditor.graphics.ModuleFonts;
import module.AnticsEditor.state.StateBoard;
import module.Module;
import state.State;

public class ModuleAnticsEditor extends Module
{
    private State moduleState;
    
    public ModuleAnticsEditor()
    {
        // Initial State
        this.setState(new StateBoard());
        
        // Unique ID
        Game.setModuleID("DEV-ANTICS01");
        
        // Update the cloud
        /*System.out.println("Interacted with the cloud");
        try {Game.getAccountObject().networkUpdate();}
        catch (Exception ex) {Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);}*/
    }
    
    public Fonts getFonts()
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