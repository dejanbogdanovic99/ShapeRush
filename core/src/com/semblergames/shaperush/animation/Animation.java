package com.semblergames.shaperush.animation;

public abstract class Animation {

    public enum PlayMode{
        NORMAL,
        REVERSED,
        LOOP,
        LOOP_REVERSED,
        LOOP_PINGPONG

    }

    protected float duration;
    protected PlayMode playMode = PlayMode.NORMAL;

    public Animation(){}

    public Animation(float duration) {
        this.duration = duration;
    }

    public Animation(float duration, PlayMode playMode) {
        this.duration = duration;
        this.playMode = playMode;
    }

    public void setPlayMode(PlayMode playMode) {
        this.playMode = playMode;
    }

    public void setDuration(float duration){
        this.duration = duration;
    }

    public boolean isFinished(float stateTime){
        if(playMode == PlayMode.LOOP_PINGPONG){
            return stateTime > 2*duration;
        }else {
            return stateTime > duration;
        }
    }

    public float getDuration() {
        return duration;
    }

    public PlayMode getPlayMode() {
        return playMode;
    }

}
