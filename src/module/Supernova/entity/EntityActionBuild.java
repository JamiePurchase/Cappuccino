package module.Supernova.entity;

public class EntityActionBuild extends EntityAction
{
    // Target
    private EntityBuilding targetBuilding;
    
    public EntityActionBuild(EntityBuilding target)
    {
        this.targetBuilding = target;
    }
    
    public void tick()
    {
        // Contribute towards building completion
    }
}