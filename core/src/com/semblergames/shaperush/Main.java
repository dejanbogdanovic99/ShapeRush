package com.semblergames.shaperush;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.semblergames.shaperush.screen.LoadingScreen;
import com.semblergames.shaperush.screen.MainMenuScreen;
import com.semblergames.shaperush.screen.PlayScreen;
import com.semblergames.shaperush.utils.Game;
import com.semblergames.shaperush.utils.graphics.ColorShader;

public class Main extends Game {

	public enum ScreenIDs{

		LoadingScreen(0),MainMenuScreen(1),PlayScreen(2);

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
		colorShader = new ColorShader();
		batch = new SpriteBatch(1000);

		BitmapFont fonr = new BitmapFont();
		fonr.dispose();

		LoadingScreen loadingScreen = new LoadingScreen(Color.BLACK);
		loadingScreen.create();
		addScreen(loadingScreen, ScreenIDs.LoadingScreen.getID());

		MainMenuScreen mainMenuScreen = new MainMenuScreen();
		mainMenuScreen.create();
		addScreen(mainMenuScreen, ScreenIDs.MainMenuScreen.getID());

		PlayScreen playScreen = new PlayScreen();
		playScreen.create();
		addScreen(playScreen, ScreenIDs.PlayScreen.getID());


		setScreen(ScreenIDs.PlayScreen.getID());
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
		getScreen(ScreenIDs.PlayScreen.getID()).dispose();

		colorShader.dispose();
		batch.dispose();
		manager.dispose();

		super.dispose();
	}

	public AssetManager getManager(){
		return manager;
	}

	public SpriteBatch getBatch(){
		return batch;
	}

	public ColorShader getColorShader(){
		return colorShader;
	}

}
