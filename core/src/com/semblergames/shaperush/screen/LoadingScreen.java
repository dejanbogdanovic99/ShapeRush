package com.semblergames.shaperush.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.semblergames.shaperush.animation.Animation;
import com.semblergames.shaperush.animation.FrameAnimController;
import com.semblergames.shaperush.animation.FrameAnimation;
import com.semblergames.shaperush.animation.RotAnimController;
import com.semblergames.shaperush.animation.RotationAnimation;
import com.semblergames.shaperush.animation.ScaleAnimation;
import com.semblergames.shaperush.animation.SclAnimController;
import com.semblergames.shaperush.animation.ShakeAnimation;
import com.semblergames.shaperush.animation.ShkAnimController;
import com.semblergames.shaperush.game.Gate;
import com.semblergames.shaperush.animation.AnimationController;
import com.semblergames.shaperush.utils.SoundController;
import com.semblergames.shaperush.utils.graphics.ColorShader;

public class LoadingScreen extends Screen{

    private ColorShader colorShader;

    public LoadingScreen(ColorShader colorShader, SpriteBatch batch, AssetManager manager) {
        super(batch, manager);
        this.colorShader = colorShader;
    }

    public LoadingScreen(ColorShader colorShader, SpriteBatch batch, AssetManager manager, Color bgColor) {
        super(batch, manager, bgColor);
        this.colorShader = colorShader;
    }


    Color c1;
    Color c2;
    Color c3;

    Texture [] t1;
    Texture [] t2;


    FrameAnimation[] an;

    Sound [] so;

    FrameAnimController<Texture> animationController;
    RotAnimController rotAnimController;
    SclAnimController sclAnimController;
    ShkAnimController shkAnimController;
    SoundController soundController;

    InputProcessor inputProcessor;

    Gate gate;

    Stage stage;

    Button b;
    @Override
    public void initialize() {
        c1 = new Color(Color.WHITE);
        c2 = new Color(Color.MAROON);
        c3 = new Color(Color.NAVY);
        colorShader.loadColors(c1,c2,c3);

        t1 = new Texture[3];
        t2 = new Texture[2];
        t1[0] = new Texture("triangle.png");
        t1[1] = new Texture("gcircle.png");
        t1[2] = new Texture("rsquare.png");
        t2[0] = new Texture("triangle.png");
        t2[1] = new Texture("triangle1.png");


        an = new FrameAnimation[2];
        an[0] = new FrameAnimation<Texture>(0.5f, t1,Animation.PlayMode.LOOP_PINGPONG);
        an[1] = new FrameAnimation<Texture>(0.5f, t2);

        final RotationAnimation [] rot = new RotationAnimation[1];

        rot[0] = new RotationAnimation(0,360,1,RotationAnimation.TransitionType.SIN, Animation.PlayMode.LOOP_PINGPONG);


        rotAnimController = new RotAnimController(rot);

        final ScaleAnimation [] scl = new ScaleAnimation[1];

        scl[0] = new ScaleAnimation(0.5f,1.5f,3,ScaleAnimation.TransitionType.LINEAR, Animation.PlayMode.LOOP);

        sclAnimController = new SclAnimController(scl);


        final ShakeAnimation [] shk = new ShakeAnimation[1];

        shk[0] = new ShakeAnimation(3,10,1, ShakeAnimation.TransitionType.PEAK, Animation.PlayMode.NORMAL);

        shkAnimController = new ShkAnimController(shk);


        animationController = new FrameAnimController<Texture>();
        animationController.setAnimations(an);
        animationController.start();

        so = new Sound[2];
        so[0] = Gdx.audio.newSound(Gdx.files.internal("die.wav"));
        so[1] = Gdx.audio.newSound(Gdx.files.internal("hit.wav"));

        soundController = new SoundController(Gdx.graphics.getWidth()/2,so);

        inputProcessor = new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                shkAnimController.restart();
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return true;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                soundController.play(1,screenX, Gdx.graphics.getHeight()-screenY, Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,1);
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(int amount) {
                return false;
            }
        };

        stage = new Stage(new ScalingViewport(Scaling.stretch, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera()), batch);

        input.addProcessor(inputProcessor);

        gate = new Gate();


    }


    @Override
    public void render() {
        super.render();
        ShaderProgram def = batch.getShader();
        batch.setShader(colorShader.getProgram());
        batch.begin();
        float scale = sclAnimController.getScale();
        float offestX = shkAnimController.getOffsetX();
        float offsetY = shkAnimController.getOffsetY();
        batch.draw(animationController.getKeyFrame(), offestX, offsetY,
                offestX + animationController.getKeyFrame().getWidth()/2,
                offsetY + animationController.getKeyFrame().getHeight()/2,
                animationController.getKeyFrame().getWidth(),
                animationController.getKeyFrame().getHeight(),
                scale,scale,
                rotAnimController.getAngle() + shkAnimController.getAngle(),0,0, animationController.getKeyFrame().getWidth(),
                animationController.getKeyFrame().getHeight(),false,false);

        batch.end();

        stage.draw();

        batch.setShader(def);

    }

    @Override
    public void update(float delta) {
        super.update(delta);
        stage.act(delta);
        animationController.update(delta);
        rotAnimController.update(delta);
        sclAnimController.update(delta);
        shkAnimController.update(delta);
    }

    @Override
    public void dispose() {
        stage.dispose();
        t1[0].dispose();
        t1[1] .dispose();
        t1[2] .dispose();
        t2[0].dispose();
        t2[1].dispose();
        so[0].dispose();
        so[1].dispose();
    }

}
