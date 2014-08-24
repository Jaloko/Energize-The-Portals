package com.corybeams.energizetheportals.entities.mobs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.corybeams.energizetheportals.Game;
import com.corybeams.energizetheportals.entities.items.Item;
import com.corybeams.energizetheportals.utilities.AnimationRenderer;
import com.corybeams.energizetheportals.utilities.Global;
import com.corybeams.energizetheportals.utilities.Textures;
import com.corybeams.energizetheportals.utilities.Types;
import com.corybeams.energizetheportals.worlds.World;

public class Player extends Mob {
	
	public boolean holdingItem = false;
	public Item item;
	public boolean ePressed = false;
	public boolean inFirstWorld = true;
	public boolean recentlyUsedPortal = false;
	//The amount of portals you have been past
	public int portalCount = 0;
	
	public boolean endGame = false;
	
	public Animation moving_right;
	public Animation moving_left;
	
	private String lastPressedKey = "D";
	
	private boolean pressedSpace = false;
	private long spaceTimer = 0;
	
	private Sound jump;
	private Sound portal;
	private Sound pickUp;
	
	
	public static int score = 0;
	
	public Player(float xPos, float yPos, int width, int height) {
		super(xPos, yPos, width, height);
		moving_right = Textures.PLAYER_RIGHT_ANIMATION;
		moving_left = Textures.PLAYER_LEFT_ANIMATION;
		
		jump = Gdx.audio.newSound(Gdx.files.internal("sounds/Jump.wav"));
		portal = Gdx.audio.newSound(Gdx.files.internal("sounds/Portal.wav"));
		pickUp = Gdx.audio.newSound(Gdx.files.internal("sounds/PickUp.wav"));

			
	}
	
	public void update(World w) {

		super.update(w);
		if(System.currentTimeMillis() - spaceTimer >= 550) {
			pressedSpace = false;
		}
		if(position.y < 0) {
			Game.gameState = "gameWon";
		}
		if(Gdx.input.isKeyPressed(Keys.A)) {
			if(position.x > Global.WIDTH / 2 + width) {
				position.x -= 5;
				lastPressedKey = "A";
			}
		}
		if(Gdx.input.isKeyPressed(Keys.D)) {
			if(position.x < 31300) {
				position.x += 5;
				lastPressedKey = "D";	

			}
		}
		if(Gdx.input.isKeyPressed(Keys.SPACE)) {
			if(!pressedSpace) {
				jump.play();
				pressedSpace = true;
				spaceTimer = System.currentTimeMillis();
			}
			position.y += 8;

		}
		
		for(Item i : w.items) {
			if(i.position.x <= position.x + width + (w.tileSize * 1) && i.position.x >= position.x - (w.tileSize * 1)) {
				if(Gdx.input.isKeyPressed(Keys.E)) {
					if(ePressed == false) {
						pickUp.play();	
						holdingItem = !holdingItem;
						if(i.gravityEnabled) {
							i.gravityEnabled = false;
						} else {
							i.gravityEnabled = true;
						}
						item = i;
						ePressed = true;
						
					}

				} else if(!Gdx.input.isKeyPressed(Keys.E)) {
					ePressed = false;
				}
			}
		}
		
		if(holdingItem == true) {
			if(ePressed) {
			
			}
			for(Item i : w.items) {
				if(item == i) {
					if(i.gravityEnabled) {
						i.gravityEnabled = false;
					}
					if(lastPressedKey.equals("D")) {
						i.position.x = position.x + width / 2;
						i.position.y = position.y + 5;
					}
					if(lastPressedKey.equals("A")) {
						i.position.x = position.x;
						i.position.y = position.y + 5;
					}
				}
			}
		}
		
		
		if(recentlyUsedPortal == false) {
			for(int i = 0; i < w.beacons.size(); i++) {
				int x = (int) w.beacons.get(i).x;
				int y = (int) w.beacons.get(i).y;
					if(inFirstWorld) {
						if(Gdx.input.isKeyPressed(Keys.D)) {
							if(position.x + width >= w.portals.get(0).x && position.x <= w.portals.get(0).x + 64) {
								if(w.tiles[x / w.tileSize][y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;	
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(2).x && position.x <= w.portals.get(2).x + 64) {
								if(w.tiles[(int) (w.beacons.get(1).x / w.tileSize)][(int) w.beacons.get(1).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(4).x && position.x <= w.portals.get(4).x + 64) {
								if(w.tiles[(int) (w.beacons.get(2).x / w.tileSize)][(int) w.beacons.get(2).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(6).x && position.x <= w.portals.get(6).x + 64) {
								if(w.tiles[(int) (w.beacons.get(3).x / w.tileSize)][(int) w.beacons.get(3).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							}  else if(position.x + width >= w.portals.get(8).x && position.x <= w.portals.get(8).x + 64) {
								if(w.tiles[(int) (w.beacons.get(4).x / w.tileSize)][(int) w.beacons.get(4).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(10).x && position.x <= w.portals.get(10).x + 64) {
								if(w.tiles[(int) (w.beacons.get(5).x / w.tileSize)][(int) w.beacons.get(5).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(12).x && position.x <= w.portals.get(12).x + 64) {
								if(w.tiles[(int) (w.beacons.get(6).x / w.tileSize)][(int) w.beacons.get(6).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							}else if(position.x + width >= w.portals.get(14).x && position.x <= w.portals.get(14).x + 64) {
								if(w.tiles[(int) (w.beacons.get(7).x / w.tileSize)][(int) w.beacons.get(7).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							}else if(position.x + width >= w.portals.get(16).x && position.x <= w.portals.get(16).x + 64) {
								if(w.tiles[(int) (w.beacons.get(8).x / w.tileSize)][(int) w.beacons.get(8).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							}else if(position.x + width >= w.portals.get(18).x && position.x <= w.portals.get(18).x + 64) {
								if(w.tiles[(int) (w.beacons.get(9).x / w.tileSize)][(int) w.beacons.get(9).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							}else if(position.x + width >= w.portals.get(20).x && position.x <= w.portals.get(20).x + 64) {
								if(w.tiles[(int) (w.beacons.get(10).x / w.tileSize)][(int) w.beacons.get(10).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(22).x && position.x <= w.portals.get(22).x + 64) {
								if(w.tiles[(int) (w.beacons.get(11).x / w.tileSize)][(int) w.beacons.get(11).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(24).x && position.x <= w.portals.get(24).x + 64) {
								if(w.tiles[(int) (w.beacons.get(12).x / w.tileSize)][(int) w.beacons.get(12).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(26).x && position.x <= w.portals.get(26).x + 64) {
								if(w.tiles[(int) (w.beacons.get(13).x / w.tileSize)][(int) w.beacons.get(13).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(28).x && position.x <= w.portals.get(28).x + 64) {
								if(w.tiles[(int) (w.beacons.get(14).x / w.tileSize)][(int) w.beacons.get(14).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									score += 50;
									portal.play();
									endGame = true;
									Game.gameState = "gameWon";
								}
							}
							
							
						}

					} else {
						if(Gdx.input.isKeyPressed(Keys.D)) {
							if(position.x + width >= w.portals.get(1).x && position.x <= w.portals.get(1).x + 64) {
								if(w.tiles[(int) (w.beacons.get(0).x / w.tileSize)][(int) w.beacons.get(0).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}

							} else if(position.x + width >= w.portals.get(3).x && position.x <= w.portals.get(3).x + 64) {
								if(w.tiles[(int) (w.beacons.get(1).x / w.tileSize)][(int) w.beacons.get(1).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(5).x && position.x <= w.portals.get(5).x + 64) {
								if(w.tiles[(int) (w.beacons.get(2).x / w.tileSize)][(int) w.beacons.get(2).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(7).x && position.x <= w.portals.get(7).x + 64) {
								if(w.tiles[(int) (w.beacons.get(3).x / w.tileSize)][(int) w.beacons.get(3).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							}  else if(position.x + width >= w.portals.get(9).x && position.x <= w.portals.get(9).x + 64) {
								if(w.tiles[(int) (w.beacons.get(4).x / w.tileSize)][(int) w.beacons.get(4).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(11).x && position.x <= w.portals.get(11).x + 64) {
								if(w.tiles[(int) (w.beacons.get(5).x / w.tileSize)][(int) w.beacons.get(5).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(13).x && position.x <= w.portals.get(13).x + 64) {
								if(w.tiles[(int) (w.beacons.get(6).x / w.tileSize)][(int) w.beacons.get(6).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(15).x && position.x <= w.portals.get(15).x + 64) {
								if(w.tiles[(int) (w.beacons.get(7).x / w.tileSize)][(int) w.beacons.get(7).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(17).x && position.x <= w.portals.get(17).x + 64) {
								if(w.tiles[(int) (w.beacons.get(8).x / w.tileSize)][(int) w.beacons.get(8).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(19).x && position.x <= w.portals.get(19).x + 64) {
								if(w.tiles[(int) (w.beacons.get(9).x / w.tileSize)][(int) w.beacons.get(9).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(21).x && position.x <= w.portals.get(21).x + 64) {
								if(w.tiles[(int) (w.beacons.get(10).x / w.tileSize)][(int) w.beacons.get(10).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(23).x && position.x <= w.portals.get(23).x + 64) {
								if(w.tiles[(int) (w.beacons.get(11).x / w.tileSize)][(int) w.beacons.get(11).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(25).x && position.x <= w.portals.get(25).x + 64) {
								if(w.tiles[(int) (w.beacons.get(12).x / w.tileSize)][(int) w.beacons.get(12).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} else if(position.x + width >= w.portals.get(27).x && position.x <= w.portals.get(27).x + 64) {
								if(w.tiles[(int) (w.beacons.get(13).x / w.tileSize)][(int) w.beacons.get(13).y / w.tileSize] == Types.BEACON_ENERGIZED) {
									inFirstWorld = !inFirstWorld;
									recentlyUsedPortal = true;
									portalCount++;
									score += 50;
									portal.play();
								}
							} 
						} 
					}

				}
			}
	}

		
	
	
	public void render(SpriteBatch sb) {
		
		if(Gdx.input.isKeyPressed(Keys.D)) {
			AnimationRenderer.renderAnim((int) position.x, (int) position.y, width, height, sb, moving_right, 0.01f);
		}
		else if(Gdx.input.isKeyPressed(Keys.A)) {
			AnimationRenderer.renderAnim((int) position.x, (int) position.y, width, height, sb, moving_left, 0.01f);
		}else {
			if(lastPressedKey.equals("D")) {
				sb.draw(Textures.PLAYER_RIGHT_FRAMES[0], (int) position.x, (int) position.y, width, height);				
			} else if(lastPressedKey.equals("A")) {
				sb.draw(Textures.PLAYER_LEFT_FRAMES[0], (int) position.x, (int) position.y, width, height);		
			}
		}
		
		Global.font.draw(sb, "Score: " + score, position.x - Global.WIDTH / 2, position.y + Global.HEIGHT / 2);

	}

}
