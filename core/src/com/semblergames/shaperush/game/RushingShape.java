package com.semblergames.shaperush.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.semblergames.shaperush.game.utils.AnimationSet;
import com.semblergames.shaperush.game.utils.Types;
import com.semblergames.shaperush.utils.graphics.ColorShader;

public class RushingShape extends GameObject {



    private float vy;

    private Types.Color color;
    private Types.Shape shape;

    public RushingShape(Animation<TextureRegion> [] animations){
        super(animations);
        yOffsetReaction = 0.2f;
        vy = 0f;
        color = Types.Color.RED;
        shape = Types.Shape.CIRCLE;
        colorIndex = color.getValue();
    }

    public void set(Types.Color color, Types.Shape shape, float y, int lane){
        this.color = color;
        this.shape = shape;
        this.x = 1 + (lane + 1)* 0.333f + lane * width + width/2;
        this.y = y;
        colorIndex = color.getValue();
        controller.changeAnimation(shape.getValue());
    }

    @Override
    public void update(float delta){
        super.update(delta);
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
        controller.changeAnimation(shape.getValue());
    }

    public void setColor(Types.Color color) {
        this.color = color;
        colorIndex = ColorShader.colorIndexes[color.getValue()];
    }

    public boolean intersects(GameObject obstacle){
        return this.y + yOffsetReaction > obstacle.y - obstacle.yOffsetReaction;
    }


}
