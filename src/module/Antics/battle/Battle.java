package module.Antics.battle;

import engine.Game;
import graphics.Drawing;
import java.awt.Graphics;

public class Battle
{
    private String battleType;
    private String background;
    private Force forceAllied;
    private Force forceEnemy;
    private int turnCount;
    private boolean turnReady;
    private Environment environment;
    
    public Battle(String type)
    {
        this.battleType = type;
        //this.background = background;
        this.turnCount = 0;
        this.turnReady = true;
        //this.forceAllied = 
        // NOTE: create battle force from party
        //this.forceEnemy = new Force(this, "ENEMY");
        // build the majority of the functions into the Force class then create subclasses for allied and enemy
    }
    
    public void render(Graphics g)
    {
        renderBackground(g);
        renderCreatures(g);
        renderInterface(g);
    }
    
    public void renderBackground(Graphics g)
    {
        g.setColor(Drawing.getColorRGB(192, 238, 142));
        g.fillRect(0, 0, 1366, 768);
    }
    
    public void renderCreatures(Graphics g)
    {
        // Party
        g.drawImage(Drawing.getImage("creature/canine/canine01C.png", "Antics"), Game.width - 300, 200, null);
        
        // Opponent
        g.drawImage(Drawing.flipImage(Drawing.getImage("creature/canine/canine01A.png", "Antics")), 100, 200, null);
    }
    
    public void renderInterface(Graphics g)
    {
        
    }
    
    public void tick()
    {
        
    }
}