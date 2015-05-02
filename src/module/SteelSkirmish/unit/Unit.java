package module.SteelSkirmish.unit;

import java.awt.Graphics;

public class Unit
{
    // Unit Details
    private int unitID;
    private String unitType;
    private boolean unitSelect;
    
    // Stats
    private int statHealthNow;
    private int statHealthMax;
    
    // Animation
    private String animStance;
    private int animFrame;
    
    // Grid Data
    private int gridPosX;
    private int gridPosY;

    public Unit()
    {
        
    }
    
    public void render(Graphics g)
    {
        
    }
}