package com.semblergames.shaperush.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.semblergames.shaperush.animation.Animation;
import com.semblergames.shaperush.animation.animations.FrameAnimation;
import com.semblergames.shaperush.animation.animations.TransitionAnimation;
import com.semblergames.shaperush.animation.controllers.TransitionAnimationController;
import com.semblergames.shaperush.game.utils.AnimationSet;
import com.semblergames.shaperush.game.utils.Types;

public class Gate extends GameObject {


    private Types.Color color1;
    private Types.Color color2;

    private Types.Shape shape1;
    private Types.Shape shape2;

    private TransitionAnimationController fadeAnimation;

    public Gate(AnimationSet animationSet) {
        super(animationSet);
        yOffsetReaction = 0.1f;
        color1 = Types.Color.RED;
        color2 = Types.Color.SPECIAL;
        shape1 = Types.Shape.CIRCLE;
        shape2 = Types.Shape.SPECIAL;
        fadeAnimation = new TransitionAnimationController(animationSet.getFadeAnimations());
        fadeAnimation.stop();
    }

    public void set(Types.Color c1, Types.Color c2, Types.Shape s1, Types.Shape s2, float x, float y){
        this.color1 = c1;
        this.color2 = c2;
        this.shape1 = s1;
        this.shape2 = s2;
        this.x = x;
        this.y = y;
        if(c1 == Types.Color.SPECIAL){
            switch(s1){
                case SPECIAL:{
                    //blank
                    animation.changeAnimation(0);
                    break;
                }
                case CIRCLE:{
                    //blank circle
                    animation.changeAnimation(1);
                    break;
                }
                case SQUARE:{
                    //blank square
                    animation.changeAnimation(2);
                    break;
                }
                case TRIANGLE:{
                    //blank triangle
                    animation.changeAnimation(3);
                    break;
                }
            }
        }
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
        manager.load("gates/blank.png", Texture.class);

        manager.load("gates/blank_circle.png", Texture.class);
        manager.load("gates/blank_square.png", Texture.class);
        manager.load("gates/blank_triangle.png", Texture.class);

        manager.load("gates/gate_double_blank1.png", Texture.class);
        manager.load("gates/gate_double_blank2.png", Texture.class);
        manager.load("gates/gate_double_blank3.png", Texture.class);

        manager.load("gates/gate_red.png", Texture.class);

        manager.load("gates/gate_red_circle.png", Texture.class);
        manager.load("gates/gate_red_square.png", Texture.class);
        manager.load("gates/gate_red_triangle.png", Texture.class);

        manager.load("gates/gate_double_red1.png", Texture.class);
        manager.load("gates/gate_double_red2.png", Texture.class);
        manager.load("gates/gate_double_red3.png", Texture.class);

        manager.load("gates/gate_red_green.png", Texture.class);

        manager.load("gates/gate_red_green_circle.png", Texture.class);
        manager.load("gates/gate_red_green_square.png", Texture.class);
        manager.load("gates/gate_red_green_triangle.png", Texture.class);

        manager.load("gates/gate_red_green1.png", Texture.class);
        manager.load("gates/gate_red_green2.png", Texture.class);
        manager.load("gates/gate_red_green3.png", Texture.class);


    }

    public static AnimationSet createGAnimationSet(AssetManager manager){
        AnimationSet animationSet = new AnimationSet();

        TransitionAnimation fadeAnimation = new TransitionAnimation(0,1,2, TransitionAnimation.TransitionType.LINEAR, Animation.PlayMode.NORMAL);

        FrameAnimation<TextureRegion> blankGate = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/blank.png")));

        FrameAnimation<TextureRegion> blankCircle = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/blank_circle.png")));
        FrameAnimation<TextureRegion> blankSquare = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/blank_triangle.png")));
        FrameAnimation<TextureRegion> blankTriangle = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/blank_square.png")));

        FrameAnimation<TextureRegion> doubleBlank1 = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_double_blank1.png")));
        FrameAnimation<TextureRegion> doubleBlank2 = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_double_blank2.png")));
        FrameAnimation<TextureRegion> doubleBlank3 = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_double_blank3.png")));

        FrameAnimation<TextureRegion> redGate = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_red.png")));

        FrameAnimation<TextureRegion> redCircle = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_red_circle.png")));
        FrameAnimation<TextureRegion> redSquare = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_red_square.png")));
        FrameAnimation<TextureRegion> redTriangle = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_red_triangle.png")));

        FrameAnimation<TextureRegion> doubleRed1 = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_double_red1.png")));
        FrameAnimation<TextureRegion> doubleRed2 = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_double_red2.png")));
        FrameAnimation<TextureRegion> doubleRed3 = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_double_red3.png")));

        FrameAnimation<TextureRegion> redGreenGate = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_red_green.png")));

        FrameAnimation<TextureRegion> redGreenCircle = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_red_green_circle.png")));
        FrameAnimation<TextureRegion> redGreenSquare = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_red_green_square.png")));
        FrameAnimation<TextureRegion> redGreenTriangle = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_red_green_triangle.png")));

        FrameAnimation<TextureRegion> doubleRedGreen1 = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_red_green1.png")));
        FrameAnimation<TextureRegion> doubleRedGreen2 = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_red_green2.png")));
        FrameAnimation<TextureRegion> doubleRedGreen3 = new FrameAnimation<TextureRegion>(0.2f, new TextureRegion((Texture) manager.get("gates/gate_red_green3.png")));

        animationSet.addAllFrameAnimations(blankGate,blankCircle,blankSquare,blankTriangle,doubleBlank1,doubleBlank2,doubleBlank3,
                                           redGate,redCircle,redSquare,redTriangle,doubleRed1,doubleRed2,doubleRed3,
                                           redGreenGate,redGreenCircle,redGreenSquare,redGreenTriangle,doubleRedGreen1,doubleRedGreen2,doubleRedGreen3
        );

        animationSet.addAllFadeAnimations(fadeAnimation);

        return animationSet;
    }

    public static void unloadGTextures(AssetManager manager){
        manager.unload("gates/blank.png");

        manager.unload("gates/blank_circle.png");
        manager.unload("gates/blank_square.png");
        manager.unload("gates/blank_triangle.png");

        manager.unload("gates/gate_double_blank1.png");
        manager.unload("gates/gate_double_blank2.png");
        manager.unload("gates/gate_double_blank3.png");

        manager.unload("gates/gate_double_red1.png");
        manager.unload("gates/gate_double_red2.png");
        manager.unload("gates/gate_double_red3.png");

        manager.unload("gates/gate_red.png");

        manager.unload("gates/gate_red_circle.png");
        manager.unload("gates/gate_red_square.png");
        manager.unload("gates/gate_red_triangle.png");

        manager.unload("gates/gate_red_green.png");

        manager.unload("gates/gate_red_green_circle.png");
        manager.unload("gates/gate_red_green_square.png");
        manager.unload("gates/gate_red_green_triangle.png");

        manager.unload("gates/gate_red_green1.png");
        manager.unload("gates/gate_red_green2.png");
        manager.unload("gates/gate_red_green3.png");

    }

}
