package module;

import engine.Game;
import state.StateDashboard;
import java.awt.Graphics;
import state.State;

public abstract class Module
{
    public abstract void render(Graphics g);
    public abstract void tick();
    
    private static State moduleState;
    
    public State getState()
    {
        return moduleState;
    }
    
    public void setState(State newState)
    {
        moduleState = newState;
    }
}