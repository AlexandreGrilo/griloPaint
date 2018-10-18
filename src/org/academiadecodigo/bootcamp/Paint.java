package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 18/10/2018.
 */
public class Paint {

    private Grid grid;


    public Paint() {

    }

    public void start() {

        this.grid = new Grid(20, 20);
    }


}
