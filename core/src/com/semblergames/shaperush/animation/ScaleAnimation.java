package com.semblergames.shaperush.animation;

import com.badlogic.gdx.math.MathUtils;

public class ScaleAnimation extends Animation{
    
    public enum TransitionType{
        LINEAR,
        SIN
    }
    
    float startScale;
    float endScale;
    TransitionType transitionType = TransitionType.LINEAR;


    public ScaleAnimation(float startScale, float endScale, float duration) {
        this.startScale = startScale;
        this.endScale = endScale;
        this.duration = duration;
    }

    public ScaleAnimation(float startScale, float endScale, float duration, TransitionType transitionType, PlayMode playMode) {
        this.startScale = startScale;
        this.endScale = endScale;
        this.duration = duration;
        this.transitionType = transitionType;
        this.playMode = playMode;
    }

    public float getScale(float stateTime){
        
        if(startScale == endScale){
            return startScale;
        }
        
        float scale = startScale;

        switch (playMode) {
            case NORMAL: {
                if (stateTime < duration) {
                    if (transitionType == TransitionType.LINEAR) {
                        scale = startScale + (endScale - startScale) * stateTime / duration;
                    } else if (transitionType == TransitionType.SIN) {
                        scale = startScale + (endScale - startScale) * (1 + MathUtils.sinDeg(-90 + 180 * stateTime / duration)) / 2;
                    }
                } else {
                    scale = endScale;
                }
                break;
            }
            case REVERSED: {
                if (stateTime < duration) {
                    if (transitionType == TransitionType.LINEAR) {
                        scale = startScale + (endScale - startScale) * (duration - stateTime) / duration;
                    } else if (transitionType == TransitionType.SIN) {
                        scale = startScale +(endScale - startScale) * (1 + MathUtils.sinDeg(-90 + 180 * (duration - stateTime) / duration)) / 2;
                    }
                } else {
                    scale = startScale;
                }
                break;
            }
            case LOOP: {
                stateTime = stateTime % duration;

                if (transitionType == TransitionType.LINEAR) {
                    scale = startScale + (endScale - startScale) * stateTime / duration;
                } else if (transitionType == TransitionType.SIN) {
                    scale = startScale + (endScale - startScale) * (1 + MathUtils.sinDeg(-90 + 180 * stateTime / duration)) / 2;
                }
                break;
            }

            case LOOP_REVERSED: {
                stateTime = stateTime % duration;


                if (transitionType == TransitionType.LINEAR) {
                    scale = startScale + (endScale - startScale) * (duration - stateTime) / duration;
                } else if (transitionType == TransitionType.SIN) {
                    scale = startScale + (endScale - startScale) * (1 + MathUtils.sinDeg(-90 + 180 * (duration - stateTime) / duration)) / 2;
                }
                break;
            }
            case LOOP_PINGPONG: {

                stateTime = stateTime % (duration*2);

                if (transitionType == TransitionType.LINEAR) {
                    scale = startScale + (endScale - startScale) * (2*duration - stateTime) / duration;
                } else if (transitionType == TransitionType.SIN) {
                    scale = startScale + (endScale - startScale) * (1 + MathUtils.sinDeg(-90 + 180 * (2*duration - stateTime) / duration)) / 2;
                }
                break;
            }
        }

        return scale;
    }

    public void setDuration(float duration){
        this.duration = duration;
    }

    public void setStartScale(float startScale) {
        this.startScale = startScale;
    }

    public void setEndScale(float endScale) {
        this.endScale = endScale;
    }

    public void setTransitionType(TransitionType transitionType) {
        this.transitionType = transitionType;
    }

    public float getStartScale() {
        return startScale;
    }

    public float getEndScale() {
        return endScale;
    }

    public TransitionType getTransitionType() {
        return transitionType;
    }

}
