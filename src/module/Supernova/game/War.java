package module.Supernova.game;

import engine.Game;
import graphics.Drawing;
import java.awt.Color;
import java.awt.Graphics;
import module.Supernova.entity.Entity;
import module.Supernova.entity.EntitySentientUnit;
import module.Supernova.force.ForceNature;
import module.Supernova.force.ForcePlayer;
import module.Supernova.world.Landscape;

public class War
{
    // Landscape
    private Landscape warLandscape;
    
    // Forces
    private ForcePlayer[] warForces;
    private int warForcesCount;
    private ForceNature warNature;
    
    // Selection
    private boolean warSelectActive;
    private Entity warSelectEntity;
    
    public War()
    {
        this.warLandscape = new Landscape();
        
        // Temp
        this.warForces = new ForcePlayer[4];
        this.warForces[0] = new ForcePlayer("Jamie", "Terralith");
        this.warForces[1] = new ForcePlayer("P2", "???");
        this.warForces[2] = new ForcePlayer("P3", "???");
        this.warForces[3] = new ForcePlayer("P4", "???");
        this.warForcesCount = 4;
        this.warNature = new ForceNature();
    }
    
    public boolean getSelectActive()
    {
        return this.warSelectActive;
    }
    
    public Entity getSelectEntity()
    {
        return this.warSelectEntity;
    }
    
    public void render(Graphics g)
    {
        Game.getInputMouse().nexusClear();
        renderLand(g);
        renderNature(g);
        renderForce(g);
        renderInterface(g);
    }
    
    public void renderForce(Graphics g)
    {
        for(int force = 0; force < this.warForcesCount; force++)
        {
            for(int building = 0; building < this.warForces[force].getEntityBuildingsCount(); building++)
            {
                this.warForces[force].getEntityUnits()[building].render(g);
            }
            for(int unit = 0; unit < warForces[force].getEntityUnitsCount(); unit++)
            {
                this.warForces[force].getEntityUnits()[unit].render(g);
                this.warForces[force].getEntityUnits()[unit].mouseNexus("F" + force + "|U" + unit);
            }
        }
    }
    
    public void renderInterface(Graphics g)
    {
        // Temp Border
        g.setColor(Drawing.getColorRGB(69, 85, 69));
        g.fillRect(0, 0, Game.width, 50);
        g.fillRect(0, 0, 10, Game.height);
        g.fillRect(Game.width - 10, 0, 10, Game.height);
        g.fillRect(0, Game.height - 75, Game.width, 75);
        g.setColor(Drawing.getColorRGB(49, 65, 49));
        g.drawRect(10, 50, Game.width - 20, Game.height - 125);
        g.drawRect(11, 51, Game.width - 22, Game.height - 127);
        
        // Temp Selection Info
        if(this.warSelectActive)
        {
            String tempSelect = "Unit Selected: " + this.warSelectEntity.getEntityTitle();
            g.setFont(Game.getFont("FrameTitle"));
            g.setColor(Color.WHITE);
            g.drawString(tempSelect, 50, Game.height - 50);
        }
    }
    
    public void renderLand(Graphics g)
    {
        this.warLandscape.render(g);
    }
    
    public void renderNature(Graphics g)
    {
        for(int scenery = 0; scenery < warNature.getEntitySceneryCount(); scenery++)
        {
            warNature.getEntityScenery()[scenery].render(g);
        }
        for(int creature = 0; creature < warNature.getEntityCreaturesCount(); creature++)
        {
            warNature.getEntityScenery()[creature].render(g);
        }
    }
    
    public void selectClear()
    {
        this.warSelectActive = false;
        // need to invalidate this.warSelectEntity
    }
    
    public void selectEntity(Entity entity)
    {
        // NOTE: May be worth having an array of Entities for multiple selections
        this.warSelectActive = true;
        this.warSelectEntity = entity;
    }
    
    public void tick()
    {
        tickInput();
        tickForce();
    }
    
    public void tickInput()
    {
        if(Game.getInputMouse().mouseActionPressedL == true)
        {            
            // NOTE: Change this section slightly, so we have a boolean to say if we hit a nexus
            String ref = Game.getInputMouse().nexusCheckRef();
            // NOTE: Check if the mouse clicked within the world (as opposed to interface/menu/border)
            if(ref.length() > 0)
            {
                // Rather than listing them here, can't we have intelligent onClick events?
                if(ref.equals("F0|U0"))
                {
                    Game.getInputMouse().mouseActionDone();

                    // Temp
                    EntitySentientUnit unitClick = this.warForces[0].getEntityUnits()[0];
                    unitClick.setSelected(true);
                    // NOTE: Perhaps state would be better than here to say which unit(s) is/are selected?
                    this.selectEntity(unitClick);
                }
            }
            else
            {
                Game.getInputMouse().mouseActionDone();
                this.selectClear();
            }
        }
        if(Game.getInputMouse().mouseActionPressedR == true)
        {
            if(this.getSelectActive())
            {
                // mark the location of the click as the target, if the unit is able to move
            }
        }
    }
    
    public void tickForce()
    {
        // resources, creatures, weather, events, armies, buildings, technologies, units, effects, actions
        this.warForces[0].getEntityUnits()[0].tick();
    }
}