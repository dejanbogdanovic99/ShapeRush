package com.semblergames.shaperush.utils;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

public abstract class Screen {

     /** Background color of the screen */
    protected Color bgColor;

    /** Input handler for the the screen */
    protected InputMultiplexer input;


    /** Constructor with {@link Color} WHITE background
     */

    public Screen(){
        this(Color.WHITE);
    }

    public Screen(Color bgColor){

        this.bgColor = new Color(bgColor);
        this.input = new InputMultiplexer();
    }

    /** Requests {@link Screen} with following ID
     * @param ID next screen's ID
     */

    protected final void requestScreen(int ID){
        ((Game)Gdx.app.getApplicationListener()).requestScreen(ID);
    }

    /** Initializer */
    public abstract void create();

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
