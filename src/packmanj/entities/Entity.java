package packmanj.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import packmanj.Handler;

public abstract class Entity {

	protected Handler handler;
	protected float x, y;   //position of the player
	protected int width, height;
	protected Rectangle bounds;
	
	public Entity(Handler handler, float x, float y,int width, int height){
		this.handler = handler;
		this.x = x;
		this.y = y;
		//this.x2 = x2;
		//this.y2 = y2;
		this.width = width;
		this.height = height;
                bounds = new Rectangle(0, 0, width, height);   //doubtful about 0,0, should be x,y maybe
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}