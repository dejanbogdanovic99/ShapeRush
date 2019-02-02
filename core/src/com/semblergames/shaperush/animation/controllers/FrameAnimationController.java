package com.semblergames.shaperush.animation.controllers;

import com.semblergames.shaperush.animation.AnimationController;
import com.semblergames.shaperush.animation.animations.FrameAnimation;

public class FrameAnimationController<T> extends AnimationController<FrameAnimation<T>> {

    public FrameAnimationController(FrameAnimation<T> [] animations){
        super(animations);
    }

    public int getKeyFrameIndex(){
        return animations[index].getKeyFrameIndex(time);
    }

    public T getKeyFrame(){
        return animations[index].getKeyFrame(time);
    }

    public float getFrameDuration(){
        return animations[index].getFrameDuration();
    }

    public void setFrameIndex(int index){
        time = animations[this.index].getFrameDuration()*index;
    }
}
