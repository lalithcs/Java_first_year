import java.util.Arrays;
/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:28-11-2023
 * Project: Fibonacci.java
 */
public class SortArrayUsingThreads {

        public static void parallelMergeSort(int[] arr, int numOfThreads) {
            if (numOfThreads <= 1) {
                mergeSort(arr);
            } else if (arr.length > 1) {
                int mid = arr.length / 2;

                int[] left = Arrays.copyOfRange(arr, 0, mid);
                int[] right = Arrays.copyOfRange(arr, mid, arr.length);

                Thread leftSorter = mergeSortThread(left, numOfThreads / 2);
                Thread rightSorter = mergeSortThread(right, numOfThreads / 2);

                leftSorter.start();
                rightSorter.start();

                try {
                    leftSorter.join();
                    rightSorter.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                merge(left, right, arr);
            }
        }

        private static Thread mergeSortThread(int[] arr, int numOfThreads) {
            return new Thread(() -> parallelMergeSort(arr, numOfThreads));
        }
        private static void mergeSort(int[] arr) {
            if (arr.length > 1) {
                int mid = arr.length / 2;
                int[] left = Arrays.copyOfRange(arr, 0, mid);
                int[] right = Arrays.copyOfRange(arr, mid, arr.length);

                mergeSort(left);
                mergeSort(right);

                merge(left, right, arr);
            }
        }
        private static void merge(int[] left, int[] right, int[] arr) {
            int i = 0, j = 0, k = 0;

            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }

            while (i < left.length) {
                arr[k++] = left[i++];
            }

            while (j < right.length) {
                arr[k++] = right[j++];
            }
        }
        public static void main(String[] args) {
            int[] arr = {12, 11, 13, 5, 6, 7};
            int numOfThreads = Runtime.getRuntime().availableProcessors();
            System.out.println("Original Array: " + Arrays.toString(arr));
            parallelMergeSort(arr, numOfThreads);
            System.out.println("Sorted Array: " + Arrays.toString(arr));
        }
}