package com.semblergames.shaperush.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Pool;
import com.semblergames.shaperush.animation.controllers.FrameAnimationController;
import com.semblergames.shaperush.game.utils.AnimationSet;
import com.semblergames.shaperush.utils.graphics.ColorShader;

public abstract class GameObject implements Pool.Poolable {

    protected FrameAnimationController<TextureRegion> animation;

    protected float x;

    protected float y;

    protected float halfWidth;

    protected float halfHeight;

    protected float yOffsetReaction;

    protected int colorIndex;

    public GameObject(AnimationSet animationSet){
        this.animation = new FrameAnimationController<TextureRegion>(animationSet.getFrameAnimations());
        halfWidth = 0.5f;
        halfHeight = 0.5f;
        colorIndex = 0;
    }

    @Override
    public void reset() {
        animation.reset();
    }

    public void update(float delta){
        animation.update(delta);
    }

    public void draw(SpriteBatch batch){

        batch.setColor(ColorShader.color_indexes[colorIndex]);

        batch.draw(
                animation.getKeyFrame(),
                x - halfWidth,
                y - halfHeight,
                halfWidth*2, halfHeight*2
        );

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return halfWidth*2;
    }

    public float getHeight() {
        return halfHeight*2;
    }

    public float getyOffsetReaction() {
        return yOffsetReaction;
    }

    public int getColorIndex() {
        return colorIndex;
    }
}
