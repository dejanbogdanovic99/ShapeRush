package com.semblergames.shaperush.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.NumberUtils;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.semblergames.shaperush.animation.Animation;
import com.semblergames.shaperush.animation.animations.*;
import com.semblergames.shaperush.game.Barrier;
import com.semblergames.shaperush.game.CSChange;
import com.semblergames.shaperush.game.Gate;
import com.semblergames.shaperush.game.RushingShape;
import com.semblergames.shaperush.game.utils.AnimationSet;
import com.semblergames.shaperush.game.utils.Types;
import com.semblergames.shaperush.utils.graphics.ColorShader;


public class PlayScreen extends ShapeRushScreen implements InputProcessor {

    public PlayScreen() {}

    public PlayScreen(Color bgColor) {
        super(bgColor);
    }


    private Pool<Gate> gatePool;
    private Pool<CSChange> changePool;
    private Pool<Barrier> barrierPool;

    private OrthographicCamera camera;
    private ExtendViewport gameViewPort;

    CSChange change;
    RushingShape shape;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        gameViewPort = new ExtendViewport(7,12.44f,camera);

        gameViewPort.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),true);



        AssetManager manager = getManager();
        manager.load("spin.png",Texture.class);
        manager.load("rtriangle.png",Texture.class);

        CSChange.loadCSTextures(manager);
        manager.finishLoading();


        AnimationSet animationSet = CSChange.createCSChangeAnimationSet(getManager());

        change = new CSChange(animationSet);
        change.set(Types.Color.RED,Types.Shape.SQUARE, 4,5);

        shape = new RushingShape(animationSet);
        shape.set(Types.Color.RED,Types.Shape.CIRCLE,3,3,2);

        input.addProcessor(this);

    }

    @Override
    public void resize(int width, int height) {
        gameViewPort.update(width,height);
    }

    @Override
    public void render() {
        super.render();

        gameViewPort.apply();
        SpriteBatch batch = getBatch();

        ColorShader shader = getColorShader();

        batch.setShader(shader);

        batch.setProjectionMatrix(camera.projection);
        batch.setTransformMatrix(camera.view);

        batch.begin();
        change.draw(batch);
        shape.draw(batch);
        batch.end();

        batch.setShader(null);
    }

    @Override
    public void update(float delta) {
        change.update(delta);
        change.updateToShape(shape);
        shape.update(delta);
    }

    @Override
    public void show() {
        super.show();
        getColorShader().loadColors(Color.NAVY,Color.YELLOW,Color.CORAL);
    }

    @Override
    public void dispose() {
        AssetManager manager = getManager();
        manager.unload("spin.png");
        manager.unload("rtriangle.png");
        CSChange.unloadCSTextures(manager);
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.UP) {
            shape.setColor(Types.Color.BLUE);
        }else if(keycode == Input.Keys.DOWN) {
            shape.setShape(Types.Shape.SQUARE);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
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
}
