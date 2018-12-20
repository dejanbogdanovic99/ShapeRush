package com.semblergames.shaperush.utils;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class SoundController {

    private Sound [] sounds;

    private float range;

    public SoundController(){}

    public SoundController(float range){
        this.range = range;
    }

    public SoundController(Sound [] sounds){
        this.sounds = sounds;
    }

    public SoundController(float range, Sound [] sounds){
        this.sounds = sounds;
        this.range = range;
    }

    public void setSounds(Sound [] sounds){
        this.sounds = sounds;
    }

    public void setRange(float range){
        this.range = range;
    }

    public void play(int index, float x, float y, float camX, float camY, float masterVolume){
        if(masterVolume > 0) {
            float distance = Vector2.dst(x, y, camX, camY);
            float volume = 1;
            if (distance != 0) {
                if (distance >= range) {
                    volume = 0;
                } else {
                    volume = Math.min(1 / distance, 1);
                }
            }
            float pan = MathUtils.clamp((x - camX) / range, -1, 1);
            sounds[index].play(masterVolume * volume, 1, pan);
        }
    }

    public void play(int index,float volume, float pan, float masterVolume){
        if(masterVolume > 0) {
            sounds[index].play(masterVolume * volume, 1, pan);
        }
    }

}
