package com.semblergames.shaperush.game;

import com.badlogic.gdx.assets.AssetManager;
import com.semblergames.shaperush.game.utils.AnimationSet;
import com.semblergames.shaperush.game.utils.Types;

public class RushingShape extends GameObject {


    private float vy;

    private Types.Color color;
    private Types.Shape shape;

    public RushingShape(AnimationSet animationSet){
        super(animationSet);
        yOffsetReaction = 0.2f;
        vy = 0f;
        color = Types.Color.RED;
        shape = Types.Shape.CIRCLE;
        colorIndex = color.getValue();
    }

    public void set(Types.Color color, Types.Shape shape, float x, float y, int lane){
        this.color = color;
        this.shape = shape;
        this.x = x;
        this.y = y;
        colorIndex = color.getValue();
    }

    @Override
    public void update(float delta){
        animation.changeAnimation(shape.getValue());
        animation.update(delta);
        y += vy*delta;
    }

    public Types.Color getColor() {
        return color;
    }

    public Types.Shape getShape() {
        return shape;
    }

    public void setShape(Types.Shape shape){
        this.shape = shape;
    }

    public void setColor(Types.Color color) {
        this.color = color;
        colorIndex = color.getValue();
    }

    public boolean intersects(GameObject obstacle){
        return this.y + yOffsetReaction > obstacle.y - obstacle.yOffsetReaction;
    }

    public static void loadRSTextures(AssetManager manager){

    }

    public static AnimationSet createRSAnimationSet(AssetManager manager){
        return null;
    }

    public static void unloadRSTextures(AssetManager manager){

    }

}
