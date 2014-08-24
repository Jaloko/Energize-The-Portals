package com.corybeams.energizetheportals.entities.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.corybeams.energizetheportals.utilities.Textures;
import com.corybeams.energizetheportals.worlds.World;

public class EnergyCell extends Item {
	
	private TextureRegion texture;
	
	public EnergyCell(float xPos, float yPos, int width, int height) {
		super(xPos, yPos, width, height);
		texture = Textures.ENERGY_CELL;
	}
	
	public void update(World w) {
		super.update(w);
	}
	
	public void render(SpriteBatch sb) {
		sb.draw(texture, position.x, position.y, width, height);
	}

}
