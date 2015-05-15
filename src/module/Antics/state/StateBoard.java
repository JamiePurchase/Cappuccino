package module.Antics.state;

import engine.Game;
import graphics.Drawing;
import graphics.Tileset;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import module.Antics.board.Board;
import module.Antics.module.ModuleAntics;
import state.State;

public class StateBoard extends State
{
    private ModuleAntics module;
    private Board board;
    //public BufferedImage[] tileset;
    
    // Pause Menu
    private boolean pause;
    private int pauseCursor;
    private String[] pauseOption = new String[5];
    
    public StateBoard(ModuleAntics module)
    {
        this.module = module;
        this.board = new Board("Test", 30, 20);
        //String file = Game.getResourcePath() + "src/module/Antics/resources/tileset/village1.png";
        //tileset = Tileset.getTileset(file, 8, 22);
        
        // Pause Menu
        this.pause = false;
        this.pauseCursor = 0;
        this.pauseOption[0] = "OBJECTIVES";
        this.pauseOption[1] = "CREATURES";
        this.pauseOption[2] = "INVENTORY";
        this.pauseOption[3] = "SETTINGS";
        this.pauseOption[4] = "FINISHED";
    }
    
    public void render(Graphics g)
    {
        this.board.render(g);
        if(this.pause) {renderPause(g);}
    }
    
    public void renderPause(Graphics g)
    {
        // Frame
        g.setColor(Drawing.getColorRGB(255, 255, 255));
        g.fillRect(25, 25, 200, Game.height - 50);
        g.setColor(Color.BLACK);
        g.drawRect(25, 25, 200, Game.height - 50);
        
        // Options
        g.drawString("QUESTS", 50, 50);
        
        // Cursor
    }

    public void tick()
    {
        if(this.pause) {tickPause();}
        else
        {
            tickKey();
            this.board.tick();
        }
    }
    
    public void tickKey()
    {
        // Listen for menu buttons
        if(Game.getInputKeyboard().getKeyPressed() == "Enter")
        {
            this.pause = true;
            Game.getInputKeyboard().keyPressedDone();
        }
        
        if(this.board.getPlayer().getAnimBusy() == false) {tickKeyPlayer();}
        
        // Temp
        Game.getInputKeyboard().keyPressedDone();
    }
    
    public void tickKeyPlayer()
    {
        //Player
        if(Game.getInputKeyboard().getKeyPressed() == "Down")
        {
            System.out.println("State Tick Key - Down");
        
            this.board.getPlayer().setStanceWalk("S");
            Game.getInputKeyboard().keyPressedDone();
        }
        if(Game.getInputKeyboard().getKeyPressed() == "Left")
        {
            this.board.getPlayer().setStanceWalk("W");
            Game.getInputKeyboard().keyPressedDone();
        }
        if(Game.getInputKeyboard().getKeyPressed() == "Right")
        {
            this.board.getPlayer().setStanceWalk("E");
            Game.getInputKeyboard().keyPressedDone();
        }
        if(Game.getInputKeyboard().getKeyPressed() == "Up")
        {
            this.board.getPlayer().setStanceWalk("N");
            Game.getInputKeyboard().keyPressedDone();
        }
    }
    
    public void tickPause()
    {
        if(Game.getInputKeyboard().getKeyPressed() == "Enter" || Game.getInputKeyboard().getKeyPressed() == "Space")
        {
            if(pauseCursor == 0) {this.module.switchState(new StateObjectives());}
            if(pauseCursor == 1) {this.module.switchState(new StateCreatures());}
            if(pauseCursor == 2) {this.module.switchState(new StateInventory());}
            if(pauseCursor == 3) {this.module.switchState(new StateSettings());}
            if(pauseCursor == 4) {this.pause = false;}
            Game.getInputKeyboard().keyPressedDone();
        }
        if(Game.getInputKeyboard().getKeyPressed() == "Up")
        {
            if(this.pauseCursor > 1)
            {
                this.pauseCursor -= 1;
                // menu sound
            }
            Game.getInputKeyboard().keyPressedDone();
        }
        if(Game.getInputKeyboard().getKeyPressed() == "Down")
        {
            if(this.pauseCursor > this.pauseOption.length)
            {
                this.pauseCursor += 1;
                // menu sound
            }
            Game.getInputKeyboard().keyPressedDone();
        }
        if(Game.getInputKeyboard().getKeyPressed() == "Escape")
        {
            this.pause = false;
            Game.getInputKeyboard().keyPressedDone();
        }
    }
}