package module.Antics.state;

import engine.Game;
import graphics.Drawing;
import graphics.Tileset;
import java.awt.Graphics;
import module.Antics.battle.Battle;
import state.State;

public class StateBattle extends State
{
    private Battle battle;
    
    public StateBattle()
    {
        this.battle = new Battle("WILD");
    }
    
    public void render(Graphics g)
    {
        this.battle.render(g);
    }
    
    public void tick()
    {
        this.battle.tick();
    }
}