package com.semblergames.shaperush.screen;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.semblergames.shaperush.Game;

public abstract class Screen {

    /** Background color of the screen */
    Color bgColor;

    /** Input handler for the the screen */
    InputMultiplexer input;

    /** Batch
     *  Should be taken from {@link Game}
     */
    SpriteBatch batch;

    /** Assets
     * Should be taken from {@link Game}
     */
    AssetManager manager;

    /** Constructor with {@link Color} WHITE background
     * @param batch taken from {@link Game}
     * @param manager taken from {@link Game}
     */

    public Screen(SpriteBatch batch, AssetManager manager){
        this(batch,manager, Color.WHITE);
    }

    public Screen(SpriteBatch batch, AssetManager manager ,Color bgColor){

        this.bgColor = new Color(bgColor);
        this.input = new InputMultiplexer();
        this.batch = batch;
        this.manager = manager;
    }

    /** Requests {@link Screen} with following ID
     * @param ID next screen's ID
     */

    public final void requestScreen(int ID){
        ((Game)Gdx.app.getApplicationListener()).requestScreen(ID);
    }

    /** Initializer */

    protected abstract void initialize();

    /** Called immediately before the screen becomes current for a {@link Game} */
    public void show(){
        Gdx.input.setInputProcessor(input);
    }

    /** Called when screen should prepare before becoming current */
    public void prepare(){}

    /** Called when the screen should ne longer be current for a {@link Game} */
    public void hide(){}

    /** @see ApplicationListener#resize(int, int) */
    public void resize(int width, int height){}

    /** Called for rendering */
    public void render(){
        Gdx.gl.glClearColor(bgColor.r,bgColor.g,bgColor.b,bgColor.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    /** Called for updating */
    public void update(float delta){}

    /** @see ApplicationListener#pause() */
    public void pause(){}

    /** @see ApplicationListener#resume() */
    public void resume(){}

    /** Called when this screen should release all it`s resources. */
    public abstract void dispose();

}
