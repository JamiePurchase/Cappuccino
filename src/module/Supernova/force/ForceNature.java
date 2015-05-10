package module.Supernova.force;

import module.Supernova.entity.EntitySentientCreature;
import module.Supernova.entity.EntityStaticScenery;

public class ForceNature extends Force
{
    private EntitySentientCreature[] entityCreatures;
    private int entityCreaturesCount;
    private EntityStaticScenery[] entityScenery;
    private int entitySceneryCount;
    
    public ForceNature()
    {
        this.entityCreatures = new EntitySentientCreature[50];
        this.entityCreaturesCount = 0;
        this.entityScenery = new EntityStaticScenery[50];
        this.entitySceneryCount = 0;
    }
    
    public EntitySentientCreature[] getEntityCreatures()
    {
        return this.entityCreatures;
    }
    
    public int getEntityCreaturesCount()
    {
        return this.entityCreaturesCount;
    }
    
    public EntityStaticScenery[] getEntityScenery()
    {
        return this.entityScenery;
    }
    
    public int getEntitySceneryCount()
    {
        return this.entitySceneryCount;
    }
}