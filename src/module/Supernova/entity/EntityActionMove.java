package module.Supernova.entity;

public class EntityActionMove extends EntityAction
{
    // Unit
    private EntityUnit unit;
    
    // Target
    private int targetX;
    private int targetY;
    
    // Next Action
    private EntityAction next;
    
    public EntityActionMove(EntityUnit unit, int targetX, int targetY, EntityAction next)
    {
        this.unit = unit;
        this.targetX = targetX;
        this.targetY = targetY;
        this.next = next;
    }
    
    public void tick()
    {
        // Move unit towards target
        this.unit.move("SE");
        
        // Check if arrived
        //if(this.unit.get)
    }
}