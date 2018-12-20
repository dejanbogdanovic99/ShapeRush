package com.semblergames.shaperush.screen;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.semblergames.shaperush.utils.graphics.ColorShader;

/**
 * TODO resiti klasu
 */
public class MainMenuScreen extends Screen {

    private ColorShader colorShader;

    public MainMenuScreen(ColorShader colorShader, SpriteBatch batch, AssetManager manager) {
        super(batch, manager);
        this.colorShader = colorShader;

    }

    public MainMenuScreen(ColorShader colorShader,SpriteBatch batch, AssetManager manager, Color bgColor) {
        super(batch, manager, bgColor);
        this.colorShader = colorShader;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }

    @Override
    public void dispose() {

    }
}
