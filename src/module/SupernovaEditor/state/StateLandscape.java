package module.SupernovaEditor.state;

import engine.Game;
import graphics.Drawing;
import graphics.Fonts;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import module.Supernova.game.War;
import org.w3c.dom.css.Rect;
import state.State;

public class StateLandscape extends State
{
    // Frame
    private int framePosX, framePosY, frameWide, frameHigh;
    
    // File
    private String fileName;
    private boolean fileUnsaved;
    
    // Editor Tools
    private String editBrush;
    private String editTileset;
    private boolean editTilesetNull;
    private int editTilePosX;
    private int editTilePosY;
    
    public StateLandscape(int frameX, int frameY, int frameW, int frameH)
    {
        // Frame Data
        this.framePosX = frameX;
        this.framePosY = frameY;
        this.frameWide = frameW;
        this.frameHigh = frameH;
        
        // Default Brush
        this.editBrushSelect("EXAMINE");
        
        // Tileset is null until opened (OR we could remember the last one used)
        this.editTilesetNull = true;
    }
    
    private void editBrushSelect(String brush)
    {
        this.editBrush = brush;
    }
    
    private void fileSave()
    {
        // Save the file
        this.fileUnsaved = false;
    }
    
    public void render(Graphics g)
    {
        this.renderFrame(g);
        //render
    }
    
    public void renderFrame(Graphics g)
    {
        // Screen Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        
        // Frame Border Background
        g.setColor(Drawing.getColorRGB(104, 164, 38));
        g.fillRoundRect(this.framePosX, this.framePosY, this.frameWide, this.frameHigh, 25, 25);
        
        // Frame Contents Background
        g.setColor(Drawing.getColorRGB(61, 86, 15));
        g.fillRoundRect(this.framePosX + 5, this.framePosY + 5, this.frameWide - 10, this.frameHigh - 10, 25, 25);
        
        // Frame Header Background
        g.setColor(Drawing.getColorRGB(115, 159, 28));
        g.fillRoundRect(this.framePosX + 5, this.framePosY + 5, this.frameWide - 10, 30, 25, 25);
        g.fillRect(this.framePosX + 5, this.framePosY + 25, this.frameWide - 10, 25);
        
        // Frame Header Title
        g.setFont(Game.getFont("FrameTitle"));
        g.setColor(Color.BLACK);
        g.drawString("Supernova Landscape Editor", this.framePosX + 25, this.framePosY + 35);
        
        // Frame Border Outline
        g.setColor(Color.BLACK);
        g.drawRoundRect(this.framePosX, this.framePosY, this.frameWide, this.frameHigh, 25, 25);
        g.drawRoundRect(this.framePosX + 5, this.framePosY + 5, this.frameWide - 10, this.frameHigh - 10, 25, 25);
        g.drawRect(this.framePosX + 5, this.framePosY + 50, this.frameWide - 10, 5);
        
        // Frame Border Fill
        g.setColor(Drawing.getColorRGB(104, 164, 38));
        g.fillRect(this.framePosX + 4, this.framePosY + 51, this.frameWide - 8, 3);
        
    }
    
    public void tick()
    {
        
    }
}