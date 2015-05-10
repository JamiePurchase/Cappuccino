package module.Supernova.force;

import module.Supernova.entity.EntitySentientUnit;
import module.Supernova.entity.EntityStaticBuilding;

public class ForcePlayer extends Force
{
    // Details
    private String forceTitle;
    private String forceHouse;
    
    // Resources
    private int resourceObsidian;
    
    // Buildings
    private EntityStaticBuilding[] entityBuildings;
    private int entityBuildingsCount;
    
    // Units
    private EntitySentientUnit[] entityUnits;
    private int entityUnitsCount;
    
    public ForcePlayer(String title, String house)
    {
        this.forceTitle = title;
        this.forceHouse = house;
        this.entityBuildings = new EntityStaticBuilding[100];
        this.entityBuildingsCount = 0;
        this.entityUnits = new EntitySentientUnit[100];
        this.entityUnitsCount = 0;
        
        // Temp
        this.entityUnits[0] = new EntitySentientUnit();
        this.entityUnitsCount = 1;
    }
    
    public EntityStaticBuilding[] getEntityBuildings()
    {
        return this.entityBuildings;
    }
    
    public int getEntityBuildingsCount()
    {
        return this.entityBuildingsCount;
    }
    
    public EntitySentientUnit[] getEntityUnits()
    {
        return this.entityUnits;
    }
    
    public int getEntityUnitsCount()
    {
        return this.entityUnitsCount;
    }
    
}