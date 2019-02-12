package com.semblergames.shaperush.utils.graphics.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TransformDrawable;
import com.semblergames.shaperush.animation.controllers.FrameAnimationController;
import com.semblergames.shaperush.animation.controllers.TransitionAnimationController;
import com.semblergames.shaperush.game.utils.AnimationSet;
import com.semblergames.shaperush.utils.graphics.ColorShader;

public class Animation extends Image{

 /*   private FrameAnimationController<TextureRegionDrawable> frameAC;
    private TransitionAnimationController rotationAC;
    private TransitionAnimationController scaleAC;

    private int colorIndex;

    public Animation(AnimationSet<TextureRegionDrawable> animationSet){
        super();
        frameAC = new FrameAnimationController<TextureRegionDrawable>(animationSet.getFrameAnimations());
        rotationAC = new TransitionAnimationController(animationSet.getRotationAnimations());
        scaleAC = new TransitionAnimationController(animationSet.getScaleAnimations());
        colorIndex = 0;
    }

    @Override
    public void act(float delta){
        super.act(delta);
        frameAC.update(delta);
        setDrawable(frameAC.getKeyFrame());
        rotationAC.update(delta);
        scaleAC.update(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        validate();

        batch.setColor(ColorShader.color_indexes[colorIndex]);

        float x = getX();
        float y = getY();
        float scaleX = getScaleX();
        float scaleY = getScaleY();

        Drawable drawable = getDrawable();

        if (drawable instanceof TransformDrawable) {
            float rotation = getRotation();
            if (scaleX != 1 || scaleY != 1 || rotation != 0) {
                ((TransformDrawable)drawable).draw(batch, x + getImageX(), y + getImageY(), getOriginX() - getImageX(), getOriginY() - getImageY(),
                        getImageWidth(), getImageHeight(), scaleX, scaleY, rotation);
                return;
            }
        }
        if (drawable != null) drawable.draw(batch, x + getImageX(), y + getImageY(), getImageWidth() * scaleX, getImageHeight() * scaleY);
    }*/

}
