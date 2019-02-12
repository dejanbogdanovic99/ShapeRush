package com.semblergames.shaperush.animation;


import com.badlogic.gdx.graphics.g2d.Animation;

public class AnimationController <T>{

    protected com.badlogic.gdx.graphics.g2d.Animation<T> [] animations;

    protected boolean running;
    protected int index;
    protected float time;

    public AnimationController(com.badlogic.gdx.graphics.g2d.Animation<T>[] animations){
        this.animations = animations;
        running = true;
        index = 0;
        time = 0;
    }

    public void setAnimations(com.badlogic.gdx.graphics.g2d.Animation<T> [] animations){
        this.animations = animations;
    }

    public void update(float delta){
        if(running){
            time += delta;
            switch(animations[index].getPlayMode()){
                case NORMAL:
                case REVERSED: {
                    if (time > animations[index].getAnimationDuration()) {
                        running = false;
                    }
                    break;
                }
                case LOOP:
                case LOOP_REVERSED: {
                    float duration = animations[index].getAnimationDuration();
                    if(time > duration){
                        time -= duration;
                    }
                    break;
                }
                case LOOP_PINGPONG: {
                    float duration2 = animations[index].getAnimationDuration()*2;
                    if(time > duration2){
                        time -= duration2;
                    }
                    break;
                }
            }
        }
    }

    public void pause(){
        running = false;
    }

    public void start(){
        running = true;
    }

    public void restart(){
        time = 0;
        running = true;
    }

    public void stop(){
        time = 0;
        running = false;
    }

    public void reset(){
        index = 0;
        time = 0;
        running = true;
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isFinished(){
        return animations[index].isAnimationFinished(time);
    }


    public float getAnimationDuration(){
        return animations[index].getAnimationDuration();
    }

    public Animation.PlayMode getPlayMode(){
        return animations[index].getPlayMode();
    }

    public T getKeyFrame(){
        return animations[index].getKeyFrame(time);
    }

    public float getFrameDuration(){
        return animations[index].getFrameDuration();
    }

    public boolean changeAnimation(int index){
        if(index < animations.length && index >= 0) {
            this.index = index;
            return true;
        }
        return false;
    }

    public void nextAnimation(){
        index++;
        if(index >= animations.length){
            index = 0;
        }
    }

    public void previousAnimation(){
        index--;
        if(index < 0){
            index = animations.length-1;
        }
    }

}
