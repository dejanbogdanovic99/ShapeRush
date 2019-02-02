package com.semblergames.shaperush.animation.animations;

import com.badlogic.gdx.math.MathUtils;
import com.semblergames.shaperush.animation.Animation;

public class TransitionAnimation extends Animation {

    public enum TransitionType {
        LINEAR,
        SIN
    }

    private float start;
    private float amount;
    private TransitionType transitionType = TransitionType.LINEAR;

    public TransitionAnimation(float start, float end, float duration) {
        super(duration);
        this.start = start;
        this.amount = end - start;
    }

    public TransitionAnimation(float start, float end, float duration, TransitionType transitionType, PlayMode playMode) {
        super(duration,playMode);
        this.start = start;
        this.amount = end - start;
        this.transitionType = transitionType;
    }

    public float getState(float stateTime) {

        if(amount == 0){
            return start;
        }

        float amount = start;

        switch (playMode) {
            case NORMAL: {
                if (stateTime < duration) {
                    if (transitionType == TransitionType.LINEAR) {
                        amount += this.amount * stateTime / duration;
                    } else if (transitionType == TransitionType.SIN) {
                        amount += this.amount * (1 + MathUtils.sinDeg(-90 + 180 * stateTime / duration)) / 2;
                    }
                } else {
                    amount += this.amount;
                }
                break;
            }
            case REVERSED: {
                if (stateTime < duration) {
                    if (transitionType == TransitionType.LINEAR) {
                        amount += this.amount * (duration - stateTime) / duration;
                    } else if (transitionType == TransitionType.SIN) {
                        amount += this.amount * (1 + MathUtils.sinDeg(-90 + 180 * (duration - stateTime) / duration)) / 2;
                    }
                } else {
                    amount = start;
                }
                break;
            }
            case LOOP: {
                stateTime = stateTime % duration;

                if (transitionType == TransitionType.LINEAR) {
                    amount += this.amount * stateTime / duration;
                } else if (transitionType == TransitionType.SIN) {
                    amount += this.amount * (1 + MathUtils.sinDeg(-90 + 180 * stateTime / duration)) / 2;
                }
                break;
            }

            case LOOP_REVERSED: {
                stateTime = stateTime % duration;

                if (transitionType == TransitionType.LINEAR) {
                    amount += this.amount * (duration - stateTime) / duration;
                } else if (transitionType == TransitionType.SIN) {
                    amount += this.amount * (1 + MathUtils.sinDeg(-90 + 180 * (duration - stateTime) / duration)) / 2;
                }
                break;
            }
            case LOOP_PINGPONG: {

                final float duration2 = duration * 2;

                stateTime = stateTime % duration2;

                if (transitionType == TransitionType.LINEAR) {
                    if(stateTime > duration) {
                        amount += this.amount * (duration2 - stateTime) / duration;
                    }else{
                        amount += this.amount * stateTime / duration;
                    }
                } else if (transitionType == TransitionType.SIN) {
                    if(stateTime > duration) {
                        amount += this.amount * (1 + MathUtils.sinDeg(-90 + 180 * (duration2 - stateTime) / duration)) / 2;
                    }else{
                        amount += this.amount * (1 + MathUtils.sinDeg(-90 + 180 * stateTime / duration)) / 2;
                    }
                }
                break;
            }
        }

        return amount;
    }

    public void setStart(float start) {
        this.amount += (this.start - start);
        this.start = start;
    }

    public void setEnd(float end) {
        this.amount = end - start;
    }

    public void setTransitionType(TransitionType transitionType) {
        this.transitionType = transitionType;
    }

    public TransitionType getTransitionType() {
        return transitionType;
    }

    public float getAmount() {
        return amount;
    }

    public float getStart() {
        return start;
    }

    public float getEnd() {
        return start + amount;
    }

}
