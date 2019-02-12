package com.semblergames.shaperush.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.semblergames.shaperush.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 500;

		config.height = 1000;
		config.resizable = false;

		new LwjglApplication(new Main(), config);
	}
}
