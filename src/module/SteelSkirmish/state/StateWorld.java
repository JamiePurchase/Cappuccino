package module.SteelSkirmish.state;

import java.awt.Graphics;
import module.SteelSkirmish.world.World;
import state.State;

public class StateWorld extends State
{
    private World world;
    
    public StateWorld()
    {
        System.out.println("SteelSkirmish StateWorld");
        this.world = new World();
    }
    
    public void render(Graphics g)
    {
        this.world.render(g);
    }
    
    public void tick()
    {
        this.world.tick();
    }
}