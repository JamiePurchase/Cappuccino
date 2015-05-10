package module.Supernova.game;

import engine.Game;
import graphics.Drawing;
import java.awt.Graphics;
import module.Supernova.force.ForceNature;
import module.Supernova.force.ForcePlayer;

public class War
{
    // Forces
    private ForcePlayer[] warForces;
    private int warForcesCount;
    private ForceNature warNature;
    
    public War()
    {
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
        
    }
    
    public void renderLand(Graphics g)
    {
        g.setColor(Drawing.getColorRGB(180, 197, 133));
        g.fillRect(0, 0, Game.width, Game.height);
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