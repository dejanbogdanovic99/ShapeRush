package com.semblergames.shaperush.utils;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.MathUtils;

public class AnimationController <T>{

    private Animation<T> [] animations;

    private boolean running;

    private int index;

    private float time;

    private float offsetX;

    private float offsetY;

    private float angle;

    private float shakeTime;

    public AnimationController(Animation <T> [] animations){
        this.animations = animations;

        index = 0;
        restart();
    }

    public void setAnimations(Animation <T> [] animations){
        this.animations = animations;

        index = 0;
        restart();
    }

    public void update(float delta){
        if(running) {
            time += delta;
            if (animations.length > 0) {
                if (animations[index].getPlayMode() == Animation.PlayMode.LOOP_PINGPONG) {
                    if (time > 2 * animations[index].getAnimationDuration()) {
                        time -= 2 * animations[index].getAnimationDuration();
                    }
                } else {
                    if (time > animations[index].getAnimationDuration()) {
                        time -= animations[index].getAnimationDuration();
                    }
                }

            }

            if (shakeTime > 0) {
                shakeTime -= delta;
                offsetX = MathUtils.random(-10f, 10f);

                offsetY = MathUtils.random(-10f, 10f);

                angle = MathUtils.random(-2f,2f);
            } else {
                offsetX = 0;
                offsetY = 0;
                angle = 0;
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

        offsetX = 0;
        offsetY = 0;
        angle = 0;
        shakeTime = 0;

        running = true;
    }

    public void stop(){
        restart();
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public void shake(float time){
        shakeTime = time;
    }

    public void stopShake(){
        shakeTime = 0;
    }

    public float getOffsetX() {
        return offsetX;
    }

    public float getOffsetY() {
        return offsetY;
    }

    public float getAngle(){
        return angle;
    }

    public T getKeyFrame(){
        return animations[index].getKeyFrame(time);
    }

    public int getKeyFrameIndex(){
        return animations[index].getKeyFrameIndex(time);
    }

    public void changeAnimation(int i){
        index = i;
        time = 0;
    }

    public void nextAnimation(){
        index++;
        time = 0;
        if(index == animations.length){
            index = 0;
        }
    }

    public void previousAnimation(){
        index--;
        time = 0;
        if(index == 0){
            index = animations.length-1;
        }
    }

}
