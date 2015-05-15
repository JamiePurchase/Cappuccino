package module;

import engine.Game;
import module.Antics.module.ModuleAntics;
import module.AnticsEditor.module.ModuleAnticsEditor;
import module.Dashboard.module.ModuleDashboard;
import module.Earthland.module.ModuleEarthland;
import module.Ignition.module.ModuleIgnition;
import module.Minstrel.module.ModuleMinstrel;
import module.SteelSkirmish.module.ModuleSteelSkirmish;
import module.Supernova.module.ModuleSupernova;
import module.SupernovaEditor.module.ModuleSupernovaEditor;

public class Gateway
{
    public void appLaunch(String moduleID)
    {
        
        System.out.println("appLaunch " + moduleID);
       
        // System
        if(moduleID.equals("SYS-HOMEDASH")) {Game.setModule(new ModuleDashboard());}
        if(moduleID.equals("SYS-MINSTREL")) {Game.setModule(new ModuleMinstrel());}
        
        // Games
        if(moduleID.equals("GAM-SKIRMISH")) {Game.setModule(new ModuleSteelSkirmish());}
        if(moduleID.equals("GAM-ANTICS01")) {Game.setModule(new ModuleAntics());}
        if(moduleID.equals("GAM-SUPERNOV")) {Game.setModule(new ModuleSupernova());}
        if(moduleID.equals("GAM-EARTHLAN")) {Game.setModule(new ModuleEarthland());}
        if(moduleID.equals("GAM-IGNITION")) {Game.setModule(new ModuleIgnition());}
        
        // Development
        if(moduleID.equals("DEV-ANTICS01")) {Game.setModule(new ModuleAnticsEditor());}
        if(moduleID.equals("DEV-SUPERNOV")) {Game.setModule(new ModuleSupernovaEditor());}
        
        // Default
        Game.setModule(new ModuleDashboard());
    }
}