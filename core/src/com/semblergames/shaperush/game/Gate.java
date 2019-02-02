package com.semblergames.shaperush.game;

import com.badlogic.gdx.assets.AssetManager;
import com.semblergames.shaperush.game.utils.AnimationSet;
import com.semblergames.shaperush.game.utils.Types;

public class Gate extends GameObject {


    private Types.Color color1;
    private Types.Color color2;

    private Types.Shape shape1;
    private Types.Shape shape2;

    public Gate(AnimationSet animationSet) {
        super(animationSet);
        yOffsetReaction = 0.1f;
        color1 = Types.Color.RED;
        color2 = Types.Color.SPECIAL;
        shape1 = Types.Shape.CIRCLE;
        shape2 = Types.Shape.SPECIAL;
    }

    public void set(Types.Color c1, Types.Color c2, Types.Shape s1, Types.Shape s2, float x, float y){
        this.color1 = c1;
        this.color2 = c2;
        this.shape1 = s1;
        this.shape2 = s2;
    }

    @Override
    public void reset() {

    }


    public Types.Color getColor1() {
        return color1;
    }

    public Types.Color getColor2() {
        return color2;
    }

    public Types.Shape getShape1() {
        return shape1;
    }

    public Types.Shape getShape2() {
        return shape2;
    }

    public static void loadGTextures(AssetManager manager){

    }

    public static AnimationSet createGAnimationSet(AssetManager manager){
        return null;
    }

    public static void unloadGTextures(AssetManager manager){

    }

}
