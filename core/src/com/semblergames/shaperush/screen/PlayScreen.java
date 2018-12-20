package com.semblergames.shaperush.screen;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayScreen extends Screen {

    public PlayScreen(SpriteBatch batch, AssetManager manager) {
        super(batch, manager);
    }

    public PlayScreen(SpriteBatch batch, AssetManager manager, Color bgColor) {
        super(batch, manager, bgColor);
    }

    @Override
    protected void initialize() {

    }

    @Override
    public void dispose() {

    }
}
