package network;

import java.sql.Timestamp;
import web.Web;

public class Account
{
    private int accountID;
    private String username;
    private String password;
    private Timestamp online;
    private boolean avatar;
    private int[] friends;
    
    public Account(int accountID)
    {
        this.accountID = accountID;
        networkFetch();
    }
    
    public int getAccountID()
    {
        return accountID;
    }
    
    public boolean getAvatar()
    {
        return avatar;
    }
    
    public int[] getFriends()
    {
        return friends;
    }
    
    public Timestamp getOnline()
    {
        return online;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void networkFetch()
    {
        // Web Request
        String myData[] = Web.requestArray("account/details.php?accountID=1");
        
        // Details
        this.username = myData[1];
        this.password = myData[2];
        //this.online = myData[3];
        //this.avatar = myData[4];
        
        // Friends
        int friendCount = Integer.parseInt(myData[5]);
        int[] friendArray = new int[friendCount];
        for(int friend = 0; friend < friendCount; friend++)
        {
            int position = friend + 6;
            friendArray[friend] = Integer.parseInt(myData[position]);
        }
        this.friends = friendArray;
    }
    
    public void networkStore()
    {
        // http call to the server
        // set the current activity
        // set the online value to now
        // return the online timestamp
        // this.online = 
    }
}