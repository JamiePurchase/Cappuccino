package module.SteelSkirmish.unit;

public class Effect
{
    private String effectType;
    private int effectTick;
    
    public Effect(String type, int tick)
    {
        this.effectType = type;
        this.effectTick = tick;
    }
}