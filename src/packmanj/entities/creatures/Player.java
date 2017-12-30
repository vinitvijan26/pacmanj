/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packmanj.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import packmanj.Game;
import packmanj.Handler;
import packmanj.gfx.Animation;
import packmanj.gfx.Assets;
//import packmanj.input;


public class Player extends Creature {

	//private Game game;
        //Animations
        
	private Animation animDown, animUp, animLeft, animRight;
	public Game game;
	
        static float xp,yp;
        
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
                //the x,y input from GameState are then sent to creature, as, super is used and player extends creature
		//this.handler = handler; <- not here but in entity
                //we pass the handler and hence handler entity holds the same handler(sort of synchronization done bcoz
                //we have written our classes seperately but have to connect them ultimately)
                //super - pass value to superclass
                xp=x;
                yp=y;
                bounds.x = 3;
		bounds.y = 3;
		bounds.width = 44;
		bounds.height = 44;  //3 and 44 are done for the size of the rectangle for collisions
                
                //Animatons
		animDown = new Animation(500, Assets.player_down);  //the type of player_up, down,.. is BufferedImage[](refer assets for more)
                //500 is the speed
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
	
	}

	@Override
	public void tick() {  //first, animations are updated, then, i/p is taken and the parameters(yMove,..) to
            //be changed as per the i/p are updated(using getInput()), then move is called (definition is in creature)
            //and the collisions are taken care of over there using the Tiles and diff classes in it
            //Animations
		animLeft.tick();    //did without understanding animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		//Movement

                xp=x;
                yp=y;
		getInput();  //see the function definition below
		move();      //updating the coordinates to be changed after keyboard input
                printcoord();
                checkcoord();
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, width, height, null);
                //width - DEFAULT_CREATURE_WIDTH
                //System.out.println(x+","+y+"are the coordinates"+width);
	}
        
        private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animRight.getCurrentFrame();
		}else if(yMove < 0){
			return animUp.getCurrentFrame();
		}else{
			return animDown.getCurrentFrame();
		}
	}

}