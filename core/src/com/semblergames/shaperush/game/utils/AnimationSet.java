package com.semblergames.shaperush.game.utils;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.semblergames.shaperush.animation.animations.FrameAnimation;
import com.semblergames.shaperush.animation.animations.ShakeAnimation;
import com.semblergames.shaperush.animation.animations.TransitionAnimation;

public class AnimationSet {

    private FrameAnimation<TextureRegion> [] frameAnimations;
    private TransitionAnimation[] rotationAnimations;
    private TransitionAnimation[] scaleAnimations;
    private TransitionAnimation[] fadeAnimations;
    private ShakeAnimation[] shakeAnimations;

    public AnimationSet(){}

    public void addAllFrameAnimations(FrameAnimation<TextureRegion> ... frameAnimations){
        this.frameAnimations = frameAnimations;
    }

    public void addAllRotationAnimations(TransitionAnimation ... rotationAnimations){
        this.rotationAnimations = rotationAnimations;
    }

    public void addAllScaleAnimations(TransitionAnimation ... scaleAnimations){
        this.scaleAnimations = scaleAnimations;
    }

    public void addAllShakeAnimations(ShakeAnimation ... shakeAnimations){
        this.shakeAnimations = shakeAnimations;
    }

    public void addAllFadeAnimations(TransitionAnimation ... fadeAnimations){
        this.fadeAnimations = fadeAnimations;
    }

    public FrameAnimation<TextureRegion>[] getFrameAnimations() {
        return frameAnimations;
    }

    public TransitionAnimation[] getRotationAnimations() {
        return rotationAnimations;
    }

    public TransitionAnimation[] getScaleAnimations() {
        return scaleAnimations;
    }

    public TransitionAnimation [] getFadeAnimations(){
        return fadeAnimations;
    }

    public ShakeAnimation[] getShakeAnimations() {
        return shakeAnimations;
    }
}
