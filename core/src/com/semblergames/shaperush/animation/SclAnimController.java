package com.semblergames.shaperush.animation;

public class SclAnimController extends AnimationController <ScaleAnimation>{

    public SclAnimController(){

    }

    public SclAnimController(ScaleAnimation [] animations){
        this.animations = animations;
    }


    public float getEndScale(){
        return animations[index].getEndScale();
    }

    public float getStartScale(){
        return animations[index].getStartScale();
    }

    public float getScale(){
        return animations[index].getScale(time);
    }

    public ScaleAnimation.TransitionType getTransitionType(){
        return animations[index].getTransitionType();
    }

    public void scale(){
        restart();
    }

}
