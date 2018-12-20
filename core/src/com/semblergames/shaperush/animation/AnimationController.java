package com.semblergames.shaperush.animation;

public abstract class AnimationController<T extends Animation>{

    T [] animations;

    boolean running;
    int index;
    float time;

    public AnimationController(){
    }

    public AnimationController(T [] animations){
        this.animations = animations;
    }

    public void setAnimations(T [] animations){
        this.animations = animations;
    }

    public void update(float delta){
        if(running){
            time += delta;
            switch(animations[index].getPlayMode()){
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

    public void changeAnimation(int index){
        this.index = index;
        time = 0;
        running = false;
    }

}
