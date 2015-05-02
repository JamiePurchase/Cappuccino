package module.SteelSkirmish.module;

import java.awt.Graphics;
import module.Module;
import module.SteelSkirmish.state.StateTitle;
import state.State;

public class ModuleSteelSkirmish extends Module
{
    private State moduleState;
    
    public ModuleSteelSkirmish()
    {
        this.setState(new StateTitle());
    }
    
    public void render(Graphics g)
    {
        this.getState().render(g);
    }
    
    public void tick()
    {
        this.getState().tick();
    }
}