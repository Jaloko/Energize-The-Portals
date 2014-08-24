package com.corybeams.energizetheportals.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.corybeams.energizetheportals.Game;
import com.corybeams.energizetheportals.utilities.Global;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Global.WIDTH;
		config.height = Global.HEIGHT;
		config.resizable = false;
		config.title = "Energize The Portals (LD30)";
		config.addIcon("graphics/icon-32x32.png", FileType.Internal);
		new LwjglApplication(new Game(), config);
	}
}
