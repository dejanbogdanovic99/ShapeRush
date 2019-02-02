package com.semblergames.shaperush.utils.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.semblergames.shaperush.game.Barrier;
import com.semblergames.shaperush.game.CSChange;
import com.semblergames.shaperush.game.GameObject;
import com.semblergames.shaperush.game.Gate;
import com.semblergames.shaperush.game.ObstacleGroup;
import com.semblergames.shaperush.game.RushingShape;

public class GameRenderer {

    private Array<CSChange> csChanges;
    private Array<Gate> gates;
    private Array<Barrier> barriers;

    private RushingShape rushingShape;

    public GameRenderer(RushingShape rushingShape){
        this.rushingShape = rushingShape;
        csChanges = new Array<CSChange>(false,13);
        gates = new Array<Gate>(false,13);
        barriers = new Array<Barrier>(false, 13);
    }

    public void clear(){
        csChanges.size = 0;
        gates.size = 0;
        barriers.size = 0;
    }

    public void process(ObstacleGroup obstacleGroup){
        for(int i = 0; i < ObstacleGroup.COLUMNS; i++){
            for(int j = 0; j < obstacleGroup.getSize(i); j++){
                GameObject go = obstacleGroup.getObstacle(j,i);
                if(go instanceof Barrier){
                    barriers.add((Barrier)go);
                }else if(go instanceof Gate){
                    gates.add((Gate)go);
                }else{
                    csChanges.add((CSChange)go);
                }
            }
        }
    }

    public void draw(SpriteBatch batch){

        rushingShape.draw(batch);

        for(Barrier barrier: barriers){
            barrier.draw(batch);
        }
        for(Gate gate : gates){
            gate.draw(batch);
        }
        for(CSChange csChange : csChanges){
            csChange.draw(batch);
        }

    }

}
