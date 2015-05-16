package module.Ignition.army;

import java.awt.Graphics;
import module.Ignition.battlefield.Area;

public class Team
{
    // Team
    private Army teamArmy;
    private Unit[] teamUnit;
    
    // Info
    private String infoName;
    
    // State
    private Area stateLocation;
    private boolean stateDefend;
    private boolean stateEngage;
    private Team stateEngageTeam;
    private boolean stateHidden;
    private String stateHiddenType;
    
    public Team()
    {
        
    }
    
    public void render(Graphics g)
    {
        
    }
    
    public void tick()
    {
        
    }
    
}