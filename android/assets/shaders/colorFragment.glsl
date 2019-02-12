#ifdef GL_ES
#define LOWP lowp
precision mediump float;
#else
#define LOWP
#endif

#define TRIGGER_OFFSET 0.1

uniform sampler2D u_texture;
uniform vec3 u_color[3];
uniform int u_mode;

varying LOWP vec4 v_color;
varying vec2 v_texCoords;

bool pure_red(vec4 color);
bool pure_green(vec4 color);
bool pure_blue(vec4 color);

void main(void){

    vec4 color = texture2D(u_texture, v_texCoords);

    if(u_mode == 1){

      int r = int(v_color.r);
      int g = int(v_color.g);
      int b = int(v_color.b);

        if(pure_red(color) || pure_green(color) || pure_blue(color)){
            color.rgb = u_color[r] * color.r + u_color[g] * color.g + u_color[b] * color.b;
        }

        color.a = color.a * v_color.a;

    }else{
       color = v_color * color;
    }

    gl_FragColor = color;

}


bool pure_red(vec4 color){
    return ((color.r > 1-TRIGGER_OFFSET)
         && (color.g < TRIGGER_OFFSET)
         && (color.b < TRIGGER_OFFSET));
}

bool pure_green(vec4 color){
    return ((color.r < TRIGGER_OFFSET)
         && (color.g > 1-TRIGGER_OFFSET)
         && (color.b < TRIGGER_OFFSET));
}

bool pure_blue(vec4 color){
    return ((color.r < TRIGGER_OFFSET)
         && (color.g < TRIGGER_OFFSET)
         && (color.b > 1-TRIGGER_OFFSET));
}