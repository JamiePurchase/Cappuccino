package module.SupernovaEditor.module;

import engine.Game;
import graphics.Drawing;
import graphics.Fonts;
import graphics.TilesetManager;
import java.awt.Graphics;
import module.Module;
import module.Supernova.state.StateWar;
import module.SupernovaEditor.graphics.ModuleFonts;
import module.SupernovaEditor.state.StateLandscape;
import state.State;

public class ModuleSupernovaEditor extends Module
{
    // Module Data
    private State moduleState;
    
    // Editor Frame
    private final int editorPosX = 33;
    private final int editorPosY = 33;
    private final int editorWide = 1300;
    private final int editorHigh = 702;
    
    public ModuleSupernovaEditor()
    {        
        // Unique ID
        Game.setModuleID("DEV-SUPERNOV");
        // NOTE: All modules should declare uniqueID first and load tilesets before using them in states (some need changing)
        
        // Load tilesets
        TilesetManager.clear();
        TilesetManager.load("Mongun8-Exterior01", Drawing.getImage("graphics/terrain/Mongun8/exterior01.png", "Supernova"), 128, 64, 1, 1);
        TilesetManager.load("Character01", Drawing.getImage("graphics/units/temp/temp1.png", "Supernova"), 48, 96, 4, 4);
        
        // Initial State
        //this.setState(new StateIntro());
        this.setState(new StateLandscape(this.editorPosX, this.editorPosY, this.editorWide, this.editorHigh));
        
        // Update the cloud
        /*System.out.println("Interacted with the cloud");
        try {Game.getAccountObject().networkUpdate();}
        catch (Exception ex) {Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);}*/
    }
    
    public Fonts getFonts()
    {
        return new module.SupernovaEditor.graphics.ModuleFonts();
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