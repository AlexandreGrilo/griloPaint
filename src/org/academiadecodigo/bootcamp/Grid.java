package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;


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
        player.startKeyboard();


        //CREATE GRID BY CELLS
        cells = new Cell[columns][rows];

        for (int column = 0; column < columns; column++) {

            for (int row = 0; row < rows; row++) {

                cells[column][row] = new Cell(PADDING + (Cell.CELLSIZE * column), PADDING + (Cell.CELLSIZE * row));
            }
        }
    }


    // GETTERS

    public int getHeight() {
        return rows;
    }

    public int getWidth() {
        return columns;
    }

    public Cell getCell(int column, int row) {
        return cells[column][row];
    }


    public void save() {

        try {
            FileWriter writer = new FileWriter("/Users/codecadet/workSpace/projects/paint/resource/map.txt");

            BufferedWriter bWriter = new BufferedWriter(writer);


            System.out.println(toString());
            bWriter.write(toString());

            bWriter.flush();
            bWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void load() {

        clear();

        try {
            FileReader reader = new FileReader("/Users/codecadet/workSpace/projects/paint/resource/map.txt");

            BufferedReader bReader = new BufferedReader(reader);

            String line;
            int row = 0;


            while ((line = bReader.readLine()) != null) {

                for (int col = 0; col < line.length(); col++) {
                    if (line.charAt(col) == '1') {
                        cells[col][row].setColor(Color.BLACK);
                        cells[col][row].fill();
                    }
                    if (line.charAt(col) == '0') {
                        cells[col][row].setColor(Color.BLACK);
                        cells[col][row].draw();
                    }
                }
                row++;
            }


            bReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clear() {

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                cells[column][row].clear();
            }
        }
    }


    @Override
    public String toString() {
        String result = "";
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                result += cells[column][row];
            }
            result += "\n";
        }
        return result;
    }
}
