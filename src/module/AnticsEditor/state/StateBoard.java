package module.AnticsEditor.state;

import engine.Game;
import graphics.Drawing;
import input.InputMouse;
import input.InputMouseNexus;
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
        InputMouse testMouse = Game.getInputMouse();
        InputMouseNexus testNexus = new InputMouseNexus("test", 0, 0, 1, 1);
        // UNRESOLVED ISSUE: nexusClear is throwing a null pointer error
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
        
        // Exit Button (please put an x in the corner
    }
    
    public void renderTools(Graphics g)
    {
        // Toolbar
        g.setColor(Drawing.getColorRGB(120, 105, 115));
        g.fillRect(10, 32, Game.width - 22, 32);
        g.setColor(Drawing.getColorRGB(0, 0, 0));
        g.drawRect(10, 32, Game.width - 22, 32);
        
        // Highlight
        g.setColor(Drawing.getColorRGB(130, 125, 165));
        String nexusRef = Game.getInputMouse().nexusCheckRef();
        if(nexusRef.equals("new")) {g.fillRect(11, 33, 65, 30);}
        
        // Options
        g.setFont(Game.getFont("Standard"));
        g.setColor(Color.BLACK);
        g.drawString("NEW", 25, 55);
        g.drawString("OPEN", 100, 55);
        g.drawString("SAVE", 175, 55);
        g.drawString("CLOSE", 250, 55);
        g.drawString("BOARD", 325, 55);
        g.drawString("OPTIONS", 400, 55);
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
            if(ref.equals("new"))
            {
                
            }
            if(ref.equals("open"))
            {
                
            }
            if(ref.equals("save"))
            {
                
            }
            if(ref.equals("close"))
            {
                
            }
            if(ref.equals("board"))
            {
                
            }
            if(ref.equals("options"))
            {
                
            }
        }
    }
}