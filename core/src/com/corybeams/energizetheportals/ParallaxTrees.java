package com.corybeams.energizetheportals;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.corybeams.energizetheportals.entities.mobs.Player;
import com.corybeams.energizetheportals.utilities.Global;
import com.corybeams.energizetheportals.utilities.Textures;

public class ParallaxTrees {
	
	Player player;
	boolean hasPlayer;
	
	int pos = 0;
	
	int[] treePos;
	
	public ParallaxTrees() {
		hasPlayer = false;
		treePos = new int[15];
	}
	
	public ParallaxTrees(Player player) {
		super();
		this.player = player;
		hasPlayer = true;
		treePos = new int[15];
	}
	
	public void render(SpriteBatch sb) {
		float xOffset = 0;
		float xOffset2 = 0;
		float xOffset3 = 0;
		if(hasPlayer) {
			xOffset = player.position.x / 5f;
			xOffset2 = player.position.x / 2f;
			xOffset3 = player.position.x / 1f;
			
			for(int i = 0; i < 150; i++) {
				//if(0 - xOffset + 300 * i >= player.position.x - Global.WIDTH  && 0 - xOffset + 300 * i <= player.position.x + Global.WIDTH) {
					sb.draw(Textures.TREE3, 0 - xOffset + 300 * i, 550, 300, 1000);
				//}
			}
			
			for(int i = 0; i < 150; i++) {
				//if(0 - xOffset + 400 * i >= player.position.x - Global.WIDTH && 0 - xOffset + 400 * i <= player.position.x + Global.WIDTH) {
					sb.draw(Textures.TREE2, 0 - xOffset2 + 400 * i, 400, 300, 1000);
				//}
			}
			
			for(int i = 0; i < 150; i++) {
				//if(0 - xOffset + 450 * i >= player.position.x - Global.WIDTH && 0 - xOffset + 450 * i <= player.position.x + Global.WIDTH) {
					sb.draw(Textures.TREE1, 0 - xOffset3 + 450 * i, 350, 300, 1000);
				//}
			}

		} else {
			

			for(int i = 0; i < 5; i++) {
				treePos[i]+=1;
				if(treePos[i] > Global.WIDTH - 200 * i) {
					treePos[i] = -(200 * i) - 200;
				}

				sb.draw(Textures.TREE3, treePos[i] + 200 * i, 200, 200, 600);
			}
			
			for(int i = 0; i < 5; i++) {
				treePos[i + 5]+=2;
				if(treePos[i + 5] > Global.WIDTH - 250 * i) {
					treePos[i + 5] = -(250 * i) - 250;
				}

				sb.draw(Textures.TREE2, treePos[i + 5] + 250 * i, 100, 200, 600);
			}
			
			for(int i = 0; i < 4; i++) {
				treePos[i + 10]+=3;
				if(treePos[i + 10] > Global.WIDTH - 300 * i) {
					treePos[i + 10] = -(300 * i) - 300;
				}

				sb.draw(Textures.TREE1, treePos[i + 10] + 300 * i, 0, 200, 600);
			}

		}

		


	}

}
