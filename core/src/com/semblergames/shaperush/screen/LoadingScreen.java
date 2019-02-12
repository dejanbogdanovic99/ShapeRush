package com.semblergames.shaperush.screen;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.semblergames.shaperush.Main;

public class LoadingScreen extends ShapeRushScreen {


    private AssetDescriptor<Texture> desLogoSG;
    private Image iLogoSG;

    private AssetDescriptor<Texture> desRedArrow;
    private AssetDescriptor<Texture> desYellowArrow;
    private AssetDescriptor<Texture> desOrangeCircle;

    private Group gLogoSR;

    private Image iRedArrow;
    private Image iYellowArrow;
    private Image iOrangeCircle;


    private float timeLapsed;
    private boolean ready;


    @Override
    public void create() {

        AssetManager manager = getManager();

        desLogoSG = new AssetDescriptor<Texture>("utils/loading/robot.png",Texture.class);

        desRedArrow = new AssetDescriptor<Texture>("utils/loading/red_a.png",Texture.class);
        desYellowArrow = new AssetDescriptor<Texture>("utils/loading/yellow_a.png",Texture.class);
        desOrangeCircle = new AssetDescriptor<Texture>("utils/loading/orange_o.png",Texture.class);

        manager.load(desLogoSG);
        manager.load(desRedArrow);
        manager.load(desYellowArrow);
        manager.load(desOrangeCircle);

    }

    @Override
    public void prepare() {
        super.prepare();

        AssetManager manager = getManager();

        final float width = stage.getViewport().getWorldWidth();
        final float height = stage.getViewport().getWorldHeight();

        iLogoSG = new Image(manager.get(desLogoSG));
        iLogoSG.setOrigin(Align.center);
        iLogoSG.setPosition(width/2,height/2 + 120, Align.center);


        gLogoSR = new Group();
        gLogoSR.setPosition(width/2,280, Align.center);
        gLogoSR.setOrigin(Align.center);


        iRedArrow = new Image(manager.get(desRedArrow));
        iRedArrow.setSize(200,92);
        iRedArrow.setRotation(180);
        iRedArrow.setOrigin(Align.center);
        iRedArrow.setPosition(0,-100,Align.center);


        iYellowArrow = new Image(manager.get(desYellowArrow));
        iYellowArrow.setSize(200,92);
        iYellowArrow.setOrigin(Align.center);
        iYellowArrow.setPosition(0,100,Align.center);


        iOrangeCircle = new Image(manager.get(desOrangeCircle));
        iOrangeCircle.setSize(200,92);
        iOrangeCircle.setOrigin(Align.center);
        iOrangeCircle.setPosition(0,0,Align.center);


        gLogoSR.addActor(iRedArrow);
        gLogoSR.addActor(iYellowArrow);
        gLogoSR.addActor(iOrangeCircle);

        iRedArrow.addAction(Actions.repeat(-1, Actions.sequence(Actions.moveBy(0,40,0.5f),Actions.moveBy(0,-40,0.5f))));
        iYellowArrow.addAction(Actions.repeat(-1,Actions.sequence(Actions.moveBy(0,-40,0.5f),Actions.moveBy(0,40,0.5f))));


        gLogoSR.addAction(Actions.repeat(-1, Actions.rotateBy(360,1, Interpolation.sine)));


        stage.addActor(iLogoSG);
        stage.addActor(gLogoSR);

        timeLapsed = 0;
        ready = false;

    }

    @Override
    public void release(){
        super.release();
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        if(!ready){
            timeLapsed += delta;
            if(timeLapsed >= 2){
                ready = true;
                requestScreen(Main.ScreenIDs.MainMenuScreen.getID());
            }
        }


    }

    @Override
    public void dispose() {

        AssetManager manager = getManager();

        manager.unload(desLogoSG.fileName);

        manager.unload(desOrangeCircle.fileName);
        manager.unload(desRedArrow.fileName);
        manager.unload(desYellowArrow.fileName);


    }

}
