package com.semblergames.shaperush.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Pool;
import com.semblergames.shaperush.utils.AnimationController;
import com.semblergames.shaperush.utils.SoundController;

public abstract class GameObject implements Pool.Poolable {

    protected AnimationController<TextureRegion> animations;

    protected SoundController sounds;

    protected float x;

    protected float y;

    protected float width;

    protected float height;

    protected int lane;

    protected float yOffsetReaction;

    private static float [] vertices = new float[20];

    public void draw(SpriteBatch batch){

        if(animations.getAngle() != 0){
            batch.draw(
                    animations.getKeyFrame(),
                    animations.getOffsetX() + x,
                    animations.getOffsetY() + y,
                    width/2,
                    height/2,
                    width, height,
                    1,1,
                    animations.getAngle()
            );
        }else {

            batch.draw(
                    animations.getKeyFrame(),
                    animations.getOffsetX() + x,
                    animations.getOffsetY() + y,
                    width, height
            );
        }

    }

}
