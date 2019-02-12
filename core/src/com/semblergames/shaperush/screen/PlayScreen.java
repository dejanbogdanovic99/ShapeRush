package com.semblergames.shaperush.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.semblergames.shaperush.Main;
import com.semblergames.shaperush.game.Barrier;
import com.semblergames.shaperush.game.CSChange;
import com.semblergames.shaperush.game.Gate;
import com.semblergames.shaperush.game.RushingShape;
import com.semblergames.shaperush.game.utils.Types;
import com.semblergames.shaperush.utils.graphics.ColorShader;


public class PlayScreen extends ShapeRushScreen implements InputProcessor {

    public PlayScreen() {}

    private Pool<Gate> gatePool;
    private Pool<CSChange> changePool;
    private Pool<Barrier> barrierPool;

    private AssetDescriptor<Texture> descRCircle;
    private AssetDescriptor<Texture> descRSquare;
    private AssetDescriptor<Texture> descRTriangle;

    private AssetDescriptor [] descGates;

    private Animation [] aThreeShape;
    private Animation [] aGate;

    private ExtendViewport vpGame;

    private RushingShape rushingShape;
    private Gate gate1;

    @Override
    public void create() {

        AssetManager manager = getManager();

        descRCircle = new AssetDescriptor<Texture>("shapes/rcircle.png",Texture.class);
        descRSquare = new AssetDescriptor<Texture>("shapes/rsquare.png",Texture.class);
        descRTriangle = new AssetDescriptor<Texture>("shapes/rtriangle.png",Texture.class);

        descGates = new AssetDescriptor[21];
        descGates[0] = new AssetDescriptor<Texture>("gates/blank.png", Texture.class);
        descGates[1] = new AssetDescriptor<Texture>("gates/red.png", Texture.class);
        descGates[2] = new AssetDescriptor<Texture>("gates/red_green.png", Texture.class);

        descGates[3] = new AssetDescriptor<Texture>("gates/blank_c.png", Texture.class);
        descGates[4] = new AssetDescriptor<Texture>("gates/blank_s.png", Texture.class);
        descGates[5] = new AssetDescriptor<Texture>("gates/blank_t.png", Texture.class);
        descGates[6] = new AssetDescriptor<Texture>("gates/red_c.png", Texture.class);
        descGates[7] = new AssetDescriptor<Texture>("gates/red_s.png", Texture.class);
        descGates[8] = new AssetDescriptor<Texture>("gates/red_t.png", Texture.class);
        descGates[9] = new AssetDescriptor<Texture>("gates/red_green_c.png", Texture.class);
        descGates[10] = new AssetDescriptor<Texture>("gates/red_green_s.png", Texture.class);
        descGates[11] = new AssetDescriptor<Texture>("gates/red_green_t.png", Texture.class);

        descGates[12] = new AssetDescriptor<Texture>("gates/blank_c_s.png", Texture.class);
        descGates[13] = new AssetDescriptor<Texture>("gates/red_c_s.png", Texture.class);
        descGates[14] = new AssetDescriptor<Texture>("gates/red_green_c_s.png", Texture.class);
        descGates[15] = new AssetDescriptor<Texture>("gates/blank_c_t.png", Texture.class);
        descGates[16] = new AssetDescriptor<Texture>("gates/red_c_t.png", Texture.class);
        descGates[17] = new AssetDescriptor<Texture>("gates/red_green_c_t.png", Texture.class);
        descGates[18] = new AssetDescriptor<Texture>("gates/blank_s_t.png", Texture.class);
        descGates[19] = new AssetDescriptor<Texture>("gates/red_s_t.png", Texture.class);
        descGates[20] = new AssetDescriptor<Texture>("gates/red_green_s_t.png", Texture.class);

        for(int i = 0; i < descGates.length; i++){
            manager.load(descGates[i]);
        }

        manager.load(descRCircle);
        manager.load(descRSquare);
        manager.load(descRTriangle);

    }

    @Override
    public void prepare(){
        super.prepare();

        input.addProcessor(this);

        AssetManager manager = getManager();

        aThreeShape = new Animation[3];
        aThreeShape[0] = new Animation<TextureRegion>(0.5f,new TextureRegion(manager.get(descRCircle)));
        aThreeShape[1] = new Animation<TextureRegion>(0.5f,new TextureRegion(manager.get(descRSquare)));
        aThreeShape[2] = new Animation<TextureRegion>(0.5f,new TextureRegion(manager.get(descRTriangle)));

        aGate = new Animation[21];
        for(int i = 0; i < aGate.length;i++){
            aGate[i] = new Animation<TextureRegion>(0.5f,new TextureRegion(manager.get((AssetDescriptor<Texture>) descGates[i])));
        }

        vpGame = new ExtendViewport(9,16);
        vpGame.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),false);
        vpGame.getCamera().position.set(vpGame.getWorldWidth()/2,vpGame.getWorldHeight() - 8,0);


        rushingShape = new RushingShape(aThreeShape);
        rushingShape.set(Types.Color.BLUE, Types.Shape.TRIANGLE,vpGame.getWorldHeight() - 13, 0);

        gate1 = new Gate(aGate);
        gate1.set(Types.Color.RED, Types.Color.GREEN, Types.Shape.CIRCLE, Types.Shape.TRIANGLE,vpGame.getWorldHeight() - 5, 0);
    }

    @Override
    public void release(){
        super.release();
        rushingShape = null;
        aThreeShape = null;
    }

    @Override
    public void render() {

        vpGame.getCamera().update();

        ShapeRenderer renderer = getShapeRenderer();

        renderer.setProjectionMatrix(vpGame.getCamera().combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.rect(0,0,vpGame.getWorldWidth(), vpGame.getWorldHeight(),Main.red, Main.red,Main.green,Main.green);
        renderer.setColor(1,1,1,1);
        renderer.rect(1,0,vpGame.getWorldWidth()-2, vpGame.getWorldHeight());
        renderer.end();

        super.render();


        SpriteBatch batch = getBatch();
        batch.setProjectionMatrix(vpGame.getCamera().combined);
        ColorShader shader = getColorShader();
        batch.begin();
        shader.loadModeOnLine(1);

        rushingShape.draw(batch);
        gate1.draw(batch);

        batch.flush();
        shader.loadModeOnLine(0);
        batch.end();


    }

    @Override
    public void update(float delta) {
        super.update(delta);
        rushingShape.update(delta);
        gate1.update(delta);
    }

    @Override
    public void resize(int width, int height){
        super.resize(width,height);
        vpGame.update(width, height,true);
    }

    @Override
    public void dispose() {
        AssetManager manager = getManager();

        manager.unload(descRCircle.fileName);
        manager.unload(descRSquare.fileName);
        manager.unload(descRTriangle.fileName);

        for(int i = 0; i < descGates.length; i++){
            manager.unload(descGates[i].fileName);
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.ESCAPE){
            requestScreen(Main.ScreenIDs.MainMenuScreen.getID());
        }else if(keycode == Input.Keys.G){
            rushingShape.setShape(Types.Shape.CIRCLE);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
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
