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


    public static final int CELLSIZE = 10;

    public Cell(int column, int row) {

        this.column = column;
        this.row = row;
        this.filled = false;

        cell = new Rectangle(column, row, CELLSIZE, CELLSIZE);
        cell.draw();
    }

    public Rectangle getCell() {
        return cell;
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

    public void setColor(Color color) {
        cell.setColor(color);
    }

    public void draw() {
        cell.draw();
    }

    public void fill() {
        cell.fill();
    }

    public void translate(double column, double row) {
        cell.translate(column, row);
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

}
