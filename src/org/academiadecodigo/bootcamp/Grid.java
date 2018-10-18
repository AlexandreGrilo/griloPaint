package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 18/10/2018.
 */
public class Grid {

    Rectangle grid;
    Cell[][] cells;
    Player player;

    private int columns;
    private int rows;


    public static final int PADDING = 10;

    public Grid(int columns, int rows) {

        this.columns = columns;
        this.rows = rows;


        //CREATE NEW PLAYER
        this.player = new Player(this);

        //CREATE GRID BY CELLS
        cells = new Cell[columns][rows];

        for (int column = 0; column < columns; column++) {

           for (int row = 0; row < rows; row++) {

               cells[column][row] = new Cell(PADDING + (Cell.CELLSIZE * column), PADDING + (Cell.CELLSIZE * row));
           }
        }
    }


    public int getHeight() {
        return rows;
    }

    public int getWidth() {
        return columns;
    }

    public Cell getCell(int column, int row) {
        return cells[column][row];
    }

}
