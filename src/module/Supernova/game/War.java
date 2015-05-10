package module.Supernova.game;

import engine.Game;
import graphics.Drawing;
import java.awt.Color;
import java.awt.Graphics;
import module.Supernova.force.ForceNature;
import module.Supernova.force.ForcePlayer;
import module.Supernova.world.Landscape;

public class War
{
    // Landscape
    private Landscape warLandscape;
    
    // Forces
    private ForcePlayer[] warForces;
    private int warForcesCount;
    private ForceNature warNature;
    
    public War()
    {
        this.warLandscape = new Landscape();
        
        // Temp
        this.warForces = new ForcePlayer[4];
        this.warForces[0] = new ForcePlayer("Jamie", "Terralith");
        this.warForces[1] = new ForcePlayer("P2", "???");
        this.warForces[2] = new ForcePlayer("P3", "???");
        this.warForces[3] = new ForcePlayer("P4", "???");
        this.warForcesCount = 4;
        this.warNature = new ForceNature();
    }
    
    public void render(Graphics g)
    {
        renderLand(g);
        renderNature(g);
        renderForce(g);
        renderInterface(g);
    }
    
    public void renderForce(Graphics g)
    {
        for(int force = 0; force < this.warForcesCount; force++)
        {
            for(int building = 0; building < this.warForces[force].getEntityBuildingsCount(); building++)
            {
                this.warForces[force].getEntityUnits()[building].render(g);
            }
            for(int unit = 0; unit < warForces[force].getEntityUnitsCount(); unit++)
            {
                this.warForces[force].getEntityUnits()[unit].render(g);
            }
        }
    }
    
    public void renderInterface(Graphics g)
    {
        g.setColor(Drawing.getColorRGB(69, 85, 69));
        g.fillRect(0, 0, Game.width, 50);
        g.fillRect(0, 0, 10, Game.height);
        g.fillRect(Game.width - 10, 0, 10, Game.height);
        g.fillRect(0, Game.height - 75, Game.width, 75);
        g.setColor(Drawing.getColorRGB(49, 65, 49));
        g.drawRect(10, 50, Game.width - 20, Game.height - 125);
        g.drawRect(11, 51, Game.width - 22, Game.height - 127);
    }
    
    public void renderLand(Graphics g)
    {
        this.warLandscape.render(g);
    }
    
    public void renderNature(Graphics g)
    {
        for(int scenery = 0; scenery < warNature.getEntitySceneryCount(); scenery++)
        {
            warNature.getEntityScenery()[scenery].render(g);
        }
        for(int creature = 0; creature < warNature.getEntityCreaturesCount(); creature++)
        {
            warNature.getEntityScenery()[creature].render(g);
        }
    }
}