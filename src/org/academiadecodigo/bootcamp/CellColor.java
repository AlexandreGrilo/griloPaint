package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;


public enum CellColor {

    BLACK(Color.BLACK),
    BLUE(Color.BLUE),
    YELLOW(Color.YELLOW),
    ORANGE(Color.ORANGE),
    RED(Color.RED);

    private Color simpleGfxColor;
    private int index;

    CellColor(Color simpleGfxColor) {
        this.simpleGfxColor = simpleGfxColor;
        this.index = 0;

    }

    public Color getSimpleGfxColor() {
        return simpleGfxColor;
    }

    public CellColor getCurrentColor() {
        return CellColor.values()[index];
    }

    public CellColor nextColor() {

        if (index < CellColor.values().length - 1) {
            index += 1;
            System.out.println(index);
            return CellColor.values()[index];
        }
        System.out.println(index);
        index = 0;
        return CellColor.values()[index];
    }
}
