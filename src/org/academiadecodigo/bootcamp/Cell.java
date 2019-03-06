package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Cell {

    private Rectangle cell;
    private boolean filled;
    private int column;
    private int row;
    private CellColor cellColor;



    public static final int CELLSIZE = 20;

    public Cell(int column, int row) {

        this.column = column;
        this.row = row;
        this.filled = false;
        this.cellColor = CellColor.BLACK;

        cell = new Rectangle(column, row, CELLSIZE, CELLSIZE);
        cell.draw();


    }

    public void paintCell(CellColor color) {

        if (filled) {
            cell.setColor(color.getSimpleGfxColor());
            cell.draw();
            filled = false;
            return;
        }
        cell.setColor(color.getSimpleGfxColor());
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


    @Override
    public String toString() {
        return filled ? String.valueOf(cellColor.getCurrentColor().ordinal()) : "0";
    }
}
