package com.semblergames.shaperush.animation;

public abstract class Animation {

    public enum PlayMode{
        NORMAL,
        REVERSED,
        LOOP,
        LOOP_REVERSED,
        LOOP_PINGPONG
    }

    float duration;
    PlayMode playMode = PlayMode.NORMAL;

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

    public boolean isFinished(float stateTime){
        return stateTime > duration;
    }

    public float getDuration() {
        return duration;
    }

    public PlayMode getPlayMode() {
        return playMode;
    }
}