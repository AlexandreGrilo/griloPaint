package org.academiadecodigo.bootcamp;

import java.io.IOException;

/**
 * Created by codecadet on 18/10/2018.
 */
public class Paint {

    private Grid grid;


    public Paint() {

    }

    public void start() throws IOException {

        this.grid = new Grid(20, 20);

    }


}
