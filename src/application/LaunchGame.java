package application;

import engine.Game;
import module.Antics.module.ModuleAntics;
import module.AnticsEditor.module.ModuleAnticsEditor;

public class LaunchGame
{
    public static void main(String args[])
    {
        new Game(new ModuleAntics()).start();
    }
}