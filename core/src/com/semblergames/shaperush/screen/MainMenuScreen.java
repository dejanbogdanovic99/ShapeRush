package com.semblergames.shaperush.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.semblergames.shaperush.Main;

public class MainMenuScreen extends ShapeRushScreen {

    private AssetDescriptor<Texture> descExit;
    private AssetDescriptor<Texture> descExitOver;
    private Button bExit;

    private AssetDescriptor<Texture> descNoads;
    private AssetDescriptor<Texture> descNoadsOver;
    private Button bNoads;

    private AssetDescriptor<Texture> descPlay;
    private AssetDescriptor<Texture> descPlayOver;
    private Button bPlay;

    private AssetDescriptor<Texture> descLeadboard;
    private AssetDescriptor<Texture> descLeadboardOver;
    private Button bLeadboard;

    private AssetDescriptor<Texture> descSettings;
    private AssetDescriptor<Texture> descSettingsOver;
    private Button bSettings;

    private AssetDescriptor<Texture> descShop;
    private AssetDescriptor<Texture> descShopOver;
    private Button bShop;

    private AssetDescriptor<Texture> descLogoSR;
    private Image iLogoSR;

    @Override
    public void create() {

        AssetManager manager = getManager();

        descExit = new AssetDescriptor<Texture>("buttons/exit.png",Texture.class);
        descExitOver = new AssetDescriptor<Texture>("buttons/exit1.png",Texture.class);

        descNoads = new AssetDescriptor<Texture>("buttons/noads.png",Texture.class);
        descNoadsOver = new AssetDescriptor<Texture>("buttons/noads1.png",Texture.class);

        descPlay = new AssetDescriptor<Texture>("buttons/play.png",Texture.class);
        descPlayOver = new AssetDescriptor<Texture>("buttons/play1.png",Texture.class);

        descLeadboard = new AssetDescriptor<Texture>("buttons/leadboard.png",Texture.class);
        descLeadboardOver = new AssetDescriptor<Texture>("buttons/leadboard1.png",Texture.class);

        descSettings = new AssetDescriptor<Texture>("buttons/settings.png",Texture.class);
        descSettingsOver = new AssetDescriptor<Texture>("buttons/settings1.png",Texture.class);

        descShop = new AssetDescriptor<Texture>("buttons/shop.png",Texture.class);
        descShopOver = new AssetDescriptor<Texture>("buttons/shop1.png",Texture.class);

        descLogoSR = new AssetDescriptor<Texture>("logos/logo_sr.png",Texture.class);

        manager.load(descExit);
        manager.load(descExitOver);
        manager.load(descNoads);
        manager.load(descNoadsOver);
        manager.load(descPlay);
        manager.load(descPlayOver);
        manager.load(descLeadboard);
        manager.load(descLeadboardOver);
        manager.load(descSettings);
        manager.load(descSettingsOver);
        manager.load(descShop);
        manager.load(descShopOver);

        manager.load(descLogoSR);


    }

    @Override
    public void prepare(){
        super.prepare();

        AssetManager manager = getManager();

        final float width = stage.getViewport().getWorldWidth();

        iLogoSR = new Image(manager.get(descLogoSR));
        iLogoSR.setOrigin(Align.center);
        iLogoSR.setPosition(width/2,1400, Align.center);

        Button.ButtonStyle sExit = new Button.ButtonStyle();
        sExit.up = new TextureRegionDrawable(new TextureRegion(manager.get(descExit)));
        sExit.over = new TextureRegionDrawable(new TextureRegion(manager.get(descExitOver)));
        sExit.down = sExit.over;
        bExit = new Button(sExit);
        bExit.setOrigin(Align.center);
        bExit.setPosition(width/2 + 180, 400, Align.center);
        bExit.addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                Gdx.app.exit();
            }
        });


        Button.ButtonStyle sNoads = new Button.ButtonStyle();
        sNoads.up = new TextureRegionDrawable(new TextureRegion(manager.get(descNoads)));
        sNoads.over = new TextureRegionDrawable(new TextureRegion(manager.get(descNoadsOver)));
        sNoads.down = sNoads.over;
        bNoads = new Button(sNoads);
        bNoads.setOrigin(Align.center);
        bNoads.setPosition(width/2 + 90, 220, Align.center);

        Button.ButtonStyle sPlay = new Button.ButtonStyle();
        sPlay.up = new TextureRegionDrawable(new TextureRegion(manager.get(descPlay)));
        sPlay.over = new TextureRegionDrawable(new TextureRegion(manager.get(descPlayOver)));
        sPlay.down = sPlay.over;
        bPlay = new Button(sPlay);
        bPlay.setOrigin(Align.center);
        bPlay.setPosition(width/2 , 600, Align.center);
        bPlay.addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                requestScreen(Main.ScreenIDs.PlayScreen.getID());
            }
        });

        Button.ButtonStyle sLeadboard = new Button.ButtonStyle();
        sLeadboard.up = new TextureRegionDrawable(new TextureRegion(manager.get(descLeadboard)));
        sLeadboard.over = new TextureRegionDrawable(new TextureRegion(manager.get(descLeadboardOver)));
        sLeadboard.down = sLeadboard.over;
        bLeadboard = new Button(sLeadboard);
        bLeadboard.setOrigin(Align.center);
        bLeadboard.setPosition(width/2 - 90, 220, Align.center);

        Button.ButtonStyle sSettings = new Button.ButtonStyle();
        sSettings.up = new TextureRegionDrawable(new TextureRegion(manager.get(descSettings)));
        sSettings.over = new TextureRegionDrawable(new TextureRegion(manager.get(descSettingsOver)));
        sSettings.down = sSettings.over;
        bSettings = new Button(sSettings);
        bSettings.setOrigin(Align.center);
        bSettings.setPosition(width/2 - 180, 400, Align.center);
        bSettings.addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {

            }
        });

        Button.ButtonStyle sShop = new Button.ButtonStyle();
        sShop.up = new TextureRegionDrawable(new TextureRegion(manager.get(descShop)));
        sShop.over = new TextureRegionDrawable(new TextureRegion(manager.get(descShopOver)));
        sShop.down = sShop.over;
        bShop = new Button(sShop);
        bShop.setOrigin(Align.center);
        bShop.setPosition(width/2, 400, Align.center);
        bShop.addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {

            }
        });

        stage.addActor(iLogoSR);
        stage.addActor(bExit);
        stage.addActor(bLeadboard);
        stage.addActor(bNoads);
        stage.addActor(bPlay);
        stage.addActor(bSettings);
        stage.addActor(bShop);

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
    }

    @Override
    public void dispose() {

        AssetManager manager = getManager();

        manager.unload(descExit.fileName);
        manager.unload(descExitOver.fileName);
        manager.unload(descNoads.fileName);
        manager.unload(descNoadsOver.fileName);
        manager.unload(descPlay.fileName);
        manager.unload(descPlayOver.fileName);
        manager.unload(descLeadboard.fileName);
        manager.unload(descLeadboardOver.fileName);
        manager.unload(descSettings.fileName);
        manager.unload(descSettingsOver.fileName);
        manager.unload(descShop.fileName);
        manager.unload(descShopOver.fileName);

        manager.unload(descLogoSR.fileName);

    }
}
