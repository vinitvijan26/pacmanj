/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packmanj;

/**
 *
 * @author Vinit
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;   //to fill in the color in our graphics eg.-setColor()
import java.awt.Graphics;
import java.awt.Image;
//import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import packmanj.display.Display;
import packmanj.gfx.*;
import packmanj.input.KeyManager;
import packmanj.states.GameState;
import packmanj.states.MenuState;
import packmanj.states.State;

public class Game implements Runnable {    //read the notes for this method of multithreading first

	private Display display;    //(this is another method where we just create an object and initialize it later)
        BufferedImage img;
	public static int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;    //for buffers
	private Graphics g;           //for graphics, the graphics object
        
        public MouseInput mouseinput;
        
	//States
	public static State gameState;
	public static State menuState;
	
        //Input
	private KeyManager keyManager;
	
        private Handler handler;
	
	public Game(String title, int width, int height){   //constructor for class game
		this.width = width;
		this.height = height;
		this.title = title;
                keyManager = new KeyManager();
            }
	
	public void init(){     //to initialize all the graphics of our game
		display = new Display(title, width, height);    //would have made no diff if it would have been called in the Game constructor
                display.getFrame().addKeyListener(keyManager);   //to add keymanager to  the display, maybe
		Assets.init();
		handler = new Handler(this);
		display.getFrame().addMouseListener(new MouseInput());
                menuState = new MenuState(handler);
		gameState = new GameState(handler);  //from here we initialise World and Player class
		
                State.setState(menuState);
		//State.setState(gameState);     //not done for the menuState yet, do we even do that?
	}
	
	private void tick(){      //update the variables, graphics
                keyManager.tick();
		    
                if(State.getState() != null)
			State.getState().tick();   //GameState's tick for now

        }
	
	private void render(){     //display part of the 'game loop'
             
               
		bs = display.getCanvas().getBufferStrategy();     //to avoid flickering
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);    //3 is max no. of buffers
			return;
		}
		g = bs.getDrawGraphics();       //graphics
                //so from now on, we dont use Display to display our graphics but the 
                //BufferStrategy -> Graphics take care of displaying
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
	        if(State.getState() != null)
                        State.getState().render(g);  //the same graphics object is passed to every smaller branch
                            //first we want the render of the world, then the player
		
		//End Drawing!
		bs.show();      //shows
		g.dispose();    //
	}
	
	public void run(){
		
		init();              //to initialize all the graphics of our game
		
                int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
                while(running){      //while - for the GAME LOOP - 1.Update all the variables(tick) 2.display them(render)
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();    //
				render();  //
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);   //can check if this is causing
                                //some errors by seeing the o/p
				ticks = 0;
				timer = 0;
			}
		}
		stop();
		
	}
        public KeyManager getKeyManager(){
		return keyManager;
	}
	
        public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public synchronized void start(){      //synchronized - one thread at a time
		if(running)       //if the start method gets called again while running ACCIDENTALLLY, then it will return and not execute the rest of the start and if false then...
			return;
		running = true;
		thread = new Thread(this);     //implementing Runnable method
		thread.start();                //calls run()
	}
	
	public synchronized void stop(){
		if(!running)      //if called accidentally in between...
			return;
		running = false;
            try {
                thread.join();
                } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

    /*public Object getKeyManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
	
}

