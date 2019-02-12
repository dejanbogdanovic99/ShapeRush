package com.semblergames.shaperush.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.semblergames.shaperush.Main;
import com.semblergames.shaperush.utils.Screen;
import com.semblergames.shaperush.utils.graphics.ColorShader;


public abstract class ShapeRushScreen extends Screen {

    Stage stage;

    InputMultiplexer input;


    @Override
    public void show(){
        Gdx.input.setInputProcessor(input);
    }

    @Override
    public void prepare(){
        stage = new Stage(new ExtendViewport(1080,1920),getBatch());
        input = new InputMultiplexer(stage);
    }

    @Override
    public void release(){
        stage.dispose();
        stage = null;
        input = null;
    }

    @Override
    public void hide() {}

    @Override
    public void resize(int width,int height){
        stage.getViewport().update(width,height,true);
    }

    @Override
    public void render(){
        stage.draw();
    }

    @Override
    public void update(float delta){
        stage.act(delta);
    }

    public AssetManager getManager(){
        return ((Main) Gdx.app.getApplicationListener()).getManager();
    }

    public SpriteBatch getBatch(){
        return ((Main) Gdx.app.getApplicationListener()).getBatch();
    }

    public ColorShader getColorShader(){
        return ((Main) Gdx.app.getApplicationListener()).getColorShader();
    }

    public ShapeRenderer getShapeRenderer(){
        return ((Main)Gdx.app.getApplicationListener()).getShapeRenderer();
    }

    public BitmapFont getBitmapFont(){
        return ((Main) Gdx.app.getApplicationListener()).getBitmapFont();
    }

}
