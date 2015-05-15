package module.Supernova.force;

import module.Supernova.entity.EntityBuilding;
import module.Supernova.entity.EntityUnit;
import module.Supernova.game.War;

public class ForcePlayer extends Force
{
    // Details
    private int forceID;
    private String forceTitle;
    private String forceHouse;
    private War forceWar;
    
    // Resources
    private int resourceObsidian;
    
    // Buildings
    private EntityBuilding[] entityBuildings;
    private int entityBuildingsCount;
    
    // Units
    private EntityUnit[] entityUnits;
    private int entityUnitsCount;
    
    public ForcePlayer(War war, int id, String title, String house)
    {
        this.forceWar = war;
        this.forceID = id;
        this.forceTitle = title;
        this.forceHouse = house;
        this.entityBuildings = new EntityBuilding[100];
        this.entityBuildingsCount = 0;
        this.entityUnits = new EntityUnit[100];
        this.entityUnitsCount = 0;
        
        // Temp (just for force 0)
        if(this.forceID == 0)
        {
            this.entityUnits[0] = new EntityUnit(this.forceWar, this.forceID, 0);
            this.entityUnitsCount = 1;
            this.entityBuildings[0] = new EntityBuilding(this.forceWar, this.forceID, 0);
            this.entityBuildingsCount = 1;
        }
    }
    
    public EntityBuilding[] getEntityBuildings()
    {
        return this.entityBuildings;
    }
    
    public int getEntityBuildingsCount()
    {
        return this.entityBuildingsCount;
    }
    
    public EntityUnit[] getEntityUnits()
    {
        return this.entityUnits;
    }
    
    public int getEntityUnitsCount()
    {
        return this.entityUnitsCount;
    }
    
}