package com.semblergames.shaperush.animation;

import com.badlogic.gdx.math.MathUtils;

public class ShakeAnimation extends Animation{

    public enum TransitionType{
        CONSTANT,
        PEAK
    }

    float linearIntensity;
    float angularIntensity;
    TransitionType transitionType = TransitionType.CONSTANT;

    public ShakeAnimation(float linearIntensity, float angularIntensity, float duration) {
        this.linearIntensity = linearIntensity;
        this.angularIntensity = angularIntensity;
        this.duration = duration;
    }

    public ShakeAnimation(float linearIntensity, float angularIntensity, float duration, TransitionType transitionType, PlayMode playMode) {
        this.linearIntensity = linearIntensity;
        this.angularIntensity = angularIntensity;
        this.duration = duration;
        this.transitionType = transitionType;
        if(playMode == PlayMode.LOOP_PINGPONG || playMode == PlayMode.LOOP_REVERSED || playMode == PlayMode.REVERSED){
            this.playMode = PlayMode.NORMAL;
        }else{
            this.playMode = playMode;
        }
    }

    public float getAngle(float stateTime) {
        return getOffset(stateTime, angularIntensity);
    }

    public float getOffsetX(float stateTime){
        return getOffset(stateTime,linearIntensity);
    }

    public float getOffsetY(float stateTime){
        return getOffset(stateTime, linearIntensity);
    }

    private float getOffset(float stateTime, float intensity){
        if(intensity == 0 || duration == 0){
            return 0;
        }

        float offset = intensity * MathUtils.random(-1f,1f);

        if(playMode == PlayMode.LOOP){
            stateTime %= duration;
        }else if(stateTime > duration){
            return 0;
        }


        if(transitionType == TransitionType.PEAK){
            offset *= (1+MathUtils.sinDeg(-90 + 360 * (stateTime/duration)))/2;
        }

        return offset;
    }
/*
    @Override
    public void setPlayMode(PlayMode playMode){
        if(playMode == PlayMode.LOOP_PINGPONG || playMode == PlayMode.LOOP_REVERSED || playMode == PlayMode.REVERSED){
            this.playMode = PlayMode.NORMAL;
        }else{
            this.playMode = playMode;
        }
    }
*/
    public void setDuration(float duration){
        this.duration = duration;
    }

    public void setLinearIntensity(float linearIntensity) {
        this.linearIntensity = linearIntensity;
    }

    public void setAngularIntensity(float angularIntensity) {
        this.angularIntensity = angularIntensity;
    }

    public void setTransitionType(TransitionType transitionType) {
        this.transitionType = transitionType;
    }

    public float getLinearIntensity() {
        return linearIntensity;
    }

    public float getAngularIntensity() {
        return angularIntensity;
    }

    public TransitionType getTransitionType() {
        return transitionType;
    }

}
