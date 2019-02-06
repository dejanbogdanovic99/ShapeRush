package com.semblergames.shaperush.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.semblergames.shaperush.Main;
import com.semblergames.shaperush.utils.Screen;
import com.semblergames.shaperush.utils.graphics.ColorShader;

public abstract class ShapeRushScreen extends Screen {

    Stage stage;

    Color background;

    InputMultiplexer input;

    public ShapeRushScreen(){
        super();
    }

    @Override
    public void create(){

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

}
