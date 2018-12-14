package com.semblergames.shaperush.utils.graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Disposable;

public class ColorShader implements Disposable {

    private ShaderProgram program;

    private int cr;
    private int cg;
    private int cb;


    public ColorShader(){
        program = createShader();
        if (!program.isCompiled()) throw new IllegalArgumentException("Error compiling shader: " + program.getLog());
        getUniformLocations();
        program.begin();
        program.setUniformf(this.cr,1,1,1);
        program.setUniformf(this.cg,1,1,1);
        program.setUniformf(this.cb,1,1,1);
        program.end();
    }

    public ShaderProgram getProgram(){
        return program;
    }

    public void loadColors(Color cr,Color cb,Color cg){
        program.begin();
        program.setUniformf(this.cr,cr.a,cr.g,cr.b);
        program.setUniformf(this.cg,cg.a,cg.g,cg.b);
        program.setUniformf(this.cb,cb.a,cb.g,cb.b);
        program.end();
    }

    private void getUniformLocations(){
        cr = program.getUniformLocation("u_c1");
        cg = program.getUniformLocation("u_c2");
        cb = program.getUniformLocation("u_c3");
    }

    private ShaderProgram createShader(){
        String vertexShader = "attribute vec4 " + ShaderProgram.POSITION_ATTRIBUTE + ";\n" //
                + "attribute vec4 " + ShaderProgram.COLOR_ATTRIBUTE + ";\n" //
                + "attribute vec2 " + ShaderProgram.TEXCOORD_ATTRIBUTE + "0;\n" //
                + "uniform mat4 u_projTrans;\n" //
                + "varying vec4 v_color;\n" //
                + "varying vec2 v_texCoords;\n" //
                + "\n" //
                + "void main()\n" //
                + "{\n" //
                + "   v_color = " + ShaderProgram.COLOR_ATTRIBUTE + ";\n" //
                + "   v_color.a = v_color.a * (255.0/254.0);\n" //
                + "   v_texCoords = " + ShaderProgram.TEXCOORD_ATTRIBUTE + "0;\n" //
                + "   gl_Position =  u_projTrans * " + ShaderProgram.POSITION_ATTRIBUTE + ";\n" //
                + "}\n";

        String fragmentShader = "#ifdef GL_ES\n" //
                + "#define LOWP lowp\n" //
                + "precision mediump float;\n" //
                + "#else\n" //
                + "#define LOWP \n" //
                + "#endif\n" //
                + "varying LOWP vec4 v_color;\n" //
                + "varying vec2 v_texCoords;\n" //
                + "uniform sampler2D u_texture;\n" //
                + "uniform vec3 u_c1;\n" //
                + "uniform vec3 u_c2;\n" //
                + "uniform vec3 u_c3;\n" //
                + "void main()\n"//
                + "{\n" //
                + "  vec4 c = v_color * texture2D(u_texture, v_texCoords);\n" //
                + "  if(c.x> 0.9 && c.y < 0.1 && c.z < 0.1){\n"
                + "  c.rgb = u_c1 * c.r; \n" //
                + "  }else if(c.x < 0.1 && c.y > 0.9 && c.z < 0.1){\n" //
                + "  c.rgb = u_c2 * c.g; \n" //
                + "  }else if(c.x < 0.1 && c.y < 0.1 && c.z > 0.9){\n" //
                + "  c.rgb = u_c3 * c.b; \n" //
                + "  }\n" //
                //+ "  vec3 col = vec3(c.r * u_c1.r + c.g * u_c2.r + c.b * u_c3.r,"
                //+ "  c.r * u_c1.g + c.g * u_c2.g + c.b * u_c3.g,"
                //+ "  c.r * u_c1.b + c.g * u_c2.b + c.b * u_c3.b"
                //+ ");\n" //
                + "  gl_FragColor = c;\n" //
                + "}";

        return new ShaderProgram(vertexShader,fragmentShader);
    }

    @Override
    public void dispose(){
        program.dispose();
    }
}
