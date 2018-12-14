package com.semblergames.shaperush;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.semblergames.shaperush.screen.LoadingScreen;
import com.semblergames.shaperush.screen.MainMenuScreen;
import com.semblergames.shaperush.utils.graphics.ColorShader;

public class Main extends Game {

	public enum ScreenIDs{
		LoadingScreen(0),MainMenuScreen(1);

		private int id;

		ScreenIDs(int id){
			this.id = id;
		}

		public int getID(){
			return id;
		}
	}

	private AssetManager manager;

	private SpriteBatch batch;

	private ColorShader colorShader;


	/**
	 * TODO napraviti prelaz
	 */

	@Override
	public void requestScreen(int ID){

		super.requestScreen(ID);
	}

	@Override
	public void create () {

		manager = new AssetManager();

		batch = new SpriteBatch();

		colorShader = new ColorShader();

		LoadingScreen loadingScreen = new LoadingScreen(colorShader,batch,manager, Color.BLACK);
		loadingScreen.initialize();
		addScreen(loadingScreen, ScreenIDs.LoadingScreen.getID());

		MainMenuScreen mainMenuScreen = new MainMenuScreen(colorShader, batch,manager);
		mainMenuScreen.initialize();
		addScreen(mainMenuScreen, ScreenIDs.MainMenuScreen.getID());
	}

	//TODO skloniti kad ne bude trebalo
	FPSLogger logger = new FPSLogger();

	@Override
	public void render () {
		super.render();

		logger.log();
	}
	
	@Override
	public void dispose () {

		getScreen(ScreenIDs.LoadingScreen.getID()).dispose();
		getScreen(ScreenIDs.MainMenuScreen.getID()).dispose();


		colorShader.dispose();
		batch.dispose();
		manager.dispose();

		super.dispose();
	}


}
