package com.drawing;

import com.drawing.model.Shape;

/**
 * @author Abhishek Pal
 */
public class Canvas {

    private char[][] canvasState;
    private Integer width;
    private Integer height;

    public Canvas(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        canvasState = new char[width][height];
        initBlankCanvas();
        createNewCanvas();
    }

    public void draw(Shape shape){
        shape.draw(this);
        displayCompleteCanvas();
    }

    public void paintCanvas(Integer x, Integer y, char fillCharacter) {
        fillCanvas(x, y, fillCharacter);
        displayCompleteCanvas();
    }

    public char[][] getCanvasState() {
        return canvasState;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    private void initBlankCanvas() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                canvasState[i][j] = ' ';
            }
        }
    }

    private void displayCompleteCanvas() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(canvasState[i][j]);
            }
            System.out.print("\n");
        }
    }

    private void createNewCanvas() {
        for (int i = 0; i < width; i++) {
            canvasState[i][0] = '|';
            canvasState[i][height - 1] = '|';
        }
        for (int i = 0; i < height; i++) {
            canvasState[0][i] = '-';
            canvasState[width - 1][i] = '-';
        }
        displayCompleteCanvas();
    }

    private void fillCanvas(Integer x, Integer y, char fillCharacter) {
        if (x > width || y > height) {
            System.out.print("Coordinates exceeds the canvas size!!\n");
            return;
        }
        if (canvasState[x][y] != ' ') {
            return;
        }
        canvasState[x][y] = fillCharacter;
        fillCanvas(x + 1, y, fillCharacter);
        fillCanvas(x, y + 1, fillCharacter);
        fillCanvas(x - 1, y, fillCharacter);
        fillCanvas(x, y - 1, fillCharacter);
    }

}
