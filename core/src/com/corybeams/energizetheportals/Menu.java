package com.corybeams.energizetheportals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.corybeams.energizetheportals.utilities.Global;
import com.corybeams.energizetheportals.utilities.Textures;

public class Menu {
	
	ParallaxTrees trees;
	
	public String menuState = "";
	
	private Music music;
	
	
	
	public Menu() {
		trees = new ParallaxTrees();
		music = Gdx.audio.newMusic(Gdx.files.internal("sounds/menu.mp3"));
		music.setLooping(true);
		music.setVolume(0.5f);
		music.play();
	}
	
	public void render(SpriteBatch sb) {
		trees.render(sb);
			
		if(menuState.equals("help")) {
			float w = Global.font.getBounds("<Controls>").width;
			Global.font.draw(sb, "<Controls>", Global.WIDTH / 2 - w / 2, Global.HEIGHT - 40 );
			w = Global.font.getBounds("Press 'A' and 'D' to move left and right").width;
			Global.font.draw(sb, "Press 'A' and 'D' to move left and right", Global.WIDTH / 2 - w / 2, Global.HEIGHT - 80);
			w = Global.font.getBounds("Press 'Space' to jump").width;
			Global.font.draw(sb, "Press 'Space' to jump", Global.WIDTH / 2 - w /2, Global.HEIGHT  - 120);
			w = Global.font.getBounds("Press 'E' to pick up energy cells").width;
			Global.font.draw(sb, "Press 'E' to pick up energy cells", Global.WIDTH / 2 - w /2, Global.HEIGHT  - 160);
			w = Global.font.getBounds("<Objectives>").width;
			Global.font.draw(sb, "<Objectives>", Global.WIDTH / 2 - w / 2, Global.HEIGHT  - 220);
			w = Global.font.getBounds("Pick up the blue energy cells").width;
			Global.font.draw(sb, "Pick up the blue energy cells", Global.WIDTH / 2 - w / 2, Global.HEIGHT - 260);
			w = Global.font.getBounds("Take the blue energy cells to the golden beacons").width;
			Global.font.draw(sb, "Take the blue energy cells to the golden beacons", Global.WIDTH / 2 - w / 2, Global.HEIGHT - 300);
			w = Global.font.getBounds("Travel through the portal to the connected world").width;
			Global.font.draw(sb, "Travel through the portal to the connected world", Global.WIDTH / 2 - w / 2, Global.HEIGHT - 340);
			
			
			if(Gdx.input.getX() >=  Global.WIDTH / 2 - 100 && Gdx.input.getX() <=  Global.WIDTH / 2 - 100 + 200 &&
					Math.abs(Gdx.input.getY() - Global.HEIGHT) >=  40 && Math.abs(Gdx.input.getY() - Global.HEIGHT) <=  40 + 40) {
					sb.draw(Textures.BACK_SELECTED, Global.WIDTH / 2 - 100, 40, 200, 40);				
				} else {
					sb.draw(Textures.BACK,  Global.WIDTH / 2 - 100,  40, 200, 40);				
				}
			
		} else {
			
			sb.draw(Textures.LOGO, Global.WIDTH / 2 - 300, Global.HEIGHT - 200 - 50, 600, 200);
			
			if(Gdx.input.getX() >= Global.WIDTH / 2 - 100 && Gdx.input.getX() <= Global.WIDTH / 2 - 100 + 200 &&
				Math.abs(Gdx.input.getY() - Global.HEIGHT) >= Global.HEIGHT / 2 - 40 - 50 && Math.abs(Gdx.input.getY() - Global.HEIGHT) <= Global.HEIGHT / 2 - 50) {
					sb.draw(Textures.PLAY_SELECTED, Global.WIDTH / 2 - 100, Global.HEIGHT / 2 - 40 - 50, 200, 40);					
			} else {
				sb.draw(Textures.PLAY, Global.WIDTH / 2 - 100, Global.HEIGHT / 2 - 40 - 50, 200, 40);			
			}
				
			if(Gdx.input.getX() >= Global.WIDTH / 2 - 100 && Gdx.input.getX() <= Global.WIDTH / 2 - 100 + 200 &&
				Math.abs(Gdx.input.getY() - Global.HEIGHT) >= Global.HEIGHT / 2 - 100 - 50 && Math.abs(Gdx.input.getY() - Global.HEIGHT) <= Global.HEIGHT / 2 - 60 - 50) {
				sb.draw(Textures.HELP_SELECTED, Global.WIDTH / 2 - 100, Global.HEIGHT / 2 - 100 - 50, 200, 40);	
			} else {
				sb.draw(Textures.HELP, Global.WIDTH / 2 - 100, Global.HEIGHT / 2 - 100 - 50, 200, 40);		
			}
				
			if(Gdx.input.getX() >= Global.WIDTH / 2 - 100 && Gdx.input.getX() <= Global.WIDTH / 2 - 100 + 200 &&
				Math.abs(Gdx.input.getY() - Global.HEIGHT) >= Global.HEIGHT / 2 - 160 - 50 && Math.abs(Gdx.input.getY() - Global.HEIGHT) <= Global.HEIGHT / 2 - 120 - 50) {
				sb.draw(Textures.QUIT_SELECTED, Global.WIDTH / 2 - 100, Global.HEIGHT / 2 - 160 - 50, 200, 40);		
			} else {
				sb.draw(Textures.QUIT, Global.WIDTH / 2 - 100, Global.HEIGHT / 2 - 160 - 50, 200, 40);	
			}	
		}
		

		

		
	
	}
	
	public void update() {
		
		if(menuState.equals("play")) {
			Game.gameState = "play";
		} else if(menuState.equals("help")) {
			if(Gdx.input.getX() >= Global.WIDTH / 2 - 100 && Gdx.input.getX() <= Global.WIDTH / 2 - 100 + 200 &&
					Math.abs(Gdx.input.getY() - Global.HEIGHT) >= 40 && Math.abs(Gdx.input.getY() - Global.HEIGHT) <= 40 + 40) {
				if(!Game.leftClicked) {
					if(Gdx.input.isButtonPressed(Buttons.LEFT)) {
						Game.leftClicked = true;
						menuState = "";
					}
				}

			} 
			
		} else {
			if(Gdx.input.getX() >= Global.WIDTH / 2 - 100 && Gdx.input.getX() <= Global.WIDTH / 2 - 100 + 200 &&
					Math.abs(Gdx.input.getY() - Global.HEIGHT) >= Global.HEIGHT / 2 - 40 - 50 && Math.abs(Gdx.input.getY() - Global.HEIGHT) <= Global.HEIGHT / 2 - 50) {
					if(!Game.leftClicked) {
						if(Gdx.input.isButtonPressed(Buttons.LEFT)) {
							menuState = "play";
						}
					}

				}
					
				if(Gdx.input.getX() >= Global.WIDTH / 2 - 100 && Gdx.input.getX() <= Global.WIDTH / 2 - 100 + 200 &&
					Math.abs(Gdx.input.getY() - Global.HEIGHT) >= Global.HEIGHT / 2 - 100 - 50 && Math.abs(Gdx.input.getY() - Global.HEIGHT) <= Global.HEIGHT / 2 - 60 - 50) {
					if(!Game.leftClicked) {
						if(Gdx.input.isButtonPressed(Buttons.LEFT)) {
							menuState = "help";
						}
					}

				} 
					
				if(Gdx.input.getX() >= Global.WIDTH / 2 - 100 && Gdx.input.getX() <= Global.WIDTH / 2 - 100 + 200 &&
					Math.abs(Gdx.input.getY() - Global.HEIGHT) >= Global.HEIGHT / 2 - 160 - 50 && Math.abs(Gdx.input.getY() - Global.HEIGHT) <= Global.HEIGHT / 2 - 120 - 50) {
					if(!Game.leftClicked) {
						if(Gdx.input.isButtonPressed(Buttons.LEFT)) {
							menuState = "quit";
							Gdx.app.exit();						
						}
					}

				} 
		}
	}

}
