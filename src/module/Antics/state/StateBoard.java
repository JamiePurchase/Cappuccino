package module.Antics.state;

import engine.Game;
import graphics.Drawing;
import graphics.Tileset;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import module.Antics.board.Board;
import state.State;

public class StateBoard extends State
{
    private Board board;
    //public BufferedImage[] tileset;
    
    public StateBoard()
    {
        this.board = new Board("Test", 10, 10);
        //String file = Game.getResourcePath() + "src/module/Antics/resources/tileset/village1.png";
        //tileset = Tileset.getTileset(file, 8, 22);
    }
    
    public void render(Graphics g)
    {
        this.board.render(g);
    }

    public void tick()
    {
        tickKey();
    }
    
    public void tickKey()
    {
        // Listen for menu buttons
    }
}