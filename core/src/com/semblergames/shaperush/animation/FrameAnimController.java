package com.semblergames.shaperush.animation;

public class FrameAnimController<T> extends AnimationController <FrameAnimation<T>> {

    public FrameAnimController(){}

    public FrameAnimController(FrameAnimation<T> [] animations){
        this.animations = animations;
    }

    public int getKeyFrameIndex(){
        return animations[index].getKeyFrameIndex(time);
    }

    public T getKeyFrame(){
        return animations[index].getKeyFrame(time);
    }

    public float getFrameDuration(){
        return animations[index].frameDuration;
    }

    public void setFrameIndex(int index){
        time = animations[this.index].frameDuration*index;
    }
}
