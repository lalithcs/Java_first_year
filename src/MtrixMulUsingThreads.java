/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:28-11-2023
 * Project: Fibonacci.java
 */
public class MtrixMulUsingThreads {

        static class MatrixMultiplier extends Thread {
            private final int[][] result;
            private final int[][] matrixA;
            private final int[][] matrixB;
            private final int startRow;
            private final int endRow;

            public MatrixMultiplier(int[][] result, int[][] matrixA, int[][] matrixB, int startRow, int endRow) {
                this.result = result;
                this.matrixA = matrixA;
                this.matrixB = matrixB;
                this.startRow = startRow;
                this.endRow = endRow;
            }

            public void run() {
                for (int i = startRow; i < endRow; i++) {
                    for (int j = 0; j < matrixB[0].length; j++) {
                        for (int k = 0; k < matrixA[0].length; k++) {
                            result[i][j] += matrixA[i][k] * matrixB[k][j];
                        }
                    }
                }
            }
        }

        public static int[][] multiply(int[][] matrixA, int[][] matrixB, int numOfThreads) {
            int aRows = matrixA.length;
            int aColumns = matrixA[0].length;
            int bColumns = matrixB[0].length;

            int[][] result = new int[aRows][bColumns];
            MatrixMultiplier[] multipliers = new MatrixMultiplier[numOfThreads];
            int rowsPerThread = aRows / numOfThreads;

            for (int i = 0; i < numOfThreads; i++) {
                int startRow = i * rowsPerThread;
                int endRow = (i == numOfThreads - 1) ? aRows : (i + 1) * rowsPerThread;
                multipliers[i] = new MatrixMultiplier(result, matrixA, matrixB, startRow, endRow);
                multipliers[i].start();
            }

            for (MatrixMultiplier multiplier : multipliers) {
                try {
                    multiplier.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return result;
        }

        public static void main(String[] args) {
            int[][] matrixA = {{1, 2, 3}, {4, 5, 6}};
            int[][] matrixB = {{7, 8}, {9, 10}, {11, 12}};
            int numOfThreads = Runtime.getRuntime().availableProcessors();

            System.out.println("Matrix A:");
            printMatrix(matrixA);

            System.out.println("Matrix B:");
            printMatrix(matrixB);
            int[][] result = multiply(matrixA, matrixB, numOfThreads);

            System.out.println("Result:");
            printMatrix(result);
        }
        public static void printMatrix(int[][] matrix) {
            for (int[] row : matrix) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }


}
