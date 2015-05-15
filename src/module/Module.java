package module;

import engine.Game;
import module.Dashboard.state.StateDashboard;
import java.awt.Graphics;
import state.State;
import graphics.Fonts;

public abstract class Module
{
    public abstract Fonts getFonts();
    public abstract State getState();
    public abstract void render(Graphics g);
    public abstract void setState(State newState);
    public abstract void tick();
}