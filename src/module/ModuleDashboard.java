package module;

import java.awt.Graphics;
import state.State;
import state.StateDashboard;

public class ModuleDashboard extends Module
{
    private State moduleState;
    
    public ModuleDashboard()
    {
        this.moduleState = new StateDashboard();
    }
    
    public void render(Graphics g)
    {
        this.moduleState.render(g);
    }
    
    public void tick()
    {
        this.moduleState.tick();
    }
}