package com.semblergames.shaperush.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;

public class GameLogger {

    long startTime;

    public GameLogger () {
        startTime = TimeUtils.nanoTime();
    }

    /** Logs the current frames per second to the console. */
    public void log () {
        if (TimeUtils.nanoTime() - startTime > 1000000000) /* 1,000,000,000ns == one second */{
            Gdx.app.log("GameLogger", "fps: " + Gdx.graphics.getFramesPerSecond());
            Gdx.app.log("GameLogger", "native heap: " + Gdx.app.getNativeHeap());
            Gdx.app.log("GameLogger", "java heap: " + Gdx.app.getJavaHeap());
            startTime = TimeUtils.nanoTime();
        }
    }

}
