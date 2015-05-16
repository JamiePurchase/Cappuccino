package module.Ignition.army;

import java.awt.Graphics;
import module.Ignition.item.ItemAmulet;
import module.Ignition.item.ItemRing;
import module.Ignition.item.ItemWeapon;

public class Unit
{
    // Unit
    private String unitID;
    private Army unitArmy;
    private Team unitTeam;
    
    // Info
    private String infoName;
    private String infoType;
    
    // Gear
    private ItemWeapon gearWeaponR;
    private ItemWeapon gearWeaponL;
    private ItemAmulet gearAmulet;
    private ItemRing gearRing;
    
    // Stats
    private int statHealthNow;
    private int statHealthMax;
    private int statEnergyNow;
    private int statEnergyMax;
    private int statMysticNow;
    private int statMysticMax;
    private int statMoraleNow;
    
    // Perks
    private Perk perkStruct;
    
    // Techniques
    private Tech[] techCombat;
    private Tech[] techMystic;
    private Tech[] tectUnique;
    
    // Effect
    private Effect[] effectStruct;
    
    public Unit()
    {
        
    }
    
    public void render(Graphics g)
    {
        
    }
    
    public void tick()
    {
        
    }
    
}