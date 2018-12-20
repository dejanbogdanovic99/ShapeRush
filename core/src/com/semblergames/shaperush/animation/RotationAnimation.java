package com.semblergames.shaperush.animation;

import com.badlogic.gdx.math.MathUtils;

public class RotationAnimation extends Animation{

    public enum TransitionType {
        LINEAR,
        SIN
    }

    float startAngle;
    float endAngle;
    TransitionType transitionType = TransitionType.LINEAR;

    public RotationAnimation(float startAngle, float endAngle, float duration) {
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.duration = duration;
    }

    public RotationAnimation(float startAngle, float endAngle, float duration, TransitionType transitionType, PlayMode playMode) {
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.transitionType = transitionType;
        this.duration = duration;
        this.playMode = playMode;
    }

    public float getAngle(float stateTime) {

        if(startAngle == endAngle){
            return startAngle;
        }

        float angle = startAngle;

        switch (playMode) {
            case NORMAL: {
                if (stateTime < duration) {
                    if (transitionType == TransitionType.LINEAR) {
                        angle = (endAngle - startAngle) * stateTime / duration;
                    } else if (transitionType == TransitionType.SIN) {
                        angle = (endAngle - startAngle) * (1 + MathUtils.sinDeg(-90 + 180 * stateTime / duration)) / 2;
                    }
                } else {
                    angle = endAngle;
                }
                break;
            }
            case REVERSED: {
                if (stateTime < duration) {
                    if (transitionType == TransitionType.LINEAR) {
                        angle = (endAngle - startAngle) * (duration - stateTime) / duration;
                    } else if (transitionType == TransitionType.SIN) {
                        angle = (endAngle - startAngle) * (1 + MathUtils.sinDeg(-90 + 180 * (duration - stateTime) / duration)) / 2;
                    }
                } else {
                    angle = startAngle;
                }
                break;
            }
            case LOOP: {
                stateTime = stateTime % duration;

                if (transitionType == TransitionType.LINEAR) {
                    angle = (endAngle - startAngle) * stateTime / duration;
                } else if (transitionType == TransitionType.SIN) {
                    angle = (endAngle - startAngle) * (1 + MathUtils.sinDeg(-90 + 180 * stateTime / duration)) / 2;
                }
                break;
            }

            case LOOP_REVERSED: {
                stateTime = stateTime % duration;


                if (transitionType == TransitionType.LINEAR) {
                    angle = (endAngle - startAngle) * (duration - stateTime) / duration;
                } else if (transitionType == TransitionType.SIN) {
                    angle = (endAngle - startAngle) * (1 + MathUtils.sinDeg(-90 + 180 * (duration - stateTime) / duration)) / 2;
                }
                break;
            }
            case LOOP_PINGPONG: {

                stateTime = stateTime % (duration*2);

                if (transitionType == TransitionType.LINEAR) {
                    angle = (endAngle - startAngle) * (2*duration - stateTime) / duration;
                } else if (transitionType == TransitionType.SIN) {
                    angle = (endAngle - startAngle) * (1 + MathUtils.sinDeg(-90 + 180 * (2*duration - stateTime) / duration)) / 2;
                }
                break;
            }
        }


        return angle;
    }

    public void setStartAngle(float startAngle) {
        this.startAngle = startAngle;
    }

    public void setEndAngle(float endAngle) {
        this.endAngle = endAngle;
    }

    public void setTransitionType(TransitionType transitionType) {
        this.transitionType = transitionType;
    }

    public void setDuration(float duration){
        this.duration = duration;
    }

    public TransitionType getTransitionType() {
        return transitionType;
    }

    public float getStartAngle() {
        return startAngle;
    }

    public float getEndAngle() {
        return endAngle;
    }

}
