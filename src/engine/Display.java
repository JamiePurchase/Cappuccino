package engine;

import input.InputKeyboard;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display
{
	private JFrame frame;
        private JPanel panel;
	private Canvas canvas;
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		createDisplay();
                this.panel.requestFocus();
	}
	
	private void createDisplay()
	{
		// Create the frame
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		// Create a JPanel
		panel = new JPanel();
		panel.addKeyListener(Game.getInputKeyboard());
		frame.add(panel);
		panel.requestFocusInWindow();
		
		// Create the canvas
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.addMouseListener(Game.getInputMouse());
		canvas.addMouseMotionListener(Game.getInputMouse());
		
		// Add the canvas to the frame
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
}