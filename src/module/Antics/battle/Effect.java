package module.Antics.battle;

public abstract class Effect
{
    public abstract void tick();
    
    private boolean durationInfinite;
    private int durationTurns;
}