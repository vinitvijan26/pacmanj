
package packmanj.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import static java.lang.System.gc;
import javax.swing.ImageIcon;
import packmanj.Game;
import packmanj.Handler;

public class MenuState extends State {
        
        Image background = new ImageIcon("/res/background2.png").getImage();
//public String mouse = "No input yet";
        
        public Rectangle playbutton = new Rectangle(Game.width/2,150,100,50);
        public Rectangle quitbutton = new Rectangle(Game.width/2,250,100,50);
        //public Rectangle helpbutton = new Rectangle(Game.width/2+100,150,00,50);
        
	public MenuState(Handler handler){
		super(handler);
                
        }

	@Override
	public void tick() {
                
		}

	@Override
	public void render(Graphics g) {
                g.drawImage(background,0,0,null);
                Graphics2D g2d = (Graphics2D) g;
            
		Font fnt0 = new Font("arial",Font.BOLD,50);
                g.setFont(fnt0);
                g.setColor(Color.blue);
                g.drawString("PACMAN",Game.width/2,100);
                
                Font fnt1 = new Font("arial",Font.BOLD,30);
                g.setFont(fnt1);
                g.drawString("Play",playbutton.x+19,playbutton.y+30);
                g2d.draw(playbutton);
                g.drawString("Quit",quitbutton.x+19,playbutton.y+30);
                g2d.draw(quitbutton);
	}
	
}