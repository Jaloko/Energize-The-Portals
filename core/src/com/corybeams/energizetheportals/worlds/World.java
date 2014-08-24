package com.corybeams.energizetheportals.worlds;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.corybeams.energizetheportals.Game;
import com.corybeams.energizetheportals.entities.items.EnergyCell;
import com.corybeams.energizetheportals.entities.items.Item;
import com.corybeams.energizetheportals.utilities.AnimationRenderer;
import com.corybeams.energizetheportals.utilities.Global;
import com.corybeams.energizetheportals.utilities.Textures;
import com.corybeams.energizetheportals.utilities.Types;

public class World {
	
	public int worldNumber;
	public int width;
	public int height;
	public int tileSize = 32;
	public short[][] tiles;
	public ArrayList<Vector2> portals = new ArrayList<Vector2>();
	public ArrayList<Vector2> beacons = new ArrayList<Vector2>();
	
	public ArrayList<Item> items = new ArrayList<Item>();
	
	private Sound beaconPower;
	
	public World(Texture t, int worldNumber) {
		this.worldNumber = worldNumber;
		beaconPower = Gdx.audio.newSound(Gdx.files.internal("sounds/BeaconPowered.wav"));
		loadWorld(t);
		if(worldNumber == 1) {
			items.add(new EnergyCell(600, 600, 16, 16));
			items.add(new EnergyCell(2650, 896, 16, 16));	
			items.add(new EnergyCell(5900, 1152, 16, 16));
			items.add(new EnergyCell(8300, 768, 16, 16));
			items.add(new EnergyCell(10020, 1088, 16, 16));
			items.add(new EnergyCell(13300, 704, 16, 16));
			items.add(new EnergyCell(14480, 1056, 16, 16));
			items.add(new EnergyCell(16920, 672, 16, 16));
			items.add(new EnergyCell(19320, 1024, 16, 16));
			items.add(new EnergyCell(22640, 672, 16, 16));
			items.add(new EnergyCell(24020, 992, 16, 16));
			items.add(new EnergyCell(26320, 736, 16, 16));
			items.add(new EnergyCell(27680, 928, 16, 16));
			items.add(new EnergyCell(28880, 672, 16, 16));
			items.add(new EnergyCell(30000, 1200, 16, 16));		
		} else if(worldNumber == 2) {
			items.add(new EnergyCell(1656, 960, 16, 16));	
			items.add(new EnergyCell(3320, 800, 16, 16));
			items.add(new EnergyCell(5900, 800, 16, 16));
			items.add(new EnergyCell(6868, 928, 16, 16));
			items.add(new EnergyCell(9248, 576, 16, 16));
			items.add(new EnergyCell(10348, 960, 16, 16));
			items.add(new EnergyCell(12128, 768, 16, 16));
			items.add(new EnergyCell(13388, 1088, 16, 16));
			items.add(new EnergyCell(14788, 800, 16, 16));
			items.add(new EnergyCell(16028, 1056, 16, 16));
			items.add(new EnergyCell(18728, 864, 16, 16));
			items.add(new EnergyCell(20568, 960, 16, 16));
			items.add(new EnergyCell(21368, 768, 16, 16));
			items.add(new EnergyCell(23528, 576, 16, 16));
			items.add(new EnergyCell(24908, 864, 16, 16));
			items.add(new EnergyCell(25948, 864, 16, 16));
			items.add(new EnergyCell(28428, 672, 16, 16));
			items.add(new EnergyCell(30348, 1344, 16, 16));
		}
	}
	
	private void loadWorld(Texture t) {
		TextureData td = t.getTextureData();
		width = td.getWidth();
		height = td.getHeight();
		tiles = new short[width][height];
		td.prepare();
		Pixmap pm = td.consumePixmap();		
		Color c = new Color();
		
		for(int x = 0; x < td.getWidth(); x++) {
			for(int y = 0; y < td.getHeight(); y++) {
				Color.rgba8888ToColor(c, (int) pm.getPixel(x, (td.getHeight() - 1) - y));
				
				String colour = c.toString();
				if(colour.equals("11c308ff")) {
					tiles[x][y] = Types.GRASS;
				} else if(colour.equals("5c3838ff")) {
					tiles[x][y] = Types.DIRT;
				} else if(colour.equals("303030ff")) {
					tiles[x][y] = Types.STONE_FLOOR;
				} else if(colour.equals("545454ff")) {
					tiles[x][y] = Types.STONE;
				} else if(colour.equals("ffff0fff")) {
					tiles[x][y] = Types.BEACON;
					beacons.add(new Vector2(x * tileSize, y * tileSize));
				} else if(colour.equals("eae100ff")) {
					tiles[x][y] = Types.BEACON_ENERGIZED;
				} else if(colour.equals("8707f4ff")) {
					tiles[x][y] = Types.PORTAL;
					portals.add(new Vector2(x * tileSize, y * tileSize));
				} else {
					tiles[x][y] = Types.VOID;
				}
				


			}
		}
		pm.dispose();
	}
	
	public void update() {
		ArrayList<Item> removeItems = new ArrayList<Item>();
		for(Item i: items) {
			i.update(this);
			for(int x = 0; x < width; x++) {
				for(int y = 0; y < height; y++) {
					if(i.position.x >= x * tileSize && i.position.x <= x *tileSize + tileSize) {
						if(i.position.y >= y * tileSize && i.position.y <= y * tileSize + tileSize) {
							if(tiles[x][y] == Types.BEACON) {
								beaconPower.play();
								tiles[x][y] = Types.BEACON_ENERGIZED;
								removeItems.add(i);
								break;
							}

						}
					}
				}
			}
		}
		
		for(int i = 0; i < removeItems.size(); i++) {
			items.remove(removeItems.get(i));
			removeItems.remove(i);
		}
		

	}
	
	public void render(SpriteBatch sb) {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				// Limits X render range
				if(x * tileSize >= Game.player.position.x - Global.WIDTH && x * tileSize <= Game.player.position.x + Global.WIDTH) {
					if(tiles[x][y] == Types.GRASS) {
						sb.draw(Textures.GRASS, x * tileSize, y * tileSize, tileSize, tileSize);
					} else if(tiles[x][y] == Types.DIRT) {
						sb.draw(Textures.DIRT, x * tileSize, y * tileSize, tileSize, tileSize);
					} else if(tiles[x][y] == Types.STONE_FLOOR) {
						sb.draw(Textures.STONE_FLOOR, x * tileSize, y * tileSize, tileSize, tileSize);
					} else if(tiles[x][y] == Types.STONE) {
						sb.draw(Textures.STONE, x * tileSize, y * tileSize, tileSize, tileSize);
					} else if(tiles[x][y] == Types.BEACON) {
						sb.draw(Textures.BEACON, x * tileSize, y * tileSize, tileSize, tileSize);
					} else if(tiles[x][y] == Types.PORTAL) {
						AnimationRenderer.renderAnim(x * tileSize, y * tileSize, tileSize * 2, tileSize * 2, sb, Textures.PORTAL_ANIMATION, 0.02f);
					} else if(tiles[x][y] == Types.BEACON_ENERGIZED) {
						AnimationRenderer.renderAnim(x * tileSize, y * tileSize, tileSize, tileSize, sb, Textures.BEACON_ENERGIZED_ANIMATION, 0.02f);
					}
				}	
			}
		}
		
		for(Item i: items) {
			i.render(sb);
		}
		
	}
	
	

}
