package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 18/10/2018.
 */
public class Player implements KeyboardHandler {

    private Rectangle cellPlayer;
    private Grid gridPlayer;
    private CellColor brushColor;

    private int column;
    private int row;



    public Player(Grid gridPlayer) {

        this.column = 10;
        this.row = 10;
        brushColor = CellColor.BLACK;

        cellPlayer = new Rectangle(Grid.PADDING + (Cell.CELLSIZE * column), Grid.PADDING + (Cell.CELLSIZE * row), Cell.CELLSIZE, Cell.CELLSIZE);
        cellPlayer.setColor(Color.BLACK);
        cellPlayer.fill();
        this.gridPlayer = gridPlayer;

    }


    //POINTER MOVEMENTS

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


    //PAINT THE POINTER WITH THE CURRENT COLOR

    public void paintMySelf() {
        cellPlayer.setColor(brushColor.nextColor().getSimpleGfxColor());
    }


    //GETTERS COLUMN AND ROW

    public int getColl() {
        return column;
    }

    public int getRow() {
        return row;
    }


    //KEYBOARD MANAGER - MOVEMENT (ARROWS), PAINT CELL (SPACE), NEXT COLOR (R), SAVE (S), CLEAR (C), LOAD (L)

    public void startKeyboard() {

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

        KeyboardEvent paint = new KeyboardEvent();
        paint.setKey(KeyboardEvent.KEY_SPACE);
        paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(paint);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(load);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(save);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKey(KeyboardEvent.KEY_C);
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(clear);

        KeyboardEvent changeColor = new KeyboardEvent();
        changeColor.setKey(KeyboardEvent.KEY_R);
        changeColor.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(changeColor);

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
                gridPlayer.getCell(this.column, this.row).paintCell(brushColor.getCurrentColor());
                break;
            case KeyboardEvent.KEY_L:
                gridPlayer.load();
                break;
            case KeyboardEvent.KEY_S:
                gridPlayer.save();
                break;
            case KeyboardEvent.KEY_C:
                gridPlayer.clear();
                break;
            case KeyboardEvent.KEY_R:
                paintMySelf();
                break;
            default:
                System.out.println("Something has gone really bad...");
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {}

}
