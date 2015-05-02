package engine;

import audio.AudioManager;
import graphics.Drawing;
import graphics.Fonts;
import input.InputKeyboard;
import input.InputMouse;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JPanel;
import module.Module;
import module.ModuleDashboard;
import network.Account;

public class Game extends JPanel implements Runnable
{
	private static final long serialVersionUID = 1L;
	public static Display display;
	public String title;
	public int width, height;
	private Thread thread;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
        private static InputKeyboard inputKeyboard;
        private static InputMouse inputMouse;
	public static AudioManager audio;
        private static boolean accountActive;
        private static Account accountObject;
        private static Module module;
        private static boolean modulePaused;
        private static boolean homeMenuActive;
        private static Debug systemDebug;

	public Game()
	{
            // Main Settings
            this.title = "Cappuccino";
            this.width = 1366;
            this.height = 768;
            
            // Input Devices
            this.inputKeyboard = new InputKeyboard();
            this.inputMouse = new InputMouse();
            
            // Debug Manager
            systemDebug = new Debug(false);
            
            // Account Details
            setAccount(1);
	}
	
	private void init()
	{            
            // Create Display
            display = new Display(title, width, height);

            // Module
            setModule(new ModuleDashboard());
            setModulePaused(false);
            setHomeMenuActive(false);

            // Audio
            audio = new AudioManager();
	}
	
        public static void debugSetEnabled(boolean value)
        {
            systemDebug.setActive(value);
        }
        
        public static void debugOutput(String data)
        {
            systemDebug.output(data);
        }
        
        public static boolean getAccountActive()
        {
            return accountActive;
        }
        
        public static Account getAccountObject()
        {
            return accountObject;
        }
        
        public static boolean getHomeMenuActive()
        {
            return homeMenuActive;
        }
        
        public static InputKeyboard getInputKeyboard()
        {
            return inputKeyboard;
        }
        
        public static InputMouse getInputMouse()
        {
            return inputMouse;
        }
        
        public static Module getModule()
        {
            return module;
        }
        
        public static boolean getModulePaused()
        {
            return modulePaused;
        }
	
	private void render()
	{
		// Buffer strategy
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
                    display.getCanvas().createBufferStrategy(3);
                    return;
		}
		
		// Graphics start
		g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
		// Graphics draw
		if(this.getModule() != null)
		{
                    this.getModule().render(g);
		}
                
                // Home Menu
                if(getHomeMenuActive()) {renderHomeMenu(g);}

		// Graphics done
		bs.show();
		g.dispose();
	}
        
        public void renderHomeMenu(Graphics g)
        {
            // Fade Module
            Drawing.fadeScreen(g);

            // Menu Frame
            g.drawImage(Drawing.getImage("system/frame700x300.png"), 333, 234, null);

            // Menu Options
            g.setFont(Fonts.getFont("standard"));
            g.setColor(Color.BLACK);
            g.drawString("Dashboard", 458, 259);
        }
	
	public void run()
	{
		// Render speed
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		// Create window
		init();
		
		// Main game loop
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1)
			{			
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000)
			{
				//System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		// End game
		stop();
	}
        
        public static void setAccount(int id)
        {
            if(id == 0)
            {
                // Clear account object?
                accountActive = false;
            }
            else
            {
                accountObject = new Account(id);
                accountActive = true;
            }
        }
        
        public static void setHomeMenuActive(boolean value)
        {
            homeMenuActive = value;
        }
        
        public static void setModule(Module newModule)
        {
            module = newModule;
        }
        
        public static void setModulePaused(boolean value)
        {
            modulePaused = value;
        }
        
	public synchronized void start()
	{
		if(running==false)
		{
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public synchronized void stop()
	{
		if(running==true)
		{
			try
			{
				thread.join();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void tick()
	{
            // Home Menu
            if(this.getHomeMenuActive()) {tickHome();}
            else
            {
                // System Key Listener
                tickRun();
                
                // Audio
                audio.tick();
                
                // Module
                if(this.getModulePaused() == false)
                {
                    this.getModule().tick();
                }
            }
	}
        
        private void tickHome()
        {
            if(getInputKeyboard().getKeyPressed() == "Home")
            {
                getInputKeyboard().keyPressedDone();
                this.setModulePaused(false);
                this.setHomeMenuActive(false);
            }
        }
        
        private void tickRun()
        {
            if(getInputKeyboard().getKeyPressed() == "Home")
            {
                InputKeyboard.keyPressedDone();
                this.setModulePaused(true);
                this.setHomeMenuActive(true);
            }
        }
}