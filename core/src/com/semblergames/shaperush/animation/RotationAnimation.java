package com.semblergames.shaperush.animation;

import com.badlogic.gdx.math.MathUtils;

public class RotationAnimation extends Animation{

    public enum TransitionType {
        LINEAR,
        SIN
    }

    float startAngle;
    float angle;
    TransitionType transitionType = TransitionType.LINEAR;

    public RotationAnimation(float startAngle, float endAngle, float duration) {
        super(duration);
        this.startAngle = startAngle;
        this.angle = endAngle - startAngle;
    }

    public RotationAnimation(float startAngle, float endAngle, float duration, TransitionType transitionType, PlayMode playMode) {
        super(duration,playMode);
        this.startAngle = startAngle;
        this.angle = endAngle - startAngle;
        this.transitionType = transitionType;
    }

    public float getAngle(float stateTime) {

        if(angle == 0){
            return startAngle;
        }

        float angle = startAngle;

        switch (playMode) {
            case NORMAL: {
                if (stateTime < duration) {
                    if (transitionType == TransitionType.LINEAR) {
                        angle += this.angle * stateTime / duration;
                    } else if (transitionType == TransitionType.SIN) {
                        angle += this.angle * (1 + MathUtils.sinDeg(-90 + 180 * stateTime / duration)) / 2;
                    }
                } else {
                    angle += this.angle;
                }
                break;
            }
            case REVERSED: {
                if (stateTime < duration) {
                    if (transitionType == TransitionType.LINEAR) {
                        angle += this.angle * (duration - stateTime) / duration;
                    } else if (transitionType == TransitionType.SIN) {
                        angle += this.angle * (1 + MathUtils.sinDeg(-90 + 180 * (duration - stateTime) / duration)) / 2;
                    }
                } else {
                    angle = startAngle;
                }
                break;
            }
            case LOOP: {
                stateTime = stateTime % duration;

                if (transitionType == TransitionType.LINEAR) {
                    angle += this.angle * stateTime / duration;
                } else if (transitionType == TransitionType.SIN) {
                    angle += this.angle * (1 + MathUtils.sinDeg(-90 + 180 * stateTime / duration)) / 2;
                }
                break;
            }

            case LOOP_REVERSED: {
                stateTime = stateTime % duration;

                if (transitionType == TransitionType.LINEAR) {
                    angle += this.angle * (duration - stateTime) / duration;
                } else if (transitionType == TransitionType.SIN) {
                    angle += this.angle * (1 + MathUtils.sinDeg(-90 + 180 * (duration - stateTime) / duration)) / 2;
                }
                break;
            }
            case LOOP_PINGPONG: {

                final float duration2 = duration * 2;

                stateTime = stateTime % duration2;

                if (transitionType == TransitionType.LINEAR) {
                    if(stateTime > duration) {
                        angle += this.angle * (duration2 - stateTime) / duration;
                    }else{
                        angle += this.angle * stateTime / duration;
                    }
                } else if (transitionType == TransitionType.SIN) {
                    if(stateTime > duration) {
                        angle += this.angle * (1 + MathUtils.sinDeg(-90 + 180 * (duration2 - stateTime) / duration)) / 2;
                    }else{
                        angle += this.angle * (1 + MathUtils.sinDeg(-90 + 180 * stateTime / duration)) / 2;
                    }
                }
                break;
            }
        }

        return angle;
    }

    public void setStartAngle(float startAngle) {
        this.angle += (this.startAngle - startAngle);
        this.startAngle = startAngle;
    }

    public void setEndAngle(float endAngle) {
        this.angle = endAngle - startAngle;
    }

    public void setTransitionType(TransitionType transitionType) {
        this.transitionType = transitionType;
    }

    public TransitionType getTransitionType() {
        return transitionType;
    }

    public float getTotalAngle() {
        return angle;
    }

    public float getStartAngle() {
        return startAngle;
    }

    public float getEndAngle() {
        return startAngle + angle;
    }

}
