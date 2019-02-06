package com.semblergames.shaperush.utils;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

public abstract class Screen {

    /** Constructor
     */

    public Screen(){ }


    /** Requests {@link Screen} with following ID
     * @param ID next screen's ID
     */

    protected final void requestScreen(int ID){
        ((Game)Gdx.app.getApplicationListener()).requestScreen(ID);
    }

    /** Creation of the screen, this is where you should initialize textures and stuff that is disposed of in {@link #dispose()} */
    public abstract void create();

    /** Called immediately before the screen becomes current for a {@link Game} */
    public void show(){}

    /** Called when screen should prepare before becoming current */
    public void prepare(){}

    /** Called when the screen should ne longer be current for a {@link Game} */
    public void hide(){}

    /** @see ApplicationListener#resize(int, int) */
    public void resize(int width, int height){}

    /** Called for rendering */
    public void render(){}

    /** Called for updating */
    public void update(float delta){}

    /** @see ApplicationListener#pause() */
    public void pause(){}

    /** @see ApplicationListener#resume() */
    public void resume(){}

    /** Called when this screen should release all it`s resources. */
    public abstract void dispose();

}
