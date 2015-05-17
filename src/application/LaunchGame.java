package application;

import engine.Game;
import module.Antics.module.ModuleAntics;
import module.AnticsEditor.module.ModuleAnticsEditor;
import module.Supernova.module.ModuleSupernova;

public class LaunchGame
{
    public static void main(String args[])
    {
        new Game(new ModuleSupernova()).start();
    }
}