/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packmanj.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class ImageLoader {    //loads images
    // public static BufferedImage loadImage(String path){      //java stores image in the BufferedImage object
		
	//}

    public static BufferedImage LoadImage(String path) {      //return-type -> Buffered image
        try {                                                              //path is the 'path' of the image
        return ImageIO.read(ImageLoader.class.getResource(path));     //importing stuff
        } catch (IOException ex) {
            Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        
		return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
