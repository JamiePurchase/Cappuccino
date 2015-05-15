package module.Supernova.force;

import module.Supernova.entity.EntityResource;
import module.Supernova.entity.EntityScenery;
import module.Supernova.entity.EntityUnit;
import module.Supernova.game.War;

public class ForceNature extends Force
{
    // War
    private War warObject;
    
    // Creatures
    private EntityUnit[] entityCreature;
    private int entityCreatureCount;
    
    // Resources
    private EntityResource[] entityResource;
    private int entityResourceCount;
    
    // Scenery
    private EntityScenery[] entityScenery;
    private int entitySceneryCount;
    
    public ForceNature(War war)
    {
        this.warObject = war;
        this.entityCreature = new EntityUnit[50];
        this.entityCreatureCount = 0;
        this.entityResource = new EntityResource[50];
        this.entityResourceCount = 0;
        this.entityScenery = new EntityScenery[50];
        this.entitySceneryCount = 0;
        
        // Temp
        this.entityScenery[0] = new EntityScenery(this.warObject, "graphics/scenery/Mongun8/tree01.png", 700, 50, 128, 128);
        this.entitySceneryCount = 1;
    }
    
    public EntityUnit[] getEntityCreature()
    {
        return this.entityCreature;
    }
    
    public int getEntityCreatureCount()
    {
        return this.entityCreatureCount;
    }
    
    public EntityResource[] getEntityResource()
    {
        return this.entityResource;
    }
    
    public int getEntityResourceCount()
    {
        return this.entityResourceCount;
    }
    
    public EntityScenery[] getEntityScenery()
    {
        return this.entityScenery;
    }
    
    public int getEntitySceneryCount()
    {
        return this.entitySceneryCount;
    }
}