
package packmanj.states;

import java.awt.Graphics;
import packmanj.Game;
import packmanj.Handler;
import packmanj.entities.creatures.Enemy;
import packmanj.entities.creatures.Player;
import packmanj.worlds.World;

public class GameState extends State {
	
	private Player player;
	private World world;
        private Enemy enemy;
	
	public GameState(Handler handler){  //initializing the world and the player
		super(handler);
                world = new World(handler, "res/worlds/world.txt");  //passing handler to create the handler instant in the other
                //classes like world and player because we need to access the Handler class and hence the Game class
                //from the states
                handler.setWorld(world);   //sends the world object created above and hence creates the same instance 
                //of the world class in the handler class  (it sets the world in the handler class)
		player = new Player(handler, 50, 50);  //50,50 - spawn and not the width and ht
		enemy=new Enemy(handler, 450,50);
                
	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
                enemy.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);   //order is important
		player.render(g);
                enemy.render(g);
	}

}