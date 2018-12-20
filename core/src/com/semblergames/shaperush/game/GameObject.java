package com.semblergames.shaperush.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Pool;
import com.semblergames.shaperush.animation.FrameAnimController;
import com.semblergames.shaperush.utils.SoundController;

public abstract class GameObject implements Pool.Poolable {

    protected FrameAnimController<TextureRegion> animations;

    protected SoundController sounds;

    protected float x;

    protected float y;

    protected float width;

    protected float height;

    protected int lane;

    protected float yOffsetReaction;

    public void draw(SpriteBatch batch){

        batch.draw(
                animations.getKeyFrame(),
                x,
                y,
                width, height
        );

    }

}
