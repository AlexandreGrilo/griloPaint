package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 18/10/2018.
 */
public class Player implements KeyboardHandler {

    private Cell cellPlayer;
    private Grid gridPlayer;

    private int column;
    private int row;


    public Player(Grid gridPlayer) {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);


        this.column = 10;
        this.row = 10;
        cellPlayer = new Cell(Grid.PADDING + (Cell.CELLSIZE * column), Grid.PADDING + (Cell.CELLSIZE * row));
        cellPlayer.setColor(Color.ORANGE);
        cellPlayer.fill();

        this.gridPlayer = gridPlayer;
    }


    public void moveUp() {
        if (getRow() > 0) {
            cellPlayer.translate(0, -Cell.CELLSIZE);
            row--;
        }
    }

    public void moveDown() {
        if (getRow() < gridPlayer.getHeight() - 1) {
            cellPlayer.translate(0, Cell.CELLSIZE);
            row++;
        }
    }

    public void moveLeft() {
        if (getColl() > 0) {
            cellPlayer.translate(-Cell.CELLSIZE, 0);
            column--;
        }
    }

    public void moveRight() {
        if (getColl() < gridPlayer.getWidth() - 1) {
            cellPlayer.translate(Cell.CELLSIZE, 0);
            column++;
        }
    }


    public int getColl() {
        return column;
    }

    public int getRow() {
        return row;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_LEFT:
                moveLeft();
                break;
            case KeyboardEvent.KEY_RIGHT:
                moveRight();
                break;
            case KeyboardEvent.KEY_UP:
                moveUp();
                break;
            case KeyboardEvent.KEY_DOWN:
                moveDown();
                break;
            case KeyboardEvent.KEY_SPACE:
                gridPlayer.getCell(this.column, this.row).paintCell();
                break;
            default:
                System.out.println("Something has gone really bad...");
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
