/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author:
 *
 *************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {

	// WRITE YOUR CODE HERE
    double h = (length * Math.sqrt(3))/2.0;
    return h;

    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {

	// WRITE YOUR CODE HERE
    double x2 = x+(length/2);
    double y2 = y + height(length);
    double x3 = x-(length/2);
    double y3 = y + height(length);
    double[] xArr = {x,x2,x3};
    double[] yArr = {y,y2,y3};
    StdDraw.filledPolygon(xArr, yArr);

    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {

	// WRITE YOUR CODE HERE
    if(n == 1)
    {
    filledTriangle(x, y, length);
    }
    else
    {
        filledTriangle(x, y, length);
        double height = height(length) + y;
        sierpinski(n-1, x + (length/2.0), y, length/2);
        sierpinski(n-1, x - (length/2.0), y, length/2);
        sierpinski(n-1, x, y+height(length), length/2);
    }
    
    
    
    }

    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {

	// WRITE YOUR CODE HERE 
    int n = Integer.parseInt(args[0]);
    StdDraw.line(0, 0, 1, 0);
    StdDraw.line(0, 0, 0.5, height(1));
    StdDraw.line(1, 0, 0.5, height(1));
    sierpinski(n, 0.5, 0, 0.5);

    //sierpinski(3, 0.5, 0, 0.5);
    }
}
