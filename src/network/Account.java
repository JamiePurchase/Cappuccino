package network;

import engine.Game;
import java.sql.Timestamp;
import web.Web;

public class Account
{
    private int accountID;
    private String username;
    private String password;
    private Timestamp online;
    private String module;
    private boolean avatar;
    private int[] friends;
    
    public Account(int accountID)
    {
        this.accountID = accountID;
        networkFetch();
    }
    
    public int getAccountID()
    {
        return this.accountID;
    }
    
    public boolean getAvatar()
    {
        return this.avatar;
    }
    
    public int[] getFriends()
    {
        return this.friends;
    }
    
    public String getModule()
    {
        return this.module;
    }
    
    public Timestamp getOnline()
    {
        return this.online;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public void networkFetch()
    {
        // Web Request
        String myData[] = Web.requestArray("remote.php?module=SYSTEM&action=getAccount&accountID=" + this.accountID);
        
        // Debug
        System.out.println(myData[0]);
        System.out.println(myData[1]);
        System.out.println(myData[2]);
        System.out.println(myData[3]);
        System.out.println(myData[4]);
        System.out.println(myData[5]);
        
        // Details
        this.username = myData[1];
        this.password = myData[2];
        //this.online = myData[3];
        this.module = myData[4];
        //this.avatar = myData[5];
        
        // Friends
        /*int friendCount = Integer.parseInt(myData[6]);
        int[] friendArray = new int[friendCount];
        for(int friend = 0; friend < friendCount; friend++)
        {
            int position = friend + 7;
            friendArray[friend] = Integer.parseInt(myData[position]);
        }
        this.friends = friendArray;*/
    }
    
    public void networkStore()
    {
        // http call to the server
        // set the current activity
        // set the online value to now
        // return the online timestamp
        // this.online = 
    }
    
    public void networkUpdate() throws Exception
    {
        // Update the online timestamp and moduleID activity tracker
        Web.request("remote.php?module=SYSTEM&action=updateAccount&accountID=" + this.getAccountID() + "&moduleID=" + Game.getModuleID());
        
        // Collect data regarding games, friends, messages and updates
        
        /*if()
        {
            Game.getInputKeyboard().keyPressedDone();
            Game.notificationCreate("Another player is online", 250);
        }*/
    }
}