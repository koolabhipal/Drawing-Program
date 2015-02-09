package com.drawing;

/**
 * @author Abhishek Pal
 */
public class Canvas {

    private char[][] canvasState;
    private Integer width;
    private Integer height;


    private void drawCompleteCanvas() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(canvasState[i][j]);
            }
            System.out.print("\n");
        }
    }

    public Canvas(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        canvasState = new char[width][height];
        initBlankCanvas();
        createNewCanvas();
    }

    private void initBlankCanvas() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                canvasState[i][j] = ' ';
            }
        }
    }

    private void createNewCanvas() {
        for (int i = 0; i < height; i++) {
            canvasState[0][i] = '-';
            canvasState[width - 1][i] = '-';
        }
        for (int i = 0; i < width; i++) {
            canvasState[i][0] = '|';
            canvasState[i][height - 1] = '|';
        }
        drawCompleteCanvas();
    }

    public void paintCanvas(Integer x, Integer y, char fillCharacter) {
        fillCanvas(x, y, fillCharacter);
        drawCompleteCanvas();
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

    public void drawRectangle(Integer x1, Integer y1, Integer x2, Integer y2) {
        if (y1 > height - 1 || x1 > width - 1 || y2 > height - 1 || x2 > width - 1) {
            System.out.print("Coordinates exceeds the canvas size!!\n");
            return;
        }

        for (int i = y1; i < y2; i++) {
            canvasState[x1][i] = 'x';
            canvasState[x2][i] = 'x';
        }
        for (int i = x1; i < x2; i++) {
            canvasState[i][y1] = 'x';
            canvasState[i][y2] = 'x';
        }
        drawCompleteCanvas();
    }


    public void drawLine(Integer x1, Integer y1, Integer x2, Integer y2) {
        if (!x1.equals(x2) && !y1.equals(y2)) {
            System.out.print("Only vertical and horizontal lines are supported!!\n");
            return;
        }
        if (y1 > height - 1 || x1 > width - 1 || y2 > height - 1 || x2 > width - 1) {
            System.out.print("Coordinates exceeds the canvas size!!\n");
            return;
        }
        if (x1.equals(x2)) {
            for (int i = y1; i < y2; i++) {
                canvasState[x1][i] = 'x';
            }
        } else {
            for (int i = x1; i < x2; i++) {
                canvasState[i][y1] = 'x';
            }
        }
        drawCompleteCanvas();
    }

}
