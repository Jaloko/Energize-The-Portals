package com.corybeams.energizetheportals.entities.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.corybeams.energizetheportals.entities.Entity;
import com.corybeams.energizetheportals.worlds.World;

public class Item extends Entity {
	
	public Item(float xPos, float yPos, int width, int height) {
		super(xPos, yPos, width, height);
	}
	
	public void update(World w) {
		super.update(w);
	}
	
	public void render(SpriteBatch sb) {
		
	}

}
