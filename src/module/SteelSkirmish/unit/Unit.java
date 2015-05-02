package module.SteelSkirmish.unit;

import engine.Game;
import graphics.Drawing;
import java.awt.Graphics;

public class Unit
{
    // Unit Details
    private int unitID;
    private int unitPlayer;
    private String unitName;
    private String unitType;
    private boolean unitSelect;
    
    // Stats
    private int statHealthNow;
    private int statHealthMax;
    private Effect[] statEffects = new Effect[20];
    
    // Animation
    private String animStance;
    private int animFrame;
    
    // Grid Data
    private int gridPosX;
    private int gridPosY;

    public Unit(int id, int player, String type, int healthNow, int healthMax, int posX, int posY)
    {
        this.unitID = id;
        this.unitPlayer = player;
        this.unitName = type;
        this.unitType = type;
        this.unitSelect = false;
        this.statHealthNow = healthNow;
        this.statHealthMax = healthMax;
        this.animStance = "idle";
        this.animFrame = 1;
        this.gridPosX = posX;
        this.gridPosY = posY;
    }
    
    public void addStatEffect(Effect effect)
    {
        this.statEffects[this.statEffects.length] = effect;
    }
    
    public void createNexus(String reference)
    {
        Game.getInputMouse().nexusAdd(reference, this.getAnimPosX(), this.getAnimPosY(), 100, 100);
    }
    
    public String getAnimFile()
    {
        return "unit/" + this.getUnitType() + "/" + this.getAnimStance() + "-P" + this.getUnitPlayer() + "-A" + this.getAnimFrame() + "-" + "C1" + ".png";
    }
    
    public int getAnimFrame()
    {
        return this.animFrame;
    }
    
    public int getAnimPosX()
    {
        return this.gridPosX * 100;
    }
    
    public int getAnimPosY()
    {
        return this.gridPosY * 100;
    }
    
    public String getAnimStance()
    {
        return this.animStance;
    }
    
    public int getGridPosX()
    {
        return this.gridPosX;
    }
    
    public int getGridPosY()
    {
        return this.gridPosY;
    }
    
    public Effect[] getStatEffects()
    {
        return this.statEffects;
    }
    
    public int getStatHealthMax()
    {
        return this.statHealthMax;
    }
    
    public int getStatHealthNow()
    {
        return this.statHealthNow;
    }
    
    public String getUnitName()
    {
        return this.unitName;
    }
    
    public int getUnitPlayer()
    {
        return this.unitPlayer;
    }
    
    public boolean getUnitSelected()
    {
        return this.unitSelect;
    }
    
    public String getUnitType()
    {
        return this.unitType;
    }
    
    public void render(Graphics g)
    {
        if(this.getUnitSelected()) {renderSelection(g);}
        renderUnit(g);
    }
    
    public void renderSelection(Graphics g)
    {
        g.drawImage(Drawing.getImage("unit/cursor/select1.png", "SteelSkirmish"), this.getAnimPosX(), this.getAnimPosY(), null);   
    }
    
    public void renderUnit(Graphics g)
    {
        g.drawImage(Drawing.getImage(this.getAnimFile(), "SteelSkirmish"), this.getAnimPosX(), this.getAnimPosY(), null);
    }
    
    public void setUnitSelected(boolean value)
    {
        this.unitSelect = value;
    }
}