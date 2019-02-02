package com.semblergames.shaperush.game.utils;

public class Types {

    public enum Color{
        RED(0),GREEN(1),BLUE(2),SPECIAL(-1);

        private int value;

        Color(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }


    }

    public enum Shape{
        CIRCLE(0),SQUARE(1),TRIANGLE(2), SPECIAL(-1);

        private int value;

        Shape(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

}
