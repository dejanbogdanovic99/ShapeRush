package com.semblergames.shaperush.utils.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.NumberUtils;

import java.nio.FloatBuffer;

public class ColorShader extends ShaderProgram{

    private int color_location;
    private int alpha_location;

    private FloatBuffer colorBuffer;

    public static float [] color_indexes = {
            NumberUtils.intBitsToFloat(0xfeff8000), //rgb
            NumberUtils.intBitsToFloat(0xfe00ff80), //gbr
            NumberUtils.intBitsToFloat(0xfe8000ff), //brg
            NumberUtils.intBitsToFloat(0xfe80ff00), //rbg
            NumberUtils.intBitsToFloat(0xfeff0080), //grb
            NumberUtils.intBitsToFloat(0xfe0080ff)  //bgr
    };

    public ColorShader(){
        super(Gdx.files.internal("shaders/colorVertex.glsl"),Gdx.files.internal("shaders/colorFragment.glsl"));

        if (!isCompiled()) throw new IllegalArgumentException("Error compiling shader: " + getLog());

        color_location = getUniformLocation("u_color[0]");
        alpha_location = getUniformLocation("u_alpha");
        
        colorBuffer = BufferUtils.newFloatBuffer(9);

        begin();
        reloadColorsOnLine();
        loadAlphaOnLine(1);
        end();
    }

    public void loadAlphaOnLine(float alpha){
        Gdx.gl20.glUniform1f(alpha_location,alpha);
    }

    public void loadAlpha(float alpha){
        begin();
        loadAlphaOnLine(alpha);
        end();
    }
    
    public void loadColorsOnLine(Color red, Color green, Color blue){
        colorBuffer.clear();
        colorBuffer.put(red.r).put(red.g).put(red.b).
                    put(green.r).put(green.g).put(green.b).
                    put(blue.r).put(blue.g).put(blue.b);
        colorBuffer.flip();
        Gdx.gl20.glUniform3fv(color_location,3,colorBuffer);
    }
    
    public void loadColors(Color red, Color green, Color blue){
        begin();
        loadColorsOnLine(red,green,blue);
        end();
    }

    public void reloadColorsOnLine(){
        colorBuffer.clear();
        colorBuffer.put(1).put(0).put(0).
                    put(0).put(1).put(0).
                    put(0).put(0).put(1);
        colorBuffer.flip();
        Gdx.gl20.glUniform3fv(color_location,3,colorBuffer);
    }

    public void reloadColors(){
        begin();
        reloadColorsOnLine();
        end();
    }

}
