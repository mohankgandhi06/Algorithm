package khan;

public class MultipleRecursive {

    private static int midPoint;//for splitting four parts
    private static char canvas[][];

    public static void main(String[] args) {
        drawSquare(11, 11);
        drawSierpinski(0, 0, 11);
        displayCanvas();
    }

    public static void drawSierpinski(int xcoordinate, int ycoordinate, int length) {
        if (length != 1) {
            drawDiagonals(xcoordinate, ycoordinate, length);//Only in the upper right, upper left, lower left
            splitSquareIntoFourParts(xcoordinate, ycoordinate, length);
            length = midPoint;
            //drawSierpinski(xcoordinate, ycoordinate, length);//upper right
            //drawSierpinski(xcoordinate, midPoint, length);//upper left
            //drawSierpinski(midPoint, midPoint, length);//lower left
        }
    }

    public static void drawSquare(int length, int breadth) {
        canvas = new char[ length ][ breadth ];
        for (int i = 0; i < canvas.length; i++) {//height
            for (int j = 0; j < canvas.length; j++) {
                if ((i == 0) || (i == canvas.length - 1)) {
                    canvas[ i ][ j ] = '*';
                } else if ((j == 0) || (j == canvas.length - 1)) {
                    canvas[ i ][ j ] = '*';
                } else {
                    canvas[ i ][ j ] = ' ';
                }
            }
        }
    }

    public static void drawDiagonals(int xcoordinate, int ycoordinate, int length) {
        for (int i = xcoordinate; i < length; i++) {//height
            for (int j = ycoordinate; j < length; j++) {
                if ((i == j)) {
                    canvas[ i ][ j ] = '*';
                } else if ((i + j == length-1) && i < j) {
                    canvas[ i ][ j ] = '*';
                }
            }
        }
    }

    public static void splitSquareIntoFourParts(int xcoordinate, int ycoordinate, int length) {//We consider that the midpoint will exactly divisible
        midPoint = (xcoordinate + length) / 2;
        for (int i = xcoordinate; i < length; i++) {//height
            for (int j = ycoordinate; j < length; j++) {
                if ((i == midPoint) || (j == midPoint)) {
                    canvas[ i ][ j ] = '*';
                }
            }
        }
    }

    public static void displayCanvas() {
        for (int i = 0; i < canvas.length; i++) {//height
            for (int j = 0; j < canvas.length; j++) {
                System.out.print(" " + canvas[ i ][ j ]);
            }
            System.out.println();
        }
    }
}