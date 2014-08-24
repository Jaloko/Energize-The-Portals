package com.corybeams.energizetheportals.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {

	public static final Texture WORLD1 = new Texture(Gdx.files.internal("graphics/worlds/world1_new.png"));
	public static final Texture WORLD2 = new Texture(Gdx.files.internal("graphics/worlds/world2_new.png"));
	
	private static final Texture TILES = new Texture(Gdx.files.internal("graphics/textures/tiles.png"));

	private static final Texture TREES = new Texture(Gdx.files.internal("graphics/textures/ParallaxTrees.png"));
	
	public static final TextureRegion TREE1 = new TextureRegion(TREES, 0, 0, 170, 512);
	public static final TextureRegion TREE2 = new TextureRegion(TREES, 170, 0, 175, 512);
	public static final TextureRegion TREE3 = new TextureRegion(TREES, 345, 0, 167, 512);
	
	private static final Texture HILLS = new Texture(Gdx.files.internal("graphics/textures/ParallaxHills.png"));
	
	public static final Texture HILLS_FILLER = new Texture(Gdx.files.internal("graphics/textures/HillsFiller.png"));
	
	public static final TextureRegion HILL1 = new TextureRegion(HILLS, 0, 0, 276, 208);
	public static final TextureRegion HILL2 = new TextureRegion(HILLS, 276, 0, 236, 208);
	public static final TextureRegion HILL3 = new TextureRegion(HILLS, 0, 290, 276, 208);
	
	public static final TextureRegion GRASS = new TextureRegion(TILES, 0, 0, 32, 32);
	public static final TextureRegion DIRT = new TextureRegion(TILES, 32, 0, 32, 32);
	public static final TextureRegion STONE_FLOOR = new TextureRegion(TILES, 64, 0 , 32, 32);
	public static final TextureRegion STONE = new TextureRegion(TILES, 96, 0 , 32, 32);
	
	public static final Texture STARS = new Texture(Gdx.files.internal("graphics/textures/Stars.png"));
	
	public static final Texture LOGO = new Texture(Gdx.files.internal("graphics/logo.png"));
	
	public static final Texture BUTTONS = new Texture(Gdx.files.internal("graphics/gameButtons.png"));
	
	public static final TextureRegion PLAY = new TextureRegion(BUTTONS, 0, 0, 200, 40);
	public static final TextureRegion HELP = new TextureRegion(BUTTONS, 0, 40, 200, 40);
	public static final TextureRegion QUIT = new TextureRegion(BUTTONS, 0, 80, 200, 40);
	public static final TextureRegion BACK = new TextureRegion(BUTTONS, 0, 120, 200, 40);
	public static final TextureRegion MAIN_MENU = new TextureRegion(BUTTONS, 0, 160, 200, 40);
	
	public static final TextureRegion PLAY_SELECTED = new TextureRegion(BUTTONS, 0, 200, 200, 40);
	public static final TextureRegion HELP_SELECTED = new TextureRegion(BUTTONS, 0, 240, 200, 40);
	public static final TextureRegion QUIT_SELECTED = new TextureRegion(BUTTONS, 0, 280, 200, 40);
	public static final TextureRegion BACK_SELECTED = new TextureRegion(BUTTONS, 0, 320, 200, 40);
	public static final TextureRegion MAIN_MENU_SELECTED = new TextureRegion(BUTTONS, 0, 360, 200, 40);
	
	

	
	

	public static final TextureRegion ENERGY_CELL = new TextureRegion(TILES, 0 , 128, 16, 16);
	
	public static final TextureRegion BEACON = new TextureRegion(TILES, 0, 32, 32, 32);
	private static final TextureRegion[] BEACON_ENERGIZED_FRAMES = new TextureRegion[] { new TextureRegion(TILES, 32, 32, 32, 32), new TextureRegion(TILES, 64, 32, 32, 32) };
	public static Animation BEACON_ENERGIZED_ANIMATION = new Animation(0.2f, BEACON_ENERGIZED_FRAMES);
	
	private static TextureRegion[] PORTAL_FRAMES = new TextureRegion[] { new TextureRegion(TILES, 0, 64, 64, 64), new TextureRegion(TILES, 64, 64, 64, 64), new TextureRegion(TILES, 128, 64, 64, 64)};
	public static Animation PORTAL_ANIMATION = new Animation(0.2f, PORTAL_FRAMES);
	
	public static TextureRegion[] PLAYER_RIGHT_FRAMES = new TextureRegion[] { new TextureRegion(TILES, 0, 512 - 32, 32, 32), new TextureRegion(TILES, 32, 512 - 32, 32, 32), new TextureRegion(TILES, 64, 512-32, 32, 32)};
	public static Animation PLAYER_RIGHT_ANIMATION = new Animation(0.2f, PLAYER_RIGHT_FRAMES);
	
	public static TextureRegion[] PLAYER_LEFT_FRAMES = new TextureRegion[] { new TextureRegion(TILES, 96 + 64, 512 - 32, 32, 32), new TextureRegion(TILES, 96 + 32, 512 - 32, 32, 32), new TextureRegion(TILES, 96, 512-32, 32, 32)};
	public static Animation PLAYER_LEFT_ANIMATION = new Animation(0.2f, PLAYER_LEFT_FRAMES);
	
	
	
	

}
