package module.Antics.battle;

public class Force
{
    private Battle forceBattle;
    private Creature[] forceCreature = new Creature[6];
    
    public Force(Battle battle)
    {
        this.forceBattle = battle;
    }
}