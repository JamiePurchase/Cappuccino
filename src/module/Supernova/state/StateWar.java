package module.Supernova.state;

import java.awt.Graphics;
import module.Supernova.game.War;
import state.State;

public class StateWar extends State
{
    private War war;
    
    public StateWar()
    {
        this.war = new War();
    }
    
    public War getWar()
    {
        return this.war;
    }
    
    public void render(Graphics g)
    {
        this.war.render(g);
    }
    
    public void tick()
    {
        this.war.tick();
    }
}