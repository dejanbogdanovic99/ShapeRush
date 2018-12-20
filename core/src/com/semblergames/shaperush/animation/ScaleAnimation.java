package com.semblergames.shaperush.animation;

import com.badlogic.gdx.math.MathUtils;

public class ScaleAnimation extends Animation{
    
    public enum TransitionType{
        LINEAR,
        SIN
    }
    
    float startScale;
    float scale;
    TransitionType transitionType = TransitionType.LINEAR;


    public ScaleAnimation(float startScale, float endScale, float duration) {
        super(duration);
        this.startScale = startScale;
        this.scale = endScale - startScale;
    }

    public ScaleAnimation(float startScale, float endScale, float duration, TransitionType transitionType, PlayMode playMode) {
        super(duration, playMode);
        this.startScale = startScale;
        this.scale = endScale - startScale;
        this.transitionType = transitionType;
    }

    public float getScale(float stateTime){
        
        if(scale == 0){
            return startScale;
        }
        
        float scale = startScale;

        switch (playMode) {
            case NORMAL: {
                if (stateTime < duration) {
                    if (transitionType == TransitionType.LINEAR) {
                        scale += this.scale * stateTime / duration;
                    } else if (transitionType == TransitionType.SIN) {
                        scale += this.scale * (1 + MathUtils.sinDeg(-90 + 180 * stateTime / duration)) / 2;
                    }
                } else {
                    scale += this.scale;
                }
                break;
            }
            case REVERSED: {
                if (stateTime < duration) {
                    if (transitionType == TransitionType.LINEAR) {
                        scale += this.scale * (duration - stateTime) / duration;
                    } else if (transitionType == TransitionType.SIN) {
                        scale += this.scale * (1 + MathUtils.sinDeg(-90 + 180 * (duration - stateTime) / duration)) / 2;
                    }
                } else {
                    scale = startScale;
                }
                break;
            }
            case LOOP: {
                stateTime = stateTime % duration;

                if (transitionType == TransitionType.LINEAR) {
                    scale += this.scale * stateTime / duration;
                } else if (transitionType == TransitionType.SIN) {
                    scale += this.scale * (1 + MathUtils.sinDeg(-90 + 180 * stateTime / duration)) / 2;
                }
                break;
            }

            case LOOP_REVERSED: {
                stateTime = stateTime % duration;

                if (transitionType == TransitionType.LINEAR) {
                    scale += this.scale * (duration - stateTime) / duration;
                } else if (transitionType == TransitionType.SIN) {
                    scale += this.scale * (1 + MathUtils.sinDeg(-90 + 180 * (duration - stateTime) / duration)) / 2;
                }
                break;
            }
            case LOOP_PINGPONG: {

                final float duration2 = duration * 2;

                stateTime = stateTime % duration2;

                if (transitionType == TransitionType.LINEAR) {
                    if(stateTime > duration) {
                        scale += this.scale * (duration2 - stateTime) / duration;
                    }else{
                        scale += this.scale * stateTime / duration;
                    }
                } else if (transitionType == TransitionType.SIN) {
                    if(stateTime > duration) {
                        scale += this.scale * (1 + MathUtils.sinDeg(-90 + 180 * (duration2 - stateTime) / duration)) / 2;
                    }else{
                        scale += this.scale * (1 + MathUtils.sinDeg(-90 + 180 * stateTime / duration)) / 2;
                    }
                }
                break;
            }
        }

        return scale;
    }

    public void setStartScale(float startScale) {
        this.scale += (this.startScale - startScale);
        this.startScale = startScale;
    }

    public void setEndScale(float endScale) {
        this.scale = endScale - startScale;
    }

    public void setTransitionType(TransitionType transitionType) {
        this.transitionType = transitionType;
    }

    public TransitionType getTransitionType() {
        return transitionType;
    }

    public float getTotalScale(){
        return scale;
    }

    public float getStartScale() {
        return startScale;
    }

    public float getEndScale() {
        return startScale + scale;
    }

}
