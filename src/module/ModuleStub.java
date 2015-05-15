package module;

import engine.Game;
import graphics.Drawing;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.AnticsEditor.ui.AppTile;

public class ModuleStub
{
    private String moduleID;
    private String moduleTitle;
    private String moduleFolder;
    private String moduleType;
    private int moduleVersion;
    
    public ModuleStub(String id, String title, String folder, String type, int version)
    {
        this.moduleID = id;
        this.moduleTitle = title;
        this.moduleFolder = folder;
        this.moduleType = type;
        this.moduleVersion = version;
    }
    
    public ModuleStub(String[] froth)
    {
        this.moduleID = froth[0];
        this.moduleTitle = froth[1];
        this.moduleFolder = froth[2];
        this.moduleType = froth[3];
        this.moduleVersion = Integer.parseInt(froth[4]);
    }
    
    public AppTile getAppTile()
    {
        return new AppTile(this.moduleTitle, this.getAppTileLogo());
    }
        
    public BufferedImage getAppTileLogo()
    {
        return Drawing.getImage("app/tileLogo.png", this.moduleFolder);
    }
    
    public String getModuleID()
    {
        return this.moduleID;
    }
    
    /*public Module getModuleObject()
    {
        String className = "Module" + this.moduleFolder;
        Object myObject = "";
        try
        {
            try {
                return (Module) Class.forName(className).newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(ModuleStub.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ModuleStub.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ModuleStub.class.getName()).log(Level.SEVERE, null, ex);
            myObject = ex;
        }
        
        // Return the current dashboard module if we failed
        return Game.getModule();
    }*/
}