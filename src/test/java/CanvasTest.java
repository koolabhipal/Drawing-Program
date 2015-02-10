import com.drawing.Canvas;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

/**
 * @author Abhishek Pal
 */
public class CanvasTest {

    @Test
    public void testCanvas() {
        Integer width = 50;
        Integer height = 60;
        Canvas canvas = new Canvas(width, height);
        char[][] canvasState = Whitebox.getInternalState(canvas, "canvasState");
        Assert.assertEquals(canvasState.length, 50);
        Assert.assertEquals(canvasState[0].length, 60);
        for (int i = 0; i < height; i++) {
            Assert.assertEquals(canvasState[0][i], '-');
            Assert.assertEquals(canvasState[width - 1][i], '-');
        }
        for (int i = 1; i < width - 1; i++) {
            Assert.assertEquals(canvasState[i][0], '|');
            Assert.assertEquals(canvasState[i][height - 1], '|');
        }
    }

    @Test
    public void testDrawLine() {
        Canvas canvas = new Canvas(50, 60);
        Integer x1 = 3;
        Integer y1 = 6;
        Integer x2 = 3;
        Integer y2 = 38;
        canvas.drawLine(x1, y1, x2, y2);
        char[][] canvasState = Whitebox.getInternalState(canvas, "canvasState");
        testHorizontalLineExistence(canvasState[x1], y1, y2);
    }

    private void testHorizontalLineExistence(char[] chars, Integer y1, Integer y2) {
        for (int i = y1; i < y2; i++) {
            Assert.assertEquals(chars[i], 'x');
        }
    }

    private void testVerticalLineExistence(char[][] chars, Integer x1, Integer x2, Integer y) {
        for (int i = x1; i < x2; i++) {
            Assert.assertEquals(chars[i][y], 'x');
        }
    }


    @Test
    public void testDrawRectangle() {
        Canvas canvas = new Canvas(50, 60);
        Integer x1 = 3;
        Integer y1 = 6;
        Integer x2 = 33;
        Integer y2 = 38;
        canvas.drawRectangle(x1, y1, x2, y2);
        char[][] canvasState = Whitebox.getInternalState(canvas, "canvasState");
        testHorizontalLineExistence(canvasState[x1], y1, y2);
        testHorizontalLineExistence(canvasState[x2], y1, y2);
        testVerticalLineExistence(canvasState, x1, x2, y1);
        testVerticalLineExistence(canvasState, x1, x2, y1);
    }

    @Test
    public void testFillArea() {
        Canvas canvas = new Canvas(50, 60);
        canvas.drawRectangle(3, 6, 33, 38);
        canvas.paintCanvas(7, 7, 'O');                      // (7,7) being a point inside the drawn rectangle
        char[][] canvasState = Whitebox.getInternalState(canvas, "canvasState");
        Assert.assertEquals(canvasState[15][15], 'O');      // (15,15) is also a point inside the rectangle so should be filled with 'O'
        Assert.assertEquals(canvasState[45][45], ' ');      // (45,45) is a point outside the rectangle so should be blank
    }

}
