package com.semblergames.shaperush.animation.controllers;

import com.semblergames.shaperush.animation.AnimationController;
import com.semblergames.shaperush.animation.animations.ShakeAnimation;

public class ShakeAnimationController extends AnimationController<ShakeAnimation> {

    public ShakeAnimationController(ShakeAnimation[] animations) {
        super(animations);
    }

    public float getOffsetX(){
        if(running) {
            return this.animations[index].getOffsetX(time);
        }else{
            return 0;
        }
    }

    public float getOffsetY(){
        if(running) {
            return this.animations[index].getOffsetY(time);
        }else{
            return 0;
        }
    }

    public float getAngle(){
        if(running) {
            return this.animations[index].getAngle(time);
        }else{
            return 0;
        }
    }

    public float getLinearIntensity(){
        return this.animations[index].getLinearIntensity();
    }

    public float getAngularIntensity(){
        return this.animations[index].getAngularIntensity();
    }

    public ShakeAnimation.TransitionType getTransitionType(){
        return animations[index].getTransitionType();
    }

    public void shake(){
        restart();
    }

    @Deprecated
    public void shake(float time){
        animations[index].setDuration(time);
        restart();
    }

    @Deprecated
    public void shake(float time,float linearIntensity, float angularIntensity){
        animations[index].setDuration(time);
        animations[index].setLinearIntensity(linearIntensity);
        animations[index].setAngularIntensity(angularIntensity);
        restart();
    }

    @Deprecated
    public void shake(float time, float linearIntensity, float angularIntensity, ShakeAnimation.TransitionType transitionType){
        animations[index].setDuration(time);
        animations[index].setLinearIntensity(linearIntensity);
        animations[index].setAngularIntensity(angularIntensity);
        animations[index].setTransitionType(transitionType);
        restart();
    }

}
