package module.Supernova.entity;

import engine.Game;
import graphics.Drawing;
import graphics.Tileset;
import graphics.TilesetManager;
import java.awt.Graphics;
import module.Supernova.game.War;

public class EntityBuilding
{
    // Entity
    private War entityWar;
    private String entityTitle;
    private int entityForce;
    private int entityBuilding;
    private EntityAction entityAction;
    
    // Drawing
    private String drawFile;
    private int drawPosX;
    private int drawPosY;
    private int drawWide;
    private int drawHigh;
    private String drawFace;
    private int drawAnimTick;
    private int drawAnimTickMax;
    private int drawAnimFrame;
    private int drawAnimFrameMax;
    private Tileset drawAnimTileset;
    
    // Stats
    private int statBuild;
    private int statHealthNow;
    private int statHealthMax;
    private int statSight;
    
    // Commands
    private Command[][] commands;
    
    // Audio
    private String audioFile;
    
    // Selected
    private boolean selectActive;
    
    // Mouse
    private String mouseNexusRef;
    
    public EntityBuilding(War war, int force, int building)
    {
        // NOTE: need to pass in a template, which will determine graphics, stats and commands
        
        // Entity
        this.entityWar = war;
        this.entityTitle = "Tower";
        this.entityForce = force;
        this.entityBuilding = building;
        this.entityAction = new EntityActionIdle();
        
        // Drawing
        this.drawFile = "graphics/buildings/tower01.png";
        this.drawPosX = 300;
        this.drawPosY = 500;
        this.drawWide = 128;
        this.drawHigh = 256;
        this.drawFace = "SE";
        this.drawAnimTick = 0;
        this.drawAnimTickMax = 20;
        this.drawAnimFrame = 1;
        this.drawAnimFrameMax = 4;
        this.drawAnimTileset = TilesetManager.getTileset("Character01");
        
        // Stats
        this.statBuild = 100;
        this.statHealthNow = 1000;
        this.statHealthMax = 1000;
        this.statSight = 500;
        
        // Commands
        this.commands = new Command[6][3];
        this.commands[0][0] = new CommandTrain("temp01");
        
        // Temp
        this.selectActive = false;
    }
    
    private int getAnimPosX()
    {
        return this.getDrawPosX() - this.entityWar.getLandscape().getBoardViewX();
    }
    
    private int getAnimPosY()
    {
        return this.getDrawPosY() - this.entityWar.getLandscape().getBoardViewX();
    }
    
    public Command[][] getCommands()
    {
        return this.commands;
    }
    
    public int getDrawHigh()
    {
        return this.drawHigh;
    }
    
    public int getDrawPosX()
    {
        return this.drawPosX;
    }
    
    public int getDrawPosY()
    {
        return this.drawPosY;
    }
    
    public int getDrawWide()
    {
        return this.drawWide;
    }
    
    public String getTitle()
    {
        return this.entityTitle;
    }
    
    public void mouseNexus(String ref)
    {
        Game.getInputMouse().nexusAdd(ref, this.getAnimPosX(), this.getAnimPosY(), this.getDrawWide(), this.getDrawHigh());
        this.mouseNexusRef = ref;
    }
    
    public void render(Graphics g, int zoom)
    {
        g.drawImage(Drawing.getImage(this.drawFile, "Supernova"), this.getAnimPosX(), this.getAnimPosY(), null);
    }
    
    public void setSelected(boolean value)
    {
        this.selectActive = value;
    }
}
