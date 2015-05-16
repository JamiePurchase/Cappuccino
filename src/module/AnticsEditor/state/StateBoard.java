package module.AnticsEditor.state;

import engine.Game;
import graphics.Drawing;
import java.awt.Color;
import java.awt.Graphics;
import module.Antics.board.Board;
import state.State;

public class StateBoard extends State
{
    // Board
    private String boardFile;
    private boolean boardActive;
    private Board boardObject;
    private boolean boardUnsaved;
    
    // Tools
    private String brush;
    
    public StateBoard()
    {
        // Board
        this.boardFile = "Shumak01";
        this.boardActive = true;
        this.boardObject = new Board("Shumak01", 30, 20);
        // NOTE: change the above so that we load the board
        this.boardObject.setDrawPosition(11, 64);
        this.boardUnsaved = false;
        
        // Tools
        this.brush = "";
        
        // Nexus
        //Game.getInputMouse().nexusClear();
        //Game.getInputMouse().nexusAdd("board", 11, 64, 1340, 672);
    }
    
    public String getTitle()
    {
        String title = "Antics Devkit - Board Editor";
        if(this.boardActive) {title += " - " + this.boardObject.getBoardTitle();}
        if(this.boardUnsaved) {title += "*";}
        return title;
    }
    
    public void render(Graphics g)
    {
        this.renderEditor(g);
        this.renderBoard(g);
        this.renderTools(g);
    }
    
    public void renderBoard(Graphics g)
    {
        this.boardObject.render(g);
    }
    
    public void renderEditor(Graphics g)
    {
        // Background
        g.setColor(Drawing.getColorRGB(110, 70, 90));
        g.fillRect(0, 0, Game.width, Game.height);
        
        // Frame
        g.setColor(Color.BLACK);
        g.fillRect(11, 32, Game.width - 22, Game.height - 64);
        
        // Title
        g.setFont(Game.getFont("Title"));
        g.setColor(Color.BLACK);
        g.drawString(this.getTitle(), 15, 25);
    }
    
    public void renderTools(Graphics g)
    {
        // Toolbar
        g.setColor(Drawing.getColorRGB(120, 105, 115));
        g.fillRect(10, 32, Game.width - 22, 32);
        g.setColor(Drawing.getColorRGB(0, 0, 0));
        g.drawRect(10, 32, Game.width - 22, 32);
        
        // Options
        g.setFont(Game.getFont("Standard"));
        g.setColor(Color.BLACK);
        g.drawString("BOARD", 25, 55);
    }
    
    public void tick()
    {
        tickMouse();
    }
    
    public void tickMouse()
    {
        if(Game.getInputMouse().mouseActionPressedL == true)
        {
            String ref = Game.getInputMouse().nexusCheckRef();
            if(ref.equals("board"))
            {
                Game.getInputMouse().mouseActionDone();
                System.out.println("Clicked on the board");
            }
            //if(ref
        }
    }
}