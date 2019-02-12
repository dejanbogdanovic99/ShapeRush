package com.semblergames.shaperush.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Pool;

public class ObstacleGroup {

/*    public static final int ROWS = 6;
    public static final int COLUMNS = 5;

    private GameObject [][] obstacles;

    private int [] sizes;

    public ObstacleGroup(){
        obstacles = new GameObject[COLUMNS][ROWS];
        sizes = new int[COLUMNS];
    }

    public void generate(Pool <CSChange> csChangePool, Pool<Gate> gatePool, Pool<Barrier> barrierPool, RushingShape shape){

    }

    public int getSize(int column){
        return sizes[column];
    }

    public GameObject getObstacle(int column, int row){
        return obstacles[column][row];
    }

    public void free(Pool <CSChange> csChangePool, Pool<Gate> gatePool, Pool<Barrier> barrierPool){
        for(int i = 0; i < COLUMNS; i++){
            for(int j = 0; j < sizes[i]; j++){
                if(obstacles[i][j] instanceof CSChange){
                    csChangePool.free((CSChange)obstacles[i][j]);
                }else if(obstacles[i][j] instanceof Gate){
                    gatePool.free((Gate) obstacles[i][j]);
                }else{
                    barrierPool.free((Barrier) obstacles[i][j]);
                }


            }
            sizes[i] = 0;
        }
    }

    public void update(float delta, RushingShape shape){
        for(int i = 0; i < COLUMNS; i++){
            for(int j = 0; j < sizes[i]; j++){
                if (obstacles[i][j] instanceof CSChange) {
                    ((CSChange) obstacles[i][j]).updateToShape(shape);
                }
                obstacles[i][j].update(delta);
            }
        }
    }

    public void draw(SpriteBatch batch){
        for(int i = 0; i < COLUMNS; i++){
            for(int j = 0; j < sizes[i]; j++){
                obstacles[i][j].draw(batch);
            }
        }
    }*/

}
