package module.SteelSkirmish.world;

import engine.Game;
import graphics.Drawing;
import java.awt.Graphics;
import module.SteelSkirmish.unit.Unit;

public class World
{
    // Battle Data
    private int battleID;
    private int battleTurn;
    private boolean battlePlayer;
    
    // Unit Data
    private Unit[] unitAllies = new Unit[20];
    private int unitAlliesCount = 0;
    private Unit[] unitEnemies = new Unit[20];
    private int unitEnemiesCount = 0;
    
    // Player Data
    private boolean playerSelect;
    
    // Input Data
    private boolean inputNexus;
    
    public World()
    {
        // Temp
        addUnitAlly(new Unit(1, 1, "knight", 100, 100, 3, 2));
        addUnitAlly(new Unit(2, 1, "samurai", 100, 100, 2, 5));
    }
    
    public void addUnitAlly(Unit unit)
    {
        this.unitAllies[this.unitAlliesCount] = unit;
        this.unitAlliesCount += 1;
    }
    
    public void addUnitEnemy(Unit unit)
    {
        this.unitEnemies[this.unitEnemiesCount] = unit;
        this.unitEnemiesCount += 1;
    }
    
    public void render(Graphics g)
    {
        // Fresh nexus data
        if(this.inputNexus == false) {Game.getInputMouse().nexusClear();}
        
        // Render graphics
        renderBackground(g);
        renderUnits(g);
        renderInterface(g);
        
        // Nexus data complete
        this.inputNexus = true;
    }
    
    public void renderBackground(Graphics g)
    {
        for(int x = 0; x < 14; x++)
        {
            for(int y = 0; y < 8; y++)
            {
                int posX = x * 100;
                int posY = y * 100;
                g.drawImage(Drawing.getImage("terrain/grass1a.png", "SteelSkirmish"), posX, posY, null);
            }
        }
    }
    
    public void renderInterface(Graphics g)
    {
        
    }
    
    public void renderUnits(Graphics g)
    {
        renderUnitsAllies(g);
        renderUnitsEnemies(g);
    }
    
    public void renderUnitsAllies(Graphics g)
    {
        for(int unit = 0; unit < unitAlliesCount; unit++)
        {
            unitAllies[unit].render(g);
            if(this.inputNexus == false)
            {
                unitAllies[unit].createNexus("unit-ally-" + unit);
            }
        }
    }
    
    public void renderUnitsEnemies(Graphics g)
    {
        for(int unit = 0; unit < unitEnemiesCount; unit++)
        {
            unitEnemies[unit].render(g);
            if(this.inputNexus == false)
            {
                unitEnemies[unit].createNexus("unit-enemy-" + unit);
            }
        }
    }
    
    public void tick()
    {
        tickMouse();
    }
    
    public void tickMouse()
    {
        if(!Game.getInputMouse().mouseNexusClick.equals(""))
        {
            unitAllies[0].setUnitSelected(true);
        }
    }
    
}