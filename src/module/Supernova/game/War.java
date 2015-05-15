package module.Supernova.game;

import engine.Game;
import graphics.Drawing;
import java.awt.Color;
import java.awt.Graphics;
import module.Supernova.entity.EntityActionIdle;
import module.Supernova.entity.EntityActionMove;
import module.Supernova.entity.EntityBuilding;
import module.Supernova.entity.EntityResource;
import module.Supernova.entity.EntityUnit;
import module.Supernova.force.ForceNature;
import module.Supernova.force.ForcePlayer;
import module.Supernova.world.Landscape;

public class War
{
    // Debug
    private int debugTick;
    
    // Landscape
    private Landscape warLandscape;
    
    // Forces
    private ForcePlayer[] warForces;
    private int warForcesCount;
    private ForceNature warNature;
    
    // Interface
    private int warUiSizeBottom;
    private int warUiSizeLeft;
    private int warUiSizeRight;
    private int warUiSizeTop;
    
    // Selection
    private boolean warSelectActive;
    private String warSelectType;
    private EntityUnit warSelectUnit;
    private EntityBuilding warSelectBuilding;
    private EntityResource warSelectResource;
    
    public War()
    {
        // Debug
        this.debugTick = 0;
        
        // Temp
        this.warLandscape = new Landscape();
        
        // Temp
        this.warUiSizeBottom = 150;
        this.warUiSizeLeft = 10;
        this.warUiSizeRight = 10;
        this.warUiSizeTop = 50;
        
        // Temp
        this.warForces = new ForcePlayer[4];
        this.warForces[0] = new ForcePlayer(this, 0, "Jamie", "Terralith");
        this.warForces[1] = new ForcePlayer(this, 1, "P2", "???");
        this.warForces[2] = new ForcePlayer(this, 2, "P3", "???");
        this.warForces[3] = new ForcePlayer(this, 3, "P4", "???");
        this.warForcesCount = 4;
        this.warNature = new ForceNature(this);
        
        // Selection
        this.warSelectActive = false;
        this.warSelectType = "NONE";
    }
    
    public Landscape getLandscape()
    {
        return this.warLandscape;
    }
    
    public boolean getSelectActive()
    {
        return this.warSelectActive;
    }
    
    public EntityBuilding getSelectBuilding()
    {
        return this.warSelectBuilding;
    }
    
    public EntityResource getSelectResource()
    {
        return this.warSelectResource;
    }
    
    public EntityUnit getSelectUnit()
    {
        return this.warSelectUnit;
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
                this.warForces[force].getEntityBuildings()[building].render(g, this.warLandscape.getBoardZoom());
                this.warForces[force].getEntityBuildings()[building].mouseNexus("F" + force + "|B" + building);
            }
            for(int unit = 0; unit < warForces[force].getEntityUnitsCount(); unit++)
            {
                this.warForces[force].getEntityUnits()[unit].render(g, this.warLandscape.getBoardZoom());
                this.warForces[force].getEntityUnits()[unit].mouseNexus("F" + force + "|U" + unit);
            }
        }
    }
    
    public void renderInterface(Graphics g)
    {
        renderInterfaceBorder(g);
        renderInterfaceInfobar(g);
        renderInterfaceSelection(g);
        renderInterfaceMinimap(g);
    }
    
    public void renderInterfaceBorder(Graphics g)
    {
        // Border Fill
        g.setColor(Drawing.getColorRGB(69, 85, 69));
        g.fillRect(0, 0, Game.width, this.warUiSizeTop);
        g.fillRect(0, 0, this.warUiSizeLeft, Game.height);
        g.fillRect(Game.width - this.warUiSizeRight, 0, this.warUiSizeRight, Game.height);
        g.fillRect(0, Game.height - this.warUiSizeBottom, Game.width, this.warUiSizeBottom);
        
        // Border Inside
        g.setColor(Drawing.getColorRGB(49, 65, 49));
        g.drawRect(this.warUiSizeLeft, this.warUiSizeTop, Game.width - (this.warUiSizeLeft + this.warUiSizeRight), Game.height - (this.warUiSizeTop + this.warUiSizeBottom));
        g.drawRect(this.warUiSizeLeft + 1, this.warUiSizeTop + 1, Game.width - (this.warUiSizeLeft + this.warUiSizeRight) - 2, Game.height - (this.warUiSizeTop + this.warUiSizeBottom) - 2);
    }
    
    public void renderInterfaceInfobar(Graphics g)
    {
        // Temp Resource Info
        g.setFont(Game.getFont("FrameTitle"));
        g.setColor(Color.WHITE);
        g.drawString("?????", 50, 30);
        g.drawString("?????", 250, 30);
        g.drawString("Obsidian", 450, 30);
        g.drawString("?????", 650, 30);
    }
    
    public void renderInterfaceMinimap(Graphics g)
    {
        // Border Join Background
        g.setColor(Drawing.getColorRGB(69, 85, 69));
        g.fillRect(Game.width - (this.warUiSizeRight + 75), Game.height - 280, 80, 280);
        
        // Border Join Outline
        g.setColor(Drawing.getColorRGB(49, 65, 49));
        g.fillRect(Game.width - (this.warUiSizeRight + 75), Game.height - 280, 75, 2);
        
        // Minimap Background
        g.setColor(Color.WHITE);
        g.fillOval(Game.width - 320, Game.height - 310, 300, 300);
        
        // Minimap Border
        g.setColor(Drawing.getColorRGB(49, 65, 49));
        g.drawOval(Game.width - 320, Game.height - 310, 300, 300);
        g.drawOval(Game.width - 319, Game.height - 310, 300, 300);
        g.drawOval(Game.width - 320, Game.height - 309, 300, 300);
        g.drawOval(Game.width - 319, Game.height - 309, 300, 300);
    }
    
    public void renderInterfaceSelection(Graphics g)
    {
        // Temp Selection Pane
        g.setColor(Drawing.getColorRGB(49, 65, 49));
        g.drawRect(325, Game.height - 140, 400, 120);
        
        // Temp Selection Info
        if(this.warSelectActive)
        {
            if(this.warSelectType == "UNIT")
            {
                String tempSelect = "Unit Selected: " + this.warSelectUnit.getTitle();
                g.setFont(Game.getFont("FrameTitle"));
                g.setColor(Color.WHITE);
                g.drawString(tempSelect, 350, Game.height - 100);
            }
            if(this.warSelectType == "BUILDING")
            {
                String tempSelect = "Building Selected: " + this.warSelectBuilding.getTitle();
                g.setFont(Game.getFont("FrameTitle"));
                g.setColor(Color.WHITE);
                g.drawString(tempSelect, 350, Game.height - 100);
                
                // Temp
                this.warSelectBuilding.getCommands()[0][0].renderIcon(g, 425, Game.height - 130);
            }
        }
    }
    
    public void renderLand(Graphics g)
    {
        this.warLandscape.render(g);
    }
    
    public void renderNature(Graphics g)
    {
        for(int creature = 0; creature < warNature.getEntityCreatureCount(); creature++)
        {
            warNature.getEntityCreature()[creature].render(g, this.warLandscape.getBoardZoom());
        }
        for(int resource = 0; resource < warNature.getEntityResourceCount(); resource++)
        {
            warNature.getEntityResource()[resource].render(g, this.warLandscape.getBoardZoom());
        }
        for(int scenery = 0; scenery < warNature.getEntitySceneryCount(); scenery++)
        {
            warNature.getEntityScenery()[scenery].render(g, this.warLandscape.getBoardZoom());
        }
    }
    
    public void selectClear()
    {
        this.warSelectActive = false;
        this.warSelectType = "NONE";
    }
    
    public void selectBuilding(EntityBuilding building)
    {
        // NOTE: May be worth having an array of Entities for multiple selections
        this.warSelectActive = true;
        this.warSelectType = "BUILDING";
        this.warSelectBuilding = building;
    }
    
    public void selectResource(EntityResource resource)
    {
        // NOTE: May be worth having an array of Entities for multiple selections
        this.warSelectActive = true;
        this.warSelectType = "RESOURCE";
        this.warSelectResource = resource;
    }
    
    public void selectUnit(EntityUnit unit)
    {
        // NOTE: May be worth having an array of Entities for multiple selections
        this.warSelectActive = true;
        this.warSelectType = "UNIT";
        this.warSelectUnit = unit;
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
                    EntityUnit unitClick = this.warForces[0].getEntityUnits()[0];
                    unitClick.setSelected(true);
                    // NOTE: Perhaps state would be better than here to say which unit(s) is/are selected?
                    this.selectUnit(unitClick);
                }
                
                if(ref.equals("F0|B0"))
                {
                    Game.getInputMouse().mouseActionDone();

                    // Temp
                    EntityBuilding buildingClick = this.warForces[0].getEntityBuildings()[0];
                    buildingClick.setSelected(true);
                    // NOTE: Perhaps state would be better than here to say which unit(s) is/are selected?
                    this.selectBuilding(buildingClick);
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
            // Debug
            System.out.println("War registered a right mouse click");
            
            if(this.getSelectActive())
            {
                if(this.warSelectType == "UNIT")
                {
                    // mark the location of the click as the target, if the unit is able to move
                    this.warSelectUnit.setAction(new EntityActionMove(this.warSelectUnit, 400, 200, new EntityActionIdle()));
                    // NOTE: Need to pass in 'this' as reference
                }
            }
        }
    }
    
    public void tickForce()
    {
        // resources, creatures, weather, events, armies, buildings, technologies, units, effects, actions
        this.warForces[0].getEntityUnits()[0].tick();
    }
}