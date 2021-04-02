package practice.DSA.Graph;

/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 * Given a coordinate (x, y) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor,
 * "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the
 * same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the
 * starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 *
 * At the end, return the modified image.
 */
public class FloodFill {

    public static void main(String[] args) {

        int[][] image = { {1,1,1},
                          {1,1,0},
                          {1,0,1} };

        System.out.println("Before flood filling :");
        for(int i = 0 ; i < image.length ; i++) {
            for(int j = 0 ; j < image[i].length ; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

        int existingColor = image[1][1];
        int newColor = 2;
        if(existingColor != newColor)
            fillColor(image, 1, 1, existingColor, newColor);

        System.out.println("\nAfter flood filling :");
        for(int i = 0 ; i < image.length ; i++) {
            for(int j = 0 ; j < image[i].length ; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void fillColor(int[][] image, int x, int y, int existingColor, int newColor) {

        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || existingColor != image[x][y])
            return;

        image[x][y] = newColor;

        fillColor(image, x + 1, y, existingColor, newColor);
        fillColor(image, x - 1, y, existingColor, newColor);
        fillColor(image, x, y + 1, existingColor, newColor);
        fillColor(image, x, y - 1, existingColor, newColor);
    }
}
