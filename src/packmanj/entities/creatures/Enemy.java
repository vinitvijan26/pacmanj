/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packmanj.entities.creatures;

import java.awt.Graphics;
import packmanj.Game;
import packmanj.Handler;
import packmanj.gfx.Assets;

/**
 *
 * @author Vinit
 */
public class Enemy extends Creature {
    
    public static float xe, ye,x2=450,y2=50;
    
    public Game game;
    public static int flag1 = 0,flag2=0;
    public Enemy(Handler handler, float x, float y){
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        
        xe=x;
        ye=y;
    }
    
    public void tick(){
        
        xe=x;
        ye=y;

        
      if(flag1==0){
                    x+=speed*1.5;
                    if((int)x>850)
                        flag1=1;
                }
                else {
                    x-=speed*1.5;
                    if((int)x<50)
                        flag1=0;
                }
                if(flag2==0){
                    y2+=speed*1.5;
                    if((int)y2>650)
                        flag2=1;
                }
                else{
                    y2-=speed*1.5;
                    if((int)y2<54)
                        flag2=0;
                }
      printcoord();
      checkcoord();
	}
    
    public void render(Graphics g){
        g.drawImage(Assets.enemyicon, (int) x, (int) y, null);
        g.drawImage(Assets.enemyicon2, (int) x2, (int) y2, null);
    }
}
