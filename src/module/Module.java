package module;

import engine.Game;
import state.StateDashboard;
import java.awt.Graphics;
import state.State;

public abstract class Module
{
    public abstract State getState();
    public abstract void render(Graphics g);
    public abstract void setState(State newState);
    public abstract void tick();
}