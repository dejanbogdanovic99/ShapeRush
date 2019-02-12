package com.semblergames.shaperush.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.semblergames.shaperush.game.utils.Types;
import com.semblergames.shaperush.utils.graphics.ColorShader;

public class Gate extends GameObject{


    private Types.Color cAllowed1;
    private Types.Color cAllowed2;

    private Types.Shape sAllowed1;
    private Types.Shape sAllowed2;

    public Gate(Animation<TextureRegion>[] animations) {
        super(animations);
        yOffsetReaction = 0.1f;
        cAllowed1 = Types.Color.SPECIAL;
        cAllowed2 = Types.Color.SPECIAL;
        sAllowed1 = Types.Shape.SPECIAL;
        sAllowed2 = Types.Shape.SPECIAL;
        setupAnimation();
        setupColorIndex();
    }

    public void set(Types.Color cAllowed1, Types.Color cAllowed2, Types.Shape sAllowed1, Types.Shape sAllowed2, float y, float lane){
        this.cAllowed1 = cAllowed1;
        this.cAllowed2 = cAllowed2;
        this.sAllowed1 = sAllowed1;
        this.sAllowed2 = sAllowed2;
        this.x = 1 + (lane + 1)* 0.333f + lane * width + width/2;
        this.y = y;
        setupAnimation();
        setupColorIndex();
    }

    private void setupAnimation(){
        int index;
        if(sAllowed1 == Types.Shape.SPECIAL){
            if(cAllowed1 == Types.Color.SPECIAL){
                index = 0;
            }else if(cAllowed2 == Types.Color.SPECIAL){
                index = 1;
            }else {
                index = 2;
            }
        }else if(sAllowed2 == Types.Shape.SPECIAL){
            if(cAllowed1 == Types.Color.SPECIAL){
                index = 3 + sAllowed1.getValue();
            }else if(cAllowed2 == Types.Color.SPECIAL){
                index = 6 + sAllowed1.getValue();
            }else {
                index = 9 + sAllowed1.getValue();
            }
        }else{
            int increment;
            if(cAllowed1 == Types.Color.SPECIAL){
                increment = 0;
            }else if(cAllowed2 == Types.Color.SPECIAL){
                increment = 1;
            }else{
                increment = 2;
            }
            index = 12 + (sAllowed1.getValue() + sAllowed2.getValue() - 1) * 3 + increment;
        }

        controller.changeAnimation(index);
    }

    private void setupColorIndex(){
        if(cAllowed1 == Types.Color.SPECIAL){
            colorIndex = ColorShader.rgb;
        }else if(cAllowed2 == Types.Color.SPECIAL){
            colorIndex = cAllowed1.getValue();
        }else {
            int total = cAllowed1.getValue() + cAllowed2.getValue();
            if(total == 1){
                colorIndex = 0;
            }else if(total == 2){
                colorIndex = 2;
            }else{
                colorIndex = 1;
            }
        }
    }

    public Types.Color getcAllowed1() {
        return cAllowed1;
    }

    public Types.Color getcAllowed2() {
        return cAllowed2;
    }

    public Types.Shape getsAllowed1() {
        return sAllowed1;
    }

    public Types.Shape getsAllowed2() {
        return sAllowed2;
    }

}
