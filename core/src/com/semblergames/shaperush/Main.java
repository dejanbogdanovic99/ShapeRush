package com.semblergames.shaperush;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.async.ThreadUtils;
import com.semblergames.shaperush.screen.LoadingScreen;
import com.semblergames.shaperush.screen.MainMenuScreen;
import com.semblergames.shaperush.screen.PlayScreen;
import com.semblergames.shaperush.screen.ShapeRushScreen;
import com.semblergames.shaperush.utils.Game;
import com.semblergames.shaperush.utils.GameLogger;
import com.semblergames.shaperush.utils.Screen;
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

	private ShapeRenderer shapeRenderer;

	private BitmapFont bitmapFont;

	private ColorShader colorShader;

	private Screen nextScreen;
	private int nextID;

	public static Color red;
	public static Color green;
	public static Color blue;


	/**
	 * TODO napraviti prelaz
	 */

	@Override
	public void requestScreen(int ID){
		nextID = ID;
	}



	@Override
	public void create () {

		manager = new AssetManager();
		colorShader = new ColorShader();
		batch = new SpriteBatch(1000,colorShader);
		bitmapFont = new BitmapFont(Gdx.files.internal("utils/loading/proba1.fnt"));
		shapeRenderer = new ShapeRenderer(30);


		red = new Color(0.792f,0.176f,0.176f,1);
		green = new Color(0.855f, 0.467f,0.149f,1);
		blue = new Color(0.953f,0.812f,0.188f,1);

		colorShader.loadColors(red,green,blue);

		LoadingScreen loadingScreen = new LoadingScreen();
		loadingScreen.create();
		addScreen(loadingScreen, ScreenIDs.LoadingScreen.getID());

		manager.finishLoading();

		MainMenuScreen mainMenuScreen = new MainMenuScreen();
		mainMenuScreen.create();
		addScreen(mainMenuScreen, ScreenIDs.MainMenuScreen.getID());

		PlayScreen playScreen = new PlayScreen();
		playScreen.create();
		addScreen(playScreen, ScreenIDs.PlayScreen.getID());

		setScreen(ScreenIDs.LoadingScreen.getID());
		nextID = currentID;
	}

	//TODO skloniti kad ne bude trebalo
	GameLogger logger = new GameLogger();



	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();

		if(manager.update()){
			if(nextID != currentID){
				currentScreen.hide();
				currentScreen.release();
				currentScreen = getScreen(nextID);
				currentID = nextID;
				currentScreen.prepare();
				currentScreen.show();
				System.gc();
			}
		}


		logger.log();
	}

	
	@Override
	public void dispose () {

		currentScreen.hide();
		currentScreen.release();

		getScreen(ScreenIDs.LoadingScreen.getID()).dispose();
		getScreen(ScreenIDs.MainMenuScreen.getID()).dispose();
		getScreen(ScreenIDs.PlayScreen.getID()).dispose();

		colorShader.dispose();
		batch.dispose();
		shapeRenderer.dispose();
		bitmapFont.dispose();
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

	public ShapeRenderer getShapeRenderer(){
		return shapeRenderer;
	}

	public BitmapFont getBitmapFont(){
		return bitmapFont;
	}

}
