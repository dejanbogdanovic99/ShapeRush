package com.semblergames.shaperush.animation;

public class ShkAnimController extends AnimationController<ShakeAnimation>{

    public ShkAnimController() {}

    public ShkAnimController(ShakeAnimation[] animations) {
        this.animations = animations;
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
        return this.animations[index].linearIntensity;
    }

    public float getAngularIntensity(){
        return this.animations[index].angularIntensity;
    }

    public ShakeAnimation.TransitionType getTransitionType(){
        return animations[index].transitionType;
    }

    public void shake(){
        restart();
    }

    @Deprecated
    public void shake(float time){
        animations[index].duration = time;
        restart();
    }

    @Deprecated
    public void shake(float time,float linearIntensity, float angularIntensity){
        animations[index].duration = time;
        animations[index].linearIntensity = linearIntensity;
        animations[index].angularIntensity = angularIntensity;
        restart();
    }

    @Deprecated
    public void shake(float time, float linearIntensity, float angularIntensity, ShakeAnimation.TransitionType transitionType){
        animations[index].duration = time;
        animations[index].linearIntensity = linearIntensity;
        animations[index].angularIntensity = angularIntensity;
        animations[index].transitionType = transitionType;
        restart();
    }

}
