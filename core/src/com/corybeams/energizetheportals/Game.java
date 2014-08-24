package com.corybeams.energizetheportals;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.corybeams.energizetheportals.entities.mobs.Player;
import com.corybeams.energizetheportals.utilities.Global;
import com.corybeams.energizetheportals.utilities.Textures;
import com.corybeams.energizetheportals.worlds.World;

public class Game extends ApplicationAdapter {
	SpriteBatch sb;
	Texture img;
	
	OrthographicCamera cam;
	public static Player player;
	World world1;
	World world2;
	
	ParallaxTrees trees;
	ParallaxHills hills;
	
	World currentWorld;
	
	Menu menu;
	
	public static boolean leftClicked = false;
	
	ParallaxTrees gameWonTrees;
	
	public static String gameState = "menu";

	
	@Override
	public void create () {
		menu = new Menu();
		sb = new SpriteBatch();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Global.WIDTH, Global.HEIGHT);
		
		gameWonTrees = new ParallaxTrees();
		
		Global.font = new BitmapFont();
		
		newGame();
		
	}
	
	public void newGame() {
		//Initialize Game Objects
		player = new Player(Global.WIDTH / 2 + 30, 0, 32, 32);
		player.position.y = 608;
		world1 = new World(Textures.WORLD1, 1);
		world2 = new World(Textures.WORLD2, 2);
		currentWorld = world1;
		
		trees = new ParallaxTrees(player);
		hills = new ParallaxHills(player);
	}
	
	public void update() {
		if(!Gdx.input.isButtonPressed(Buttons.LEFT)) {
			leftClicked = false;
		}
		
		if(gameState.equals("menu")) {
			menu.update();
		} else if(gameState.equals("play")) {
			if(player.position.y < 0) {
				newGame();
			}
			if(player.recentlyUsedPortal) {
				if(player.inFirstWorld) {
					currentWorld = world1;
					if(player.portalCount == 2) {
						player.position.x = world1.portals.get(1).x + 64;
						player.position.y = world1.portals.get(1).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 4) {
						player.position.x = world1.portals.get(3).x + 64;
						player.position.y = world1.portals.get(3).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 6) {
						player.position.x = world1.portals.get(5).x + 64;
						player.position.y = world1.portals.get(5).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 8) {
						player.position.x = world1.portals.get(7).x + 64;
						player.position.y = world1.portals.get(7).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 10) {
						player.position.x = world1.portals.get(9).x + 64;
						player.position.y = world1.portals.get(9).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 12) {
						player.position.x = world1.portals.get(11).x + 64;
						player.position.y = world1.portals.get(11).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 14) {
						player.position.x = world1.portals.get(13).x + 64;
						player.position.y = world1.portals.get(13).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 16) {
						player.position.x = world1.portals.get(15).x + 64;
						player.position.y = world1.portals.get(15).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 18) {
						player.position.x = world1.portals.get(17).x + 64;
						player.position.y = world1.portals.get(17).y;
						player.recentlyUsedPortal = false;
					}  else if(player.portalCount == 20) {
						player.position.x = world1.portals.get(19).x + 64;
						player.position.y = world1.portals.get(19).y;
						player.recentlyUsedPortal = false;
					}  else if(player.portalCount == 22) {
						player.position.x = world1.portals.get(21).x + 64;
						player.position.y = world1.portals.get(21).y;
						player.recentlyUsedPortal = false;
					}  else if(player.portalCount == 24) {
						player.position.x = world1.portals.get(23).x + 64;
						player.position.y = world1.portals.get(23).y;
						player.recentlyUsedPortal = false;
					}  else if(player.portalCount == 26) {
						player.position.x = world1.portals.get(25).x + 64;
						player.position.y = world1.portals.get(25).y;
						player.recentlyUsedPortal = false;
					}  else if(player.portalCount == 28) {
						player.position.x = world1.portals.get(27).x + 64;
						player.position.y = world1.portals.get(27).y;
						player.recentlyUsedPortal = false;
					}  

				} else {
					currentWorld = world2;
					if(player.portalCount == 1) {
						player.position.x = world2.portals.get(0).x + 64;
						player.position.y = world2.portals.get(0).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 3) {
						player.position.x = world2.portals.get(2).x + 64;
						player.position.y = world2.portals.get(2).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 5) {
						player.position.x = world2.portals.get(4).x + 64;
						player.position.y = world2.portals.get(4).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 7) {
						player.position.x = world2.portals.get(6).x + 64;
						player.position.y = world2.portals.get(6).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 9) {
						player.position.x = world2.portals.get(8).x + 64;
						player.position.y = world2.portals.get(8).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 11) {
						player.position.x = world2.portals.get(10).x + 64;
						player.position.y = world2.portals.get(10).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 13) {
						player.position.x = world2.portals.get(12).x + 64;
						player.position.y = world2.portals.get(12).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 15) {
						player.position.x = world2.portals.get(14).x + 64;
						player.position.y = world2.portals.get(14).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 17) {
						player.position.x = world2.portals.get(16).x + 64;
						player.position.y = world2.portals.get(16).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 19) {
						player.position.x = world2.portals.get(18).x + 64;
						player.position.y = world2.portals.get(18).y;
						player.recentlyUsedPortal = false;
					}else if(player.portalCount == 21) {
						player.position.x = world2.portals.get(20).x + 64;
						player.position.y = world2.portals.get(20).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 23) {
						player.position.x = world2.portals.get(22).x + 64;
						player.position.y = world2.portals.get(22).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 25) {
						player.position.x = world2.portals.get(24).x + 64;
						player.position.y = world2.portals.get(24).y;
						player.recentlyUsedPortal = false;
					} else if(player.portalCount == 27) {
						player.position.x = world2.portals.get(26).x + 64;
						player.position.y = world2.portals.get(26).y;
						player.recentlyUsedPortal = false;
					}

				}
			}


			if(player != null) {
				player.update(currentWorld);
				cam.position.x = player.position.x;
				cam.position.y = player.position.y;
			}
			cam.update();
			
			if(player.inFirstWorld) {
				world1.update();			
			} else {
				world2.update();
			}
		} else if(gameState.equals("gameWon")) {
			cam.position.x = Global.WIDTH / 2;
			cam.position.y = Global.HEIGHT / 2;
			cam.update();
			
			if(Gdx.input.getX() >=  Global.WIDTH / 2 - 100 && Gdx.input.getX() <=  Global.WIDTH / 2 - 100 + 200 &&
					Math.abs(Gdx.input.getY() - Global.HEIGHT) >=  40 && Math.abs(Gdx.input.getY() - Global.HEIGHT) <=  40 + 40) {
				if(!leftClicked) {
					if(Gdx.input.isButtonPressed(Buttons.LEFT)) {
						leftClicked = true;
						gameState = "menu";
						menu.menuState = "";
					}
				}

			} 
		}

	}

	@Override
	public void render () {

		update();
		sb.setProjectionMatrix(cam.combined);
		Gdx.gl.glClearColor(0, 0.3f, 0.7f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.begin();
		
		if(gameState.equals("menu")) {
			menu.render(sb);
		} else if(gameState.equals("play")) {
			if(player.inFirstWorld) {
				trees.render(sb);
				world1.render(sb);	

			} else {
				hills.render(sb);
				world2.render(sb);
			}
			if(player != null) {
				player.render(sb);
			}
		} else if(gameState.equals("gameWon")) {
			gameWonTrees.render(sb);

			float w = Global.font.getBounds("Final Score: " + player.score).width;
			
			Global.font.draw(sb, "Final Score: " + player.score, Global.WIDTH / 2 - w / 2, Global.HEIGHT - 40);
			
			if(Gdx.input.getX() >=  Global.WIDTH / 2 - 100 && Gdx.input.getX() <=  Global.WIDTH / 2 - 100 + 200 &&
				Math.abs(Gdx.input.getY() - Global.HEIGHT) >=  40 && Math.abs(Gdx.input.getY() - Global.HEIGHT) <=  40 + 40) {
				sb.draw(Textures.MAIN_MENU_SELECTED, Global.WIDTH / 2 - 100, 40, 200, 40);				
			} else {
				sb.draw(Textures.MAIN_MENU,  Global.WIDTH / 2 - 100,  40, 200, 40);				
			}
			
		}


		sb.end();
	}
}
