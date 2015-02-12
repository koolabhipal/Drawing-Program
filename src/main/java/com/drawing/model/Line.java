package com.drawing.model;

import com.drawing.Canvas;

/**
 * @author Abhishek Pal
 */
public class Line implements Shape {

    Integer x1;
    Integer y1;
    Integer x2;
    Integer y2;

    public Line(Integer x1, Integer y1, Integer x2, Integer y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    @Override
    public void draw(Canvas canvas) {
        if (!x1.equals(x2) && !y1.equals(y2)) {
            System.out.print("Only vertical and horizontal lines are supported!!\n");
            return;
        }
        if (y1 > canvas.getHeight() - 1 || x1 > canvas.getWidth() - 1 || y2 > canvas.getHeight() - 1 || x2 > canvas.getWidth() - 1) {
            System.out.print("Coordinates exceeds the canvas size!!\n");
            return;
        }
        if (x1.equals(x2)) {
            for (int i = y1; i < y2; i++) {
                canvas.getCanvasState()[x1][i] = 'x';
            }
        } else {
            for (int i = x1; i < x2; i++) {
                canvas.getCanvasState()[i][y1] = 'x';
            }
        }
    }
}
