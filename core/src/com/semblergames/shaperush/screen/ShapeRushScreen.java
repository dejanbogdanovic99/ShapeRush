package com.semblergames.shaperush.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.semblergames.shaperush.Main;
import com.semblergames.shaperush.utils.Screen;
import com.semblergames.shaperush.utils.graphics.ColorShader;

public abstract class ShapeRushScreen extends Screen {

    public ShapeRushScreen(){
        super();
    }

    public ShapeRushScreen(Color bgColor){
        super(bgColor);
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
