package module.SteelSkirmish.world;

import engine.Game;
import graphics.Drawing;
import graphics.Fonts;
import java.awt.Color;
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
    private int[] playerAccountID = new int[2];
    private String[] playerName = new String[2];
    private boolean playerSelect;
    
    // Input Data
    private boolean inputNexus;
    
    // Debug Data
    private boolean debugEnable;
    
    // Temp Data
    private boolean tempFlag;
    
    public World()
    {
        // Temp
        this.battlePlayer = true;
        
        // Temp
        this.playerAccountID[0] = 1;
        this.playerAccountID[1] = 2;
        this.playerName[0] = "Jamie";
        this.playerName[1] = "Opponent";
        
        // Temp
        addUnitAlly(new Unit(1, 1, "knight", 100, 100, 3, 2));
        addUnitAlly(new Unit(2, 1, "samurai", 100, 100, 2, 5));
        
        // Temp
        addUnitEnemy(new Unit(3, 2, "knight", 100, 100, 8, 2));
        addUnitEnemy(new Unit(4, 2, "samurai", 100, 100, 6, 5));
        
        // Temp
        this.debugEnable = false;
        
        // Temp
        this.tempFlag = false;
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
        
        // Debug Info
        if(this.debugEnable) {renderDebugPane(g);}
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
    
    public void renderDebugPane(Graphics g)
    {
        // Render frame fill
        g.setColor(Color.BLACK);
        g.fillRect(500, 25, 400, 100);
        
        // Render frame border
        g.setColor(Color.GREEN);
        g.drawRect(500, 25, 400, 100);
        
        // Render message
        String debugMessage1 = "It is your turn";
        if(this.battlePlayer == false) {debugMessage1 = "It is not your turn";}
        String debugMessage2 = "Nothing selected";
        if(this.playerSelect) {debugMessage2 = "Unit selected";}
        g.setFont(Game.getFont("Standard"));
        g.setColor(Color.GREEN);
        g.drawString(debugMessage1, 525, 60);
        g.drawString(debugMessage2, 525, 90);
    }
    
    public void renderInterface(Graphics g)
    {
        /*renderInterfacePlayer(g, 1);
        renderInterfacePlayer(g, 2);*/
        
        // Temp
        g.drawImage(Drawing.getImage("interface/hudPlayer.png", "SteelSkirmish"), 0, 0, null);
    }
    
    public void renderInterfacePlayer(Graphics g, int player)
    {
        // Render frame fill
        int frameX = 25;
        if(player == 2) {frameX = 990;}
        g.setColor(Color.WHITE);
        g.fillRect(frameX, 25, 200, 100);
        
        // Render frame border
        g.setColor(Color.BLACK);
        g.drawRect(frameX, 25, 200, 100);
        
        // Render name
        String nameString = this.playerName[player-1];
        int nameX = 40;
        if(player == 2) {nameX = 1005;}
        g.setFont(Game.getFont("Standard"));
        g.setColor(Color.BLACK);
        g.drawString(nameString, nameX, 60);
    }
    
    public void renderUnits(Graphics g)
    {
        renderUnitsAllies(g);
        renderUnitsEnemies(g);
        
        // Temp
        if(tempFlag)
        {
            g.drawImage(Drawing.getImage("unit/cursor/flag1.png", "SteelSkirmish"), 500, 200, null);
        }
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
        tickUnits();
    }
    
    public void tickMouse()
    {
        if(playerSelect)
        {
            if(Game.getInputMouse().mouseActionPressedR==true)
            {
                this.tempFlag = true;
                playerSelect = false;
            }
        }
        else
        {
            if(Game.getInputMouse().mouseActionPressedL==true)
            {
                if(!Game.getInputMouse().mouseNexusClick.equals(""))
                {
                    // Get 
                    unitAllies[0].setUnitSelected(true);
                    playerSelect = true;
                }
            }
        }
    }
    
    public void tickUnits()
    {
        tickUnitsAllies();
        tickUnitsEnemies();
    }
    
    public void tickUnitsAllies()
    {
        for(int unit = 0; unit < unitAlliesCount; unit++)
        {
            unitAllies[unit].tick();
        }
    }
    
    public void tickUnitsEnemies()
    {
        for(int unit = 0; unit < unitEnemiesCount; unit++)
        {
            unitEnemies[unit].tick();
        }
    }
    
}