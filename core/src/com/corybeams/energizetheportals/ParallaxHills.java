package com.corybeams.energizetheportals;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.corybeams.energizetheportals.entities.mobs.Player;
import com.corybeams.energizetheportals.utilities.Global;
import com.corybeams.energizetheportals.utilities.Textures;

public class ParallaxHills {
	
	Player player;
	
	public ParallaxHills(Player player) {
		this.player = player;
	}
	
	public void render(SpriteBatch sb) {
		float xOffset = player.position.x / 5f;
		float xOffset2 = player.position.x / 2f;
		float xOffset3 = player.position.x / 1f;
		
		Random random = new Random();
		int rand;
		
		sb.draw(Textures.STARS, player.position.x - Global.WIDTH / 2, player.position.y - Global.HEIGHT / 2, 0, 0, Global.WIDTH, Global.HEIGHT);
		
		for(int i = 0; i < 150; i++) {
			//if(0 - xOffset + 300 * i >= player.position.x - Global.WIDTH  && 0 - xOffset + 300 * i <= player.position.x + Global.WIDTH) {
				sb.draw(Textures.HILL3, 0 - xOffset + 300 * i, 800, 500, 500);
			//}
		}
		
		for(int i = 0; i < 150; i++) {
			//if(0 - xOffset + 300 * i >= player.position.x - Global.WIDTH && 0 - xOffset + 300 * i <= player.position.x + Global.WIDTH) {
				sb.draw(Textures.HILL2, 0 - xOffset2 + 400 * i, 700, 500, 500);
			//}
		}
		
		for(int i = 0; i < 150; i++) {
			//if(0 - xOffset + 300 * i >= player.position.x - Global.WIDTH && 0 - xOffset + 300 * i <= player.position.x + Global.WIDTH) {
				sb.draw(Textures.HILL1, 0 - xOffset3 + 450 * i, 500, 500, 600);
			//}
		}
		
		for(int i = 0; i < 150; i++) {
			//if(0 - xOffset + 300 * i >= player.position.x - Global.WIDTH && 0 - xOffset + 300 * i <= player.position.x + Global.WIDTH) {
				sb.draw(Textures.HILLS_FILLER, 0 - xOffset3 + 450 * i, 0, 512, 512);
			//}
		}

	}

}
