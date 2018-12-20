package com.semblergames.shaperush.animation;

public class ShkAnimController extends AnimationController<ShakeAnimation>{

    public ShkAnimController() {
    }

    public ShkAnimController(ShakeAnimation[] animations) {
        this.animations = animations;
    }

    public float getOffsetX(){
        return this.animations[index].getOffsetX(time);
    }

    public float getOffsetY(){
        return this.animations[index].getOffsetY(time);
    }

    public float getAngle(){
        return this.animations[index].getAngle(time);
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

    public void shake(float time){
        animations[index].duration = time;
        restart();
    }

    public void shake(float time,float linearIntensity, float angularIntensity){
        animations[index].duration = time;
        animations[index].linearIntensity = linearIntensity;
        animations[index].angularIntensity = angularIntensity;
        restart();
    }


    public void shake(float time, float linearIntensity, float angularIntensity, ShakeAnimation.TransitionType transitionType){
        animations[index].duration = time;
        animations[index].linearIntensity = linearIntensity;
        animations[index].angularIntensity = angularIntensity;
        animations[index].transitionType = transitionType;
        restart();
    }

}
