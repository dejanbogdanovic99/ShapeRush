package com.semblergames.shaperush;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.semblergames.shaperush.screen.Screen;

import java.util.HashMap;

public abstract class Game implements ApplicationListener {

    private static final int NULL_ID = 0xffffffff;

    private HashMap<Integer,Screen> screens;

    private int currentID;
    private Screen currentScreen;


    public Game(){
        screens = new HashMap<Integer, Screen>();
        currentID = NULL_ID;

    }

    protected boolean addScreen(Screen screen, int ID){
        if(screens.containsKey(ID)){
            return false;
        }
        if(currentID == NULL_ID){
            currentScreen = screen;
            currentID = ID;
            currentScreen.show();
        }
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
        this.currentID = ID;
        this.currentScreen = screens.get(ID);
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
