package com.semblergames.shaperush.animation;

public class RotAnimController extends AnimationController <RotationAnimation>{


    public RotAnimController(){

    }

    public RotAnimController(RotationAnimation [] animations){
        this.animations = animations;
    }

    public float getEndAngle(){
        return animations[index].getEndAngle();
    }

    public float getStartAngle(){
        return animations[index].getStartAngle();
    }

    public float getAngle(){
        return animations[index].getAngle(time);
    }

    public RotationAnimation.TransitionType getTransitionType(){
        return animations[index].getTransitionType();
    }

    public void rotate(){
        restart();
    }



}
