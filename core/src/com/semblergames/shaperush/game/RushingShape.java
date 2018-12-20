package com.semblergames.shaperush.game;

public class RushingShape extends GameObject {




    public boolean intersects(Barrier barrier){
        return this.y + yOffsetReaction > barrier.y - barrier.yOffsetReaction;
    }

    public boolean intersects(GameObject gameObject){
        if(this.lane == gameObject.lane){
            return this.y + yOffsetReaction > gameObject.y - gameObject.yOffsetReaction;
        }
        return false;
    }

}
