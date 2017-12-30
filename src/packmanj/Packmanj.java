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
public class Packmanj {   //launcher class - just to start our game
//since for multithreading we have seperate class for carrying main method
    public static void main(String[] args) {
        Game game = new Game("My Pacman!", 1280, 768);   //parameters are sent to Display class, Game class is in same package,
        //hence we can create it's object in Packmanj class
	game.start();
    }
    
}
