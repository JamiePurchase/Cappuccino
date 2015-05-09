package module.SteelSkirmish.network;

import web.Web;

public class Game
{
    private int gameID;
    private int player1AccountID;
    private int player2AccountID;
    
    public Game(int gameID, int player1, int player2)
    {
        this.gameID = gameID;
        this.player1AccountID = player1;
        this.player2AccountID = player2;
    }
    
    public int getGameID()
    {
        return this.gameID;
    }
    
    public int getPlayer1AccountID()
    {
        return this.player1AccountID;
    }
    
    public int getPlayer2AccountID()
    {
        return this.player2AccountID;
    }
    
    public void networkFetch()
    {
        // Web Request
        String myData[] = Web.requestArray("remote.php?module=GAM-SKIRMISH&action=getGame&gameID=" + this.gameID);
        
        // Details
        //this.something = myData[1];
    }
}