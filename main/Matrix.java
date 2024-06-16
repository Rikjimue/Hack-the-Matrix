package main;

import java.awt.*;
import java.util.Random;

public class Matrix {
    private Random rand;
    private Cell[][] matrix;
    private Path[] paths;

    public Matrix(int size) {
        rand = new Random();
        matrix = generateMatrix(size);
        paths = generatePath(matrix);
    }

    private Cell[][] generateMatrix(int size) {
        Cell[][] matrix = new Cell[size][size];
        char[] letters = {'A', 'B', 'C', 'D', 'E'};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int rand_num = rand.nextInt(8);
                char rand_char = letters[rand.nextInt(letters.length)];
                String letter = String.valueOf(rand_char) + String.valueOf(rand_num);

                matrix[i][j] = new Cell("Green", letter, Color.WHITE);
            }
        }
        
        return matrix;
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    private Path[] generatePath(Cell[][] matrix) {
        int rows = matrix.length - 2;
        if (rows < 2) {
            rows = 2;
        }
        paths = new Path[rows];

        for (int i = 0; i < paths.length; i++) {
            int cols = matrix.length - rand.nextInt(3);
            int rand_placeholder = rand.nextInt(2);
            int rand_row = rand.nextInt(matrix.length);
            int rand_col = rand.nextInt(matrix.length);
            Cell[] sequence = new Cell[cols];
            for (int j = 0; j < sequence.length; j++) {
                if (j % 2 == rand_placeholder) {
                    rand_row = rand.nextInt(matrix.length);
                }
                else {
                    rand_col = rand.nextInt(matrix.length);
                }
                sequence[j] = new Cell("Green", matrix[rand_row][rand_col].getLetter(), Color.WHITE);
            }
            paths[i] = new Path(sequence);
        }

        return paths;
    }

    public Path[] getPaths() {
        return paths;
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j].getLetter() + ' ');
            }
            System.out.println();
        }
    }
}
