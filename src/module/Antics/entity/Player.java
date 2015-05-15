package module.Antics.entity;

import graphics.Drawing;
import graphics.Tileset;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import module.Antics.board.Board;

public class Player
{
    // Anim
    private Tileset animTileset;
    private String animStance;
    private boolean animBusy;
    private int animTick;
    private int animFrame;
    private int animWalk;
    
    // Board
    private Board boardObject;
    private int boardPosX;
    private int boardPosY;
    private String boardFace;
    
    public Player(Board board, int posX, int posY, String face)
    {
        this.animTileset = new Tileset(Drawing.getImage("spritesheet/player01.png", "Antics"), 32, 32, 3, 4);
        this.animStance = "IDLE";
        this.animBusy = false;
        this.animTick = 0;
        this.animFrame = 1;
        
        this.boardObject = board;
        this.boardPosX = posX;
        this.boardPosY = posY;
        this.boardFace = face;
    }
    
    public boolean getAnimBusy()
    {
        return this.animBusy;
    }
    
    public BufferedImage getDrawImage()
    {
        int tileX = 2;
        int tileY = 1;
        if(this.animStance == "WALK")
        {
            if(animFrame == 2) {tileX = 1;}
            if(animFrame == 4) {tileX = 3;}
        }
        if(this.boardFace == "W") {tileY = 2;}
        if(this.boardFace == "E") {tileY = 3;}
        if(this.boardFace == "N") {tileY = 4;}
        return this.animTileset.getTileAt(tileX, tileY);
    }
    
    public int getDrawPosX()
    {
        int walkX = 0;
        if(this.animStance == "WALK" && this.boardFace == "E") {walkX = this.animWalk * 8;}
        if(this.animStance == "WALK" && this.boardFace == "W") {walkX = 0 - (this.animWalk * 8);}
        return (this.boardPosX * 32) + this.boardObject.getBoardDrawX() - (32 * this.boardObject.getBoardViewX()) + walkX;
    }
    
    public int getDrawPosY()
    {
        int walkY = 0;
        if(this.animStance == "WALK" && this.boardFace == "N") {walkY = 0 - (this.animWalk * 8);}
        if(this.animStance == "WALK" && this.boardFace == "S") {walkY = this.animWalk * 8;}
        return (this.boardPosY * 32) + this.boardObject.getBoardDrawY() - (32 * this.boardObject.getBoardViewY()) + walkY;
    }
    
    public void render(Graphics g)
    {
        g.drawImage(this.getDrawImage(), this.getDrawPosX(), this.getDrawPosY(), null);
    }
    
    public void setStanceIdle(String direction)
    {
        this.animStance = "IDLE";
        this.animBusy = false;
        this.animTick = 0;
        this.animFrame = 1;
        this.boardFace = direction;
    }
    
    public void setStanceWalk(String direction)
    {
        this.animStance = "WALK";
        this.animBusy = true;
        this.animTick = 0;
        this.animFrame = 1;
        this.animWalk = 0;
        this.boardFace = direction;
    }
    
    public void tick()
    {
        if(this.animStance == "WALK") {tickWalk();}
    }
    
    public void tickWalk()
    {
        this.animTick += 1;
        if(this.animTick > 12)
        {
            this.animTick = 0;
            this.animFrame += 1;
            this.animWalk += 1;
            if(this.animFrame > 4)
            {
                this.setStanceIdle(this.boardFace);
                if(this.boardFace == "N") {this.boardPosY -= 1;}
                if(this.boardFace == "S") {this.boardPosY += 1;}
                if(this.boardFace == "E") {this.boardPosX += 1;}
                if(this.boardFace == "W") {this.boardPosX -= 1;}
            }
        }
    }
}