package src.workshop;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class QuickSort {
    /*

     */

    public static void main(String[] args) throws IOException {
        long beforeTime = System.currentTimeMillis();
        testNormalCase();
        long afterTime = System.currentTimeMillis();
        long timeDiff = afterTime - beforeTime;
        System.out.println("소요 시간(ms): " + timeDiff);

        beforeTime = System.currentTimeMillis();
        testWorstCase();
        afterTime = System.currentTimeMillis();
        timeDiff = afterTime - beforeTime;
        System.out.println("소요 시간(ms): " + timeDiff);
    }

    public static void quickSort(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length - 1);

        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();

            int pivotIndex = partition(arr, start, end);

            if (pivotIndex - 1 > start) {
                stack.push(start);
                stack.push(pivotIndex - 1);
            }

            if (pivotIndex + 1 < end) {
                stack.push(pivotIndex + 1);
                stack.push(end);
            }
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, end);

        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


//    private static void quickSort(int[] arr, int low, int high) {
//        if (low >= high) {
//            return;
//        }
//
//        int pivot = low;
//        int left = low + 1;
//        int right = high;
//        while (left <= right) {
//            while (left <= high && arr[left] <= arr[pivot]) {
//                left++;
//            }
//
//            while (right > low && arr[right] >= arr[pivot]) {
//                right--;
//            }
//
//            if (left <= right) {
//                int tmp = arr[right];
//                arr[right] = arr[left];
//                arr[left] = tmp;
//            } else {
//                int tmp = arr[pivot];
//                arr[pivot] = arr[right];
//                arr[right] = tmp;
//            }
//        }
//
//        quickSort(arr, low, right - 1);
//        quickSort(arr, right + 1, high);
//    }

    private static void testNormalCase() {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        // shuffle the array to create the worst-case scenario
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int j = rand.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        quickSort(arr);
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i] > arr[i + 1]) {
//                System.out.println("비정상적으로 종료되었습니다.");
//                break;
//            }
//        }
    }

    private static void testWorstCase() {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        quickSort(arr);
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i] > arr[i + 1]) {
//                System.out.println("비정상적으로 종료되었습니다.");
//                break;
//            }
//        }
    }
}