package com.semblergames.shaperush.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.NumberUtils;
import com.badlogic.gdx.utils.Pool;
import com.semblergames.shaperush.animation.AnimationController;
import com.semblergames.shaperush.animation.controllers.FrameAnimationController;
import com.semblergames.shaperush.game.utils.AnimationSet;
import com.semblergames.shaperush.utils.graphics.ColorShader;



public abstract class GameObject implements Pool.Poolable {

    protected AnimationController<TextureRegion> controller;

    protected float x;

    protected float y;

    protected float width;

    protected float height;

    protected float yOffsetReaction;

    protected int colorIndex;

    public GameObject(Animation<TextureRegion> [] animations){
        controller = new AnimationController<TextureRegion>(animations);
        colorIndex = ColorShader.rgb;
        width = 1;
        height = 1;
        x = 0;
        y = 0;
        yOffsetReaction = 0.1f;
    }


    @Override
    public void reset() {
        controller.reset();
    }

    public void update(float delta){
        controller.update(delta);
    }

    public void draw(SpriteBatch batch){

        batch.setColor(NumberUtils.intBitsToFloat(ColorShader.colorIndexes[colorIndex]));

        batch.draw(
                controller.getKeyFrame(),
                x - width/2,
                y - height/2,
                width, height
        );

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getyOffsetReaction() {
        return yOffsetReaction;
    }

    public int getColorIndex() {
        return colorIndex;
    }
}
