package com.semblergames.shaperush.animation;

public class RotAnimController extends AnimationController <RotationAnimation>{


    public RotAnimController(){}

    public RotAnimController(RotationAnimation [] animations){
        this.animations = animations;
    }

    public float getEndAngle(){
        return animations[index].getEndAngle();
    }

    public float getStartAngle(){
        return animations[index].startAngle;
    }

    public float getAngle(){
        return animations[index].getAngle(time);
    }

    public RotationAnimation.TransitionType getTransitionType(){
        return animations[index].transitionType;
    }

    public void rotate(){
        restart();
    }

}
