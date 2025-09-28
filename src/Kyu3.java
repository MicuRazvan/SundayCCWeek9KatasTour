//https://www.codewars.com/kata/534e01fbbb17187c7e0000c6/train/java
//Make a spiral
/*
Your task, is to create a NxN spiral with a given size.

For example, spiral with size 5 should look like this:

00000
....0
000.0
0...0
00000
and with the size 10:

0000000000
.........0
00000000.0
0......0.0
0.0000.0.0
0.0..0.0.0
0.0....0.0
0.000000.0
0........0
0000000000
Return value should contain array of arrays, of 0 and 1, with the first row being composed of 1s. For example for given size 5 result should be:

[[1,1,1,1,1],[0,0,0,0,1],[1,1,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Because of the edge-cases for tiny spirals, the size will be at least 5.

General rule-of-a-thumb is, that the snake made with '1' cannot touch to itself.
 */
public class Kyu3 {
    public static void printSpiral(int[][] spiral){
        for(int i = 0; i < spiral.length; i++){
            for(int j = 0; j < spiral[0].length; j++){
                System.out.print(spiral[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] evenSizeSolve(int size){
        int[][] spiral = new int[size][size];

        int upperLimit = 0, downLimit = size - 1, leftLimit = 0, rightLimit = size - 1;
        while(upperLimit < size/2 || downLimit > size/2 || leftLimit < size/2 || rightLimit > size/2){
            //a bit of hardcoding because I cant think of when to increase leftLimit properly without breaking the spiral
            if(leftLimit != 0){
                spiral[upperLimit][leftLimit - 1] = 1;
            }

            if(leftLimit < size/2) {
                for (int j = leftLimit; j <= rightLimit; j++) {
                    spiral[upperLimit][j] = 1;
                }
            }

            if(upperLimit < size/2) {
                for (int i = upperLimit; i <= downLimit; i++) {
                    spiral[i][rightLimit] = 1;
                }
            }

            upperLimit = upperLimit + 2;

            if(rightLimit > size/2) {
                for (int j = rightLimit; j >= leftLimit; j--) {
                    spiral[downLimit][j] = 1;
                }
            }

            rightLimit = rightLimit - 2;

            if(downLimit > size/2) {
                for (int i = downLimit; i >= upperLimit; i--) {
                    spiral[i][leftLimit] = 1;
                }
            }

            downLimit = downLimit - 2;
            leftLimit = leftLimit + 2;

        }

        return spiral;
    }

    public static int[][] oddSizeSolve(int size){
        int[][] spiral = new int[size][size];

        int upperLimit = 0, downLimit = size - 1, leftLimit = 0, rightLimit = size - 1;
        while(upperLimit < size/2 + 1 || downLimit > size/2 - 1 || leftLimit < size/2 + 1 || rightLimit > size/2 - 1){
            //a bit of hardcoding because I cant think of when to increase leftLimit properly without breaking the spiral
            if(leftLimit != 0){
                spiral[upperLimit][leftLimit - 1] = 1;
            }

            if(leftLimit < size/2 + 1) {
                for (int j = leftLimit; j <= rightLimit; j++) {
                    spiral[upperLimit][j] = 1;
                }
            }

            if(upperLimit < size/2 + 1) {
                for (int i = upperLimit; i <= downLimit; i++) {
                    spiral[i][rightLimit] = 1;
                }
            }

            upperLimit = upperLimit + 2;

            if(rightLimit > size/2 - 1) {
                for (int j = rightLimit; j >= leftLimit; j--) {
                    spiral[downLimit][j] = 1;
                }
            }

            rightLimit = rightLimit - 2;

            if(downLimit > size/2 - 1) {
                for (int i = downLimit; i >= upperLimit; i--) {
                    spiral[i][leftLimit] = 1;
                }
            }

            downLimit = downLimit - 2;
            leftLimit = leftLimit + 2;

        }

        return spiral;
    }

    public static int[][] spiralize(int size) {
        if(size%2 == 0){
            return evenSizeSolve(size);
        }
        return oddSizeSolve(size);
    }
}
