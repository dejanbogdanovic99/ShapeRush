package com.semblergames.shaperush.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.semblergames.shaperush.animation.Animation;
import com.semblergames.shaperush.animation.animations.FrameAnimation;
import com.semblergames.shaperush.animation.animations.TransitionAnimation;
import com.semblergames.shaperush.animation.controllers.TransitionAnimationController;
import com.semblergames.shaperush.game.utils.AnimationSet;
import com.semblergames.shaperush.game.utils.Types;
import com.semblergames.shaperush.utils.graphics.ColorShader;

public class CSChange{

 /*   private TransitionAnimationController rotation;
    private TransitionAnimationController scale;

    private Types.Color toColor;
    private Types.Shape toShape;

   public CSChange(AnimationSet animationSet){
        super(animationSet);
        yOffsetReaction = 0.25f;
        rotation = new TransitionAnimationController(animationSet.getRotationAnimations());
        scale = new TransitionAnimationController(animationSet.getScaleAnimations());
        toColor = Types.Color.RED;
        toShape = Types.Shape.CIRCLE;
    }

    public void set(Types.Color toColor, Types.Shape toShape, float x, float y){
        this.toColor = toColor;
        this.toShape = toShape;
        this.x = x;
        this.y = y;
        if(toColor != Types.Color.SPECIAL){
            colorIndex = toColor.getValue();
        }
        animation.changeAnimation(toShape.getValue());
    }

    public Types.Color getToColor() {
        return toColor;
    }

    public Types.Shape getToShape(){
        return toShape;
    }

    public void updateToShape(RushingShape shape){
        if(toShape == Types.Shape.SPECIAL){
            animation.changeAnimation(shape.getShape().getValue());
        }
        if(toColor == Types.Color.SPECIAL){
            colorIndex = shape.getColor().getValue();
        }
    }

    @Override
    public void reset(){
        this.animation.reset();
        this.rotation.reset();
        this.scale.reset();
    }

    @Override
    public void update(float delta) {
        animation.update(delta);
        rotation.update(delta);
        scale.update(delta);
        if(rotation.isHalfFinished()){
            animation.changeAnimation(toShape.getValue());
        }else{
            animation.changeAnimation(toShape.getValue()+1);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {

        final float scale = this.scale.getState();

        batch.setColor(ColorShader.color_indexes[colorIndex]);

        batch.draw(
                animation.getKeyFrame(),
                x - halfWidth,
                y - halfHeight,
                halfWidth,
                halfHeight,
                halfWidth*2,
                halfHeight*2,
                scale,
                scale,
                rotation.getState()
        );
    }

    public static void loadCSTextures(AssetManager manager){
        manager.load("rcircle.png",Texture.class);

        manager.load("rsquare.png",Texture.class);

        manager.load("rtriangle.png",Texture.class);
    }

    public static AnimationSet createCSChangeAnimationSet(AssetManager manager){
        AnimationSet animationSet = new AnimationSet();

        TransitionAnimation rotation = new TransitionAnimation(0,1080, 2f, TransitionAnimation.TransitionType.SIN, Animation.PlayMode.LOOP);
        TransitionAnimation scale = new TransitionAnimation(1,1,0.48f, TransitionAnimation.TransitionType.LINEAR, Animation.PlayMode.LOOP_PINGPONG);


        FrameAnimation<TextureRegion> squareShape = new FrameAnimation<TextureRegion>(0.2f,new TextureRegion((Texture)manager.get("rsquare.png")));
        FrameAnimation<TextureRegion> circleShape = new FrameAnimation<TextureRegion>(0.2f,new TextureRegion((Texture)manager.get("rcircle.png")));
        FrameAnimation<TextureRegion> triangleShape = new FrameAnimation<TextureRegion>(0.2f,new TextureRegion((Texture)manager.get("rtriangle.png")));

        animationSet.addAllRotationAnimations(rotation);
        animationSet.addAllScaleAnimations(scale);

        animationSet.addAllFrameAnimations(circleShape,squareShape, triangleShape);

        return animationSet;
    }

    public static void unloadCSTextures(AssetManager manager){
        manager.unload("rcircle.png");

        manager.unload("rsquare.png");

        manager.unload("rtriangle.png");
    }*/

}
