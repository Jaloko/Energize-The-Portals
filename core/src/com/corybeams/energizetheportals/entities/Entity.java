package com.corybeams.energizetheportals.entities;

import com.badlogic.gdx.math.Vector2;
import com.corybeams.energizetheportals.utilities.Types;
import com.corybeams.energizetheportals.worlds.World;

public class Entity {
	
	public Vector2 position;
	public int width;
	public int height;
	float gravityCounter = 1;
	public boolean gravityEnabled = true;
	
	
	public Entity(float xPos, float yPos, int width, int height) {
		this.position = new Vector2(xPos, yPos);
		this.width = width;
		this.height = height;		
	}
	
	public void update(World w) {
		if(collision(w) != 0) {
			if(gravityEnabled) {
				position.y -= 0.981f * gravityCounter;
				gravityCounter+= 0.5f;
			}
		} else {
			gravityCounter = 1;
		}
	}
	
	
	
	protected int collision(World w) {
		for(int x = 0; x < w.width; x++) {
			for(int y = 0; y < w.height; y++) {
				if(w.tiles[x][y] == Types.GRASS || w.tiles[x][y] == Types.DIRT || w.tiles[x][y] == Types.STONE_FLOOR || w.tiles[x][y] == Types.STONE) {
					if(position.y <= y * w.tileSize + w.tileSize) {
						if(position.x >= x * w.tileSize && position.x <= x * w.tileSize + w.tileSize) {
							position.y += ((y * w.tileSize) + w.tileSize - position.y);
							//DOWN
							return 0;
						}
					} 
					
				}

			}
		}
		
		return 1;
	}
	

}
