package packmanj.gfx;

import java.awt.image.BufferedImage;


public class Assets {
    private static final int width = 50, height = 50;
	
	public static BufferedImage whitetile, blacktile, enemyicon, enemyicon2;

        public static BufferedImage[] player_down, player_up, player_left, player_right;

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/spritesheet.png"));
		
                player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		
		player_down[0] = sheet.crop(width * 6, 0, width, height);
		player_down[1] = sheet.crop(width * 7, 0, width, height);
		player_up[0] = sheet.crop(width * 2, 0, width, height);
		player_up[1] = sheet.crop(width * 3, 0, width, height);
		player_right[0] = sheet.crop(0, 0, width, height);
		player_right[1] = sheet.crop(width , 0, width, height);
		player_left[0] = sheet.crop(width * 4, 0, width, height);
		player_left[1] = sheet.crop(width * 5, 0, width, height);
		
		whitetile = sheet.crop(width*9, 0, width, height);
		blacktile = sheet.crop(width *8, 0, width, height);
                
                enemyicon = sheet.crop(width*10, 0, width, height);
                enemyicon2 = sheet.crop(0, height, width, height);
	}
	
}
