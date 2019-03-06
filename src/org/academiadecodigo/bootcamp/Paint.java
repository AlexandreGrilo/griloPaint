package org.academiadecodigo.bootcamp;

import java.io.IOException;


public class Paint {

    private Grid grid;


    public Paint() {

    }

    public void start() throws IOException {

        this.grid = new Grid(21, 21);

    }


}
