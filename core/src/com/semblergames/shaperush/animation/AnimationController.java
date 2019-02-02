package com.semblergames.shaperush.animation;

public abstract class AnimationController<T extends Animation>{

    protected T [] animations;

    protected boolean running;
    protected int index;
    protected float time;

    public AnimationController(T [] animations){
        this.animations = animations;
        running = true;
        index = 0;
        time = 0;
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
                    if (time > animations[index].getDuration()) {
                        running = false;
                    }
                    break;
                }
                case LOOP:
                case LOOP_REVERSED: {
                    float duration = animations[index].getDuration();
                    if(time > duration){
                        time -= duration;
                    }
                    break;
                }
                case LOOP_PINGPONG: {
                    float duration2 = animations[index].getDuration()*2;
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
        return animations[index].isFinished(time);
    }

    public float getDuration(){
        return animations[index].getDuration();
    }

    public Animation.PlayMode getPlayMode(){
        return animations[index].getPlayMode();
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
        if(index == animations.length){
            index = 0;
        }
    }

    public void previousAnimation(){
        index--;
        if(index == -1){
            index = animations.length-1;
        }
    }

}
