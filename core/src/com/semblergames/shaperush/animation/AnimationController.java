package com.semblergames.shaperush.animation;

public abstract class AnimationController<T extends Animation>{

    T [] animations;

    boolean running;
    int index;
    float time;

    public AnimationController(){}

    public AnimationController(T [] animations){
        this.animations = animations;
    }

    public void setAnimations(T [] animations){
        this.animations = animations;
    }

    public void update(float delta){
        if(running){
            time += delta;
            switch(animations[index].playMode){
                case NORMAL:
                case REVERSED: {
                    if (time > animations[index].duration) {
                        running = false;
                    }
                    break;
                }
                case LOOP:
                case LOOP_REVERSED: {
                    float duration = animations[index].duration;
                    if(time > duration){
                        time -= duration;
                    }
                    break;
                }
                case LOOP_PINGPONG: {
                    float duration2 = animations[index].duration*2;
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

    public boolean isRunning() {
        return running;
    }

    public boolean isFinished(){
        return animations[index].isFinished(time);
    }

    public float getDuration(){
        return animations[index].duration;
    }

    public Animation.PlayMode getPlayMode(){
        return animations[index].playMode;
    }

    public void changeAnimation(int index){
        this.index = index;
        time = 0;
        running = false;
    }

    public void nextAnimation(){
        index++;
        if(index == animations.length){
            index = 0;
        }
        time = 0;
        running = false;
    }

    public void previousAnimation(){
        index--;
        if(index == -1){
            index = animations.length-1;
        }
        time = 0;
        running = false;
    }

}
