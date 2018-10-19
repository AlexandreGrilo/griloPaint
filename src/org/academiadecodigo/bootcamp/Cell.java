package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 18/10/2018.
 */
public class Cell {

    private Rectangle cell;
    private boolean filled;
    private int column;
    private int row;


    public static final int CELLSIZE = 30;

    public Cell(int column, int row) {

        this.column = column;
        this.row = row;
        this.filled = false;

        cell = new Rectangle(column, row, CELLSIZE, CELLSIZE);
        cell.draw();
    }

    public void paintCell() {

        if (filled) {
            cell.setColor(Color.BLACK);
            cell.draw();
            filled = false;
            return;
        }
        cell.setColor(Color.ORANGE);
        cell.fill();
        filled = true;
    }

    public void clear() {
        cell.setColor(Color.BLACK);
        cell.draw();
        filled = false;
    }

    public void setColor(Color color) {
        cell.setColor(color);
    }

    public void draw() {
        cell.draw();
    }

    public boolean isFilled() {
        return filled;
    }

    public void fill() {
        cell.fill();
    }

    public void move(double column, double row) {
        cell.translate(column, row);
    }

}
