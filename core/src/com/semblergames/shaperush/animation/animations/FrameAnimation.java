package com.semblergames.shaperush.animation.animations;

import com.semblergames.shaperush.animation.Animation;

public class FrameAnimation <T> extends Animation {

    private T[] keyFrames;
    private float frameDuration;

    public FrameAnimation(float frameDuration, T ... keyFrames) {
        super(frameDuration * keyFrames.length);
        this.frameDuration = frameDuration;
        this.keyFrames = keyFrames;
    }

    public FrameAnimation(float frameDuration, PlayMode playMode, T ... keyFrames){
        super(frameDuration * keyFrames.length, playMode);
        this.frameDuration = frameDuration;
        this.keyFrames = keyFrames;
    }

    public float getFrameDuration() {
        return frameDuration;
    }

    public T[] getKeyFrames() {
        return keyFrames;
    }

    public T getKeyFrame(float stateTime){
        return keyFrames[getKeyFrameIndex(stateTime)];
    }

    public int getKeyFrameIndex(float stateTime){
        if(keyFrames.length == 1) return 0;

        int frameNumber = (int)(stateTime / frameDuration);
        switch (playMode) {
            case NORMAL:
                frameNumber = Math.min(keyFrames.length - 1, frameNumber);
                break;
            case LOOP:
                frameNumber = frameNumber % keyFrames.length;
                break;
            case LOOP_PINGPONG:
                frameNumber = frameNumber % ((keyFrames.length * 2) - 2);
                if (frameNumber >= keyFrames.length) frameNumber = keyFrames.length - 2 - (frameNumber - keyFrames.length);
                break;
            case REVERSED:
                frameNumber = Math.max(keyFrames.length - frameNumber - 1, 0);
                break;
            case LOOP_REVERSED:
                frameNumber = frameNumber % keyFrames.length;
                frameNumber = keyFrames.length - frameNumber - 1;
                break;
        }

        return frameNumber;
    }

    @Override
    public void setDuration(float duration) {
        super.setDuration(duration);
        frameDuration = duration / keyFrames.length;
    }

    public void setFrameDuration(float frameDuration) {
        duration = frameDuration * keyFrames.length;
        this.frameDuration = frameDuration;
    }

    public void setKeyFrames(T[] keyFrames){
        this.keyFrames = keyFrames;
        duration = frameDuration * keyFrames.length;
    }

}
