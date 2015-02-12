package com.drawing;

import com.drawing.model.Line;
import com.drawing.model.Rectangle;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Abhishek Pal (pala@spmsoftware.com)
 */
public class DrawingProgram {

    /*
    Run void main to run the program, if not being run from test cases.
    Commands supported :-
    C x y : creates a blank canvas of x width and y height.
    L x1 y1 x2 y2 : draws a line from (x1,y1) to (x2,y2). NOTE : only vertical and horizontal lines are supported
    R x1 y1 x2 y2 : draws a rectangle with (x1,y1) and (x2,y2) being its two corners
    B x y c : fills the area connect to point (x,y) with character c
    Q : exits the program
     */

    public static void main(String[] args) {
        Canvas canvas = null;
        String s = null;
        while (true) {
            System.out.println("Enter Command : ");
            try {
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                s = bufferRead.readLine();
            } catch (IOException e) {
                System.out.println("ERROR!!!");
                System.exit(1);
            }
            List<String> inputs = Lists.newArrayList(Splitter.on(' ').split(s));
            switch (inputs.get(0).charAt(0)) {
                case 'C':
                    canvas = new Canvas(Integer.valueOf(inputs.get(1)), Integer.valueOf(inputs.get(2)));
                    break;
                case 'L':
                    if (canvas == null) {
                        System.out.println("Create Canvas first!!");
                        break;
                    }
                    Line line = new Line(Integer.valueOf(inputs.get(1)), Integer.valueOf(inputs.get(2)), Integer.valueOf(inputs.get(3)), Integer.valueOf(inputs.get(4)));
                    canvas.draw(line);
                    break;
                case 'R':
                    if (canvas == null) {
                        System.out.println("Create Canvas first!!");
                        break;
                    }
                    Rectangle rectangle = new Rectangle(Integer.valueOf(inputs.get(1)), Integer.valueOf(inputs.get(2)), Integer.valueOf(inputs.get(3)), Integer.valueOf(inputs.get(4)));
                    canvas.draw(rectangle);
                    break;
                case 'B':
                    if (canvas == null) {
                        System.out.println("Create Canvas first!!");
                        break;
                    }
                    canvas.paintCanvas(Integer.valueOf(inputs.get(1)), Integer.valueOf(inputs.get(2)), inputs.get(3).charAt(0));
                    break;
                case 'Q':
                    System.exit(0);
                default:
                    System.out.println("Incorrect Command!!!");
            }
        }
    }

}
