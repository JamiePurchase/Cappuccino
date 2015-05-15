package module.Minstrel.state;

import engine.Game;
import file.FileManager;
import graphics.Drawing;
import graphics.Fonts;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import module.Dashboard.module.ModuleDashboard;
import state.State;
import module.Dashboard.state.StateDashboard;

public class StateMain extends State
{

    public StateMain()
    {
        // Audio
        //Game.audio.playMusic("music1");
    }
    
    public void fileOpen()
    {
        final JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("C:/Users/Jamie/My Music"));
        /*FileFilter type1 = new ExtensionFilter("MP3 files", ".mp3");
        FileFilter type2 = new ExtensionFilter("Wave files", ".wav");
        fc.addChoosableFileFilter(type1);
        fc.addChoosableFileFilter(type2);
        fc.setFileFilter(type1);*/
        //FileView view = new IconView();
        //fc.setFileView(view);
        //In response to a button click:
        int returnVal = fc.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            //Editor.appModules.returnReferenceDone();
            File selectedFile = fc.getSelectedFile();
            String selectedFilePath = selectedFile.getAbsolutePath();
            System.out.println("Selected file: " + selectedFilePath);
            String selectedFileExt = FileManager.getFileExtension(selectedFile);
            if(selectedFileExt.equals("mp3") || selectedFileExt.equals("wav"))
            {
                // PLAY MUSIC
                System.out.println("Correct filetype (" + selectedFileExt + ")");
                // play media
            }
            else
            {
                // RETRY? QUIT?
                System.out.println("Incorrect filetype (" + selectedFileExt + ")");
            }
        }
        if(returnVal == JFileChooser.CANCEL_OPTION)
        {
            System.exit(1);
        }
    }

    public void render(Graphics g)
    {
        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1366, 768);
        
        // Logo
        //g.drawImage(Drawing.getImage("interface/logo.png", "SteelSkirmish"), 396, 50, null);
        
        // Title
        g.setFont(Game.getFont("MinstrelTitle"));
        g.setColor(Color.WHITE);
        g.drawString("Minstrel", 500, 50);
        
        // Options
        g.setFont(Game.getFont("Standard"));
        g.setColor(Color.WHITE);
        g.drawString("Press the spacebar to load", 500, 500);
    }

    public void tick()
    {
        tickKey();
        tickMouse();
    }

    public void tickKey()
    {
        if(Game.getInputKeyboard().getKeyPressed() == "Space")
        {
            System.out.println("Space was pressed...");
            Game.getInputKeyboard().keyPressedDone();
            fileOpen();
        }
        if(Game.getInputKeyboard().getKeyPressed() == "Escape")
        {
            Game.getInputKeyboard().keyPressedDone();
            Game.setModule(new ModuleDashboard());
        }
    }
    
    public void tickMouse()
    {
        if(Game.getInputMouse().mouseActionPressedL == true)
        {
            Game.getInputMouse().mouseActionDone();
            Game.setModule(new ModuleDashboard());
        }
    }
}