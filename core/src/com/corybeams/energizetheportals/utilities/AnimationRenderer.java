package com.corybeams.energizetheportals.utilities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationRenderer {

	public static float stateTime;
	private static TextureRegion currentFrame; 	
	
	public static void renderAnim(int x, int y, int tileWidth, int tileHeight, SpriteBatch sb, Animation anim, float frameTime) {
		stateTime+= frameTime;
        currentFrame = anim.getKeyFrame(stateTime, true);
        sb.draw(currentFrame, x, y, tileWidth, tileHeight);
	}

}
