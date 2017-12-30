/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packmanj.tiles;

import packmanj.gfx.Assets;

/**
 *
 * @author Vinit
 */
class BlackTile extends Tile {

    public BlackTile(int id) {
        super(Assets.blacktile, id);
    }
    
	public boolean isSolid(){
		return true;
	}

}
