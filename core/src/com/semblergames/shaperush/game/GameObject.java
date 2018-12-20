package com.semblergames.shaperush.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Pool;
import com.semblergames.shaperush.animation.FrameAnimController;
import com.semblergames.shaperush.utils.SoundController;

public abstract class GameObject implements Pool.Poolable {

    FrameAnimController<TextureRegion> animations;

    SoundController sounds;

    float x;

    float y;

    float width;

    float height;

    int lane;

    float yOffsetReaction;

    @Override
    public void reset() {

    }

    public void draw(SpriteBatch batch){

        batch.draw(
                animations.getKeyFrame(),
                x - width/2,
                y - height/2,
                width, height
        );

    }

}
