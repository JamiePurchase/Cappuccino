package web;

import engine.Game;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Web
{
    
    public static String request(String request) throws Exception
    {
        // Create a web request
        URL webHttp = new URL("http://cappucino.co.nf/" + request);
        BufferedReader webRead = new BufferedReader(new InputStreamReader(webHttp.openStream()));
        Game.debugOutput("WEB REQUEST: " + "http://cappucino.co.nf/" + request);
        
        // Compile the data into a string
        String webData = "";
        String webLine;
        int webRows = 0;
        while((webLine = webRead.readLine()) != null)
        {
            Game.debugOutput(webLine);
            webData = webData + webLine;
            webRows += 1;
        }
        
        // Close the stream
        webRead.close();
        Game.debugOutput("Completed.");
        return webData;
    }
    
    public static String[] requestArray(String request)
    {
        String webData = "";
        try
        {
            webData = request(request);
        }
        catch (Exception ex)
        {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
        }
        return webData.split("\\|");
    }
}