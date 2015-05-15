package module;

import application.Functions;
import engine.Game;
import file.FileRead;
import file.FileWrite;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.Antics.module.ModuleAntics;
import module.Dashboard.ui.AppTile;
import module.Dashboard.state.StateDashboard;
import module.SteelSkirmish.module.ModuleSteelSkirmish;
import web.Web;

public class Registry
{
    private String[] moduleID;
    private int[] moduleVersion;
    private static String REGISTRY_PATH;
    
    // NOTE: make full use of the unique module IDs
    
    public Registry()
    {
        this.REGISTRY_PATH = "SYS-HOMEDASH/registry.froth";
        //this.frothLoad();
        
        // Test Version Check
        //this.networkUpdate();
        
        // NOTE: The registry should look like this when the app is first installed
        /*this.moduleID = new String[2];
        this.moduleID[0] = "SYS-HOMEDASH";
        this.moduleID[1] = "GAM-SKIRMISH";
        this.moduleVersion = new int[2];
        this.moduleVersion[0] = 1;
        this.moduleVersion[1] = 1;
        this.frothSave();*/
    }
    
    public void frothLoad()
    {
        FileRead fileReader = new FileRead(this.REGISTRY_PATH);
        String[] fileResult;
        try
        {
            // Get registered modules from froth file
            fileResult = fileReader.FileReadData();
            
            // Define new blank arrays for module data
            this.moduleID = new String[fileResult.length];
            this.moduleVersion = new int[fileResult.length];
            
            // Split apart the data for each module
            for(int x = 0; x < fileResult.length; x++)
            {
                String[] fileResultData = fileResult[x].split("\\|");
                this.moduleID[x] = fileResultData[0];
                this.moduleVersion[x] = Integer.parseInt(fileResultData[1]);
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(Registry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void frothSave()
    {
        // Compress all of the data for each module into one line
        String[] fileSubmit = new String[this.moduleID.length + 1];
        fileSubmit[0] = "!! Module Registry";
        for(int x = 0; x < this.moduleID.length; x++)
        {
            fileSubmit[x+1] = this.moduleID[x] + "|" + this.moduleVersion[x];
        }
        
        // Write the data to the froth file
        String fileEnd = "!! End of file - " + Functions.getTimestamp();
        FileWrite fileWriter = new FileWrite(this.REGISTRY_PATH, false);
        fileWriter.FileWriteArray((String[]) Functions.arrayAppend(fileSubmit, fileEnd));
    }
    
    public ModuleStub[] getModules()
    {        
        // Get list of apps from local data
        String[] fileData = new String[50];
        FileRead fr = new FileRead("modules.froth");
        try
        {
            fileData = fr.FileReadData();
        }
        catch (IOException ex) {Logger.getLogger(StateDashboard.class.getName()).log(Level.SEVERE, null, ex);}
        
        // return appCount;
        int appCount = fileData.length;
        ModuleStub[] moduleStub = new ModuleStub[appCount];
        
        // Store data about the apps
        for(int x = 0; x < appCount; x++)
        {
            moduleStub[x] = new ModuleStub(fileData[x].split("\\|"));
        }
        
        // Return the array of module stubs
        return moduleStub;
    }
    
    public String[] networkUpdate()
    {
        // Debug
        System.out.println("Module Version Check");
        
        // Temp
        int updateCount = 0;

        String[] updateRequired = new String[this.moduleID.length];
        for(int x = 0; x < this.moduleID.length; x++)
        {
            // Debug
            System.out.print("#" + x + ": " + this.moduleID[x] + " - local version: " + this.moduleVersion[x]);
        
            String myData[] = Web.requestArray("remote.php?module=SYSTEM&action=getModule&moduleID=" + this.moduleID[x]);
            
            // Debug
            System.out.println(" - online version: " + Integer.parseInt(myData[4]));

            if(Integer.parseInt(myData[4]) != this.moduleVersion[x])
            {
                updateRequired[updateRequired.length] = this.moduleID[x];
                
                // Temp
                updateCount += 1;
            }
        }
            
        // Debug
        System.out.println("Modules that require updating: " + updateCount);
        // NOTE: The int count works but the length of the updateRequired array is always this.moduleID.length
            
        return updateRequired;
    }
}