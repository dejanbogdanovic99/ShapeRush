
attribute vec4 a_position;
attribute vec4 a_color;
attribute vec2 a_texCoord0;

uniform mat4 u_projTrans;
uniform int u_mode;

varying float v_mode;
varying vec4 v_color;
varying vec2 v_texCoords;

void main(void){

    v_mode = float(u_mode);
    v_color = a_color;
    v_color.a = v_color.a * (255.0/254.0);
    if(v_mode > 0.5){
        v_color.r *= 2.0;
        v_color.g *= 2.0;
        v_color.b *= 2.0;
    }

    v_texCoords = a_texCoord0;
    gl_Position = u_projTrans * a_position;
}