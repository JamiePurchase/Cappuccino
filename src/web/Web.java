package web;

import engine.Game;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Web
{
    
    public static void call(String url) throws Exception
    {
        URL webHttp = new URL("http://cappuccino-network.co.nf/" + url);
        BufferedReader webRead = new BufferedReader(new InputStreamReader(webHttp.openStream()));
        Game.debugOutput("WEB REQUEST: " + "http://cappuccino-network.co.nf/" + url);
    }
    
    public static void post(String url, String parameters) throws MalformedURLException, IOException
    {
        //String urlParameters = "param1=a&param2=b&param3=c";
        byte[] postData = parameters.getBytes(Charset.forName("UTF-8"));
        int postDataLength = postData.length;
        URL urlObject = new URL("http://cappuccino-network.co.nf/" + url);
        HttpURLConnection cox = (HttpURLConnection) urlObject.openConnection();           
        cox.setDoOutput(true);
        cox.setDoInput(true);
        cox.setInstanceFollowRedirects(false);
        cox.setRequestMethod("POST");
        cox.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
        cox.setRequestProperty("charset", "utf-8");
        cox.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        cox.setUseCaches(false);
        try(DataOutputStream wr = new DataOutputStream(cox.getOutputStream()))
        {
            wr.write(postData);
        }
    }
   
    public static String request(String url) throws Exception
    {
        // Create a web request
        URL webHttp = new URL("http://cappuccino-network.co.nf/" + url);
        BufferedReader webRead = new BufferedReader(new InputStreamReader(webHttp.openStream()));
        Game.debugOutput("WEB REQUEST: " + "http://cappuccino-network.co.nf/" + url);
        
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
    
    public static String[] requestArray(String url)
    {
        String webData = "";
        try
        {
            webData = request(url);
        }
        catch (Exception ex)
        {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
        }
        return webData.split("\\|");
    }
    
    /*public static void upload() throws Exception
    {
        String userHome=System.getProperty("user.home");
        HttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        HttpPost httppost = new HttpPost("http://www.xxx.xxxx.xxx/Projects/test/upload.php");
        File file = new File(userHome+"/Hello.txt");
        MultipartEntity mpEntity = new MultipartEntity();
        ContentBody contentFile = new FileBody(file);
        mpEntity.addPart("userfile", contentFile);
        httppost.setEntity(mpEntity);
        System.out.println("executing request " + httppost.getRequestLine());
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity resEntity = response.getEntity(); 
 
        if(!(response.getStatusLine().toString()).equals("HTTP/1.1 200 OK")){
            // Successfully Uploaded
        }
        else{
            // Did not upload. Add your logic here. Maybe you want to retry.
        }
        System.out.println(response.getStatusLine());
        if (resEntity != null) {
            System.out.println(EntityUtils.toString(resEntity));
        }
        if (resEntity != null) {
            resEntity.consumeContent();
        }
        httpclient.getConnectionManager().shutdown();
    }*/
}