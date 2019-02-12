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
    private int mode_location;

    private FloatBuffer colorBuffer;

    public static int colorIndexes[] = {
            0xfeff8000,
            0xfe00ff80,
            0xfe8000ff,
            0xfe80ff00,
            0xfeff0080,
            0xfe0080ff
    };

    public static int rgb = 0;
    public static int gbr = 1;
    public static int brg = 2;
    public static int rbg = 3;
    public static int grb = 4;
    public static int bgr = 5;



    public ColorShader(){
        super(Gdx.files.internal("shaders/colorVertex.glsl"),Gdx.files.internal("shaders/colorFragment.glsl"));

        if (!isCompiled()) throw new IllegalArgumentException("Error compiling shader: " + getLog());

        color_location = getUniformLocation("u_color[0]");
        mode_location = getUniformLocation("u_mode");
        
        colorBuffer = BufferUtils.newFloatBuffer(9);

        begin();
        reloadColorsOnLine();
        loadModeOnLine(0);
        end();
    }

    public void loadModeOnLine(int mode){
        Gdx.gl20.glUniform1i(mode_location,mode);
    }

    public void loadMode(int mode){
        begin();
        loadModeOnLine(mode);
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

    public void loadColorsOnLine(float rr,float rg, float rb, float gr, float gg, float gb, float br, float bg, float bb){
        colorBuffer.clear();
        colorBuffer.put(rr).put(rg).put(rb).
                put(gr).put(gg).put(gb).
                put(br).put(bg).put(bb);
        colorBuffer.flip();
        Gdx.gl20.glUniform3fv(color_location,3,colorBuffer);
    }
    
    public void loadColors(Color red, Color green, Color blue){
        begin();
        loadColorsOnLine(red,green,blue);
        end();
    }

    public void loadColors(float rr,float rg, float rb, float gr, float gg, float gb, float br, float bg, float bb){
        begin();
        loadColorsOnLine(rr,rg,rb,gr,gg,gb,br,bg,bb);
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
