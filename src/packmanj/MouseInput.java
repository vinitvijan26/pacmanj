/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packmanj;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static packmanj.Game.menuState;
import packmanj.states.State;

/**
 *
 * @author Vinit
 */
public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx=e.getX();
        int my=e.getY();
        
        if((mx>=Game.width/2+120) && (mx<=Game.width/2+220)){
            if(my>=150&&my<=200){
                State.setState(Game.gameState);
            }
        }
        
        if((mx>=Game.width/2+120) && (mx<=Game.width/2+220)){
            if(my>=350&&my<=400){
               System.exit(0);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
