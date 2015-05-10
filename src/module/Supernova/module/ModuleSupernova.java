package module.Supernova.module;

import engine.Game;
import graphics.Drawing;
import graphics.Fonts;
import graphics.SystemFonts;
import graphics.TilesetManager;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import module.Module;
import module.Supernova.state.StateTitle;
import module.Supernova.state.StateWar;
import state.State;

public class ModuleSupernova extends Module
{
    private State moduleState;

    public ModuleSupernova()
    {
        // Unique ID
        Game.setModuleID("GAM-SUPERNOV");
        // NOTE: All modules should declare uniqueID first and load tilesets before using them in states (some need changing)
        
        // Load tilesets
        TilesetManager.clear();
        TilesetManager.load("Mongun8-Exterior01", Drawing.getImage("graphics/terrain/Mongun8/exterior01.png", "Supernova"), 128, 64, 2, 1);
        TilesetManager.load("Character01", Drawing.getImage("graphics/units/temp/temp1.png", "Supernova"), 48, 96, 4, 4);
        
        // Initial State
        this.setState(new StateTitle());
        //this.setState(new StateWar());
        
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