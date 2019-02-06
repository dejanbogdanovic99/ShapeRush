package com.semblergames.shaperush.utils;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.HashMap;

public abstract class Game implements ApplicationListener {
    protected HashMap<Integer,Screen> screens;

    protected int currentID;
    protected Screen currentScreen;


    public Game(){
        screens = new HashMap<Integer, Screen>();
    }

    protected boolean addScreen(Screen screen, int ID){
        if(screens.containsKey(ID)){
            return false;
        }
        currentID = ID;
        currentScreen = screen;
        screens.put(ID,screen);
        return true;
    }

    protected Screen getScreen(int ID){
        return screens.get(ID);
    }

    /** Sets the current screen
     * @param ID screen's ID to be set
     */

    protected void setScreen(int ID){
        if(currentScreen != null){
            currentScreen.hide();
        }
        currentID = ID;
        currentScreen = screens.get(ID);
        currentScreen.prepare();
        currentScreen.show();
    }


    /** Changes the currentScreen
     * @param ID next screen
     */
    public void requestScreen(int ID){
        if(currentID != ID){
            currentScreen.hide();
            currentID = ID;
            currentScreen = screens.get(ID);
            currentScreen.prepare();
            currentScreen.show();
        }
    }

    @Override
    public void create() {

    }

    @Override
    public void resize(int width, int height) {
        currentScreen.resize(width, height);
    }

    @Override
    public void render() {
        currentScreen.update(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
        currentScreen.render();
    }

    @Override
    public void pause() {
        currentScreen.pause();
    }


    @Override
    public void resume() {
        currentScreen.resume();
    }

    /** Clears the map of screens */
    @Override
    public void dispose(){
        screens.clear();
    }
}
