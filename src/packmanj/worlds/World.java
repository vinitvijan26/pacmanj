/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packmanj.worlds;

import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import packmanj.Handler;
import packmanj.tiles.Tile;
import packmanj.utils.Utils;

public class World {

    	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;   //not used, why?
	private int[][] tiles;
	
	public World(Handler handler, String path){
            try {
                this.handler = handler;
		loadWorld(path);
            } catch (IOException ex) {
                Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	
	public void tick(){  //nothing to update in the world class in every loop
		
	}
	
	public void render(Graphics g){
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				getTile(x, y).render(g, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);//displaying(render..)
                                //that tile(getTile..) at that position on the canvas
                                //the render of Tile is called, x*T.., y*T.. are the coordinates of the tile passed
			}
		}
	}
	
	public Tile getTile(int x, int y){
                if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.whitetile;   //taking precautions
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.blacktile;
		return t;
	}
	
	private void loadWorld(String path) throws IOException{
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);   //we might need some other token for the enemy(maybe)
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]); //coz previous 4 tokens are assigned
                                //but tiles[][] is another array that we'll use for the position of the tiles
			}
		}
	}
	
}
