package module.Antics.battle;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import module.Antics.battle.Battle;
import module.Antics.battle.Effect;
import module.Antics.battle.Tech;

public class Creature
{
    // Info
    private String infoName;
    private Battle infoBattle;
    private boolean infoAlly;
    
    // Anim
    private BufferedImage animImage;
    
    // Stats
    private int statHealthNow;
    private int statHealthMax;
    
    // Techniques
    private Tech[] techArray;
    
    // Effects
    private Effect[] effectArray;
    
    // Rank
    private int rankLevel;
    private int rankExpNow;
    private int rankExpNext;
    
    public Creature()
    {
        
    }
    
    public void render(Graphics g)
    {
        
    }
}