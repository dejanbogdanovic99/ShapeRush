package com.semblergames.shaperush.game;

import com.badlogic.gdx.assets.AssetManager;
import com.semblergames.shaperush.game.utils.AnimationSet;

public class Barrier extends GameObject {


    public Barrier(AnimationSet animationSet) {
        super(animationSet);
    }

    @Override
    public void reset() {

    }



    public static void loadRSTextures(AssetManager manager){

    }

    public static AnimationSet createRSAnimationSet(AssetManager manager){
        return null;
    }

    public static void unloadRSTextures(AssetManager manager){

    }

}
