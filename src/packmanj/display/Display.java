package packmanj.display;


import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	private JFrame frame;    //to make our window
	private Canvas canvas;   //to display the graphics on the window
	
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();    //it's done to initialize Jframe and canvas
	}
	
	private void createDisplay(){  
		frame = new JFrame(title);   
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);   //window will pop up at the centre of the screen
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));   //makes sure our canvas stays at that size
		canvas.setMinimumSize(new Dimension(width, height));   //"
		canvas.setFocusable(false);      //no idea - he didnt explain
                
		frame.add(canvas);    //adding canvas to jframe
		frame.pack();
	}

	public Canvas getCanvas(){     //OR we can just make make the object public
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	
	
	
}