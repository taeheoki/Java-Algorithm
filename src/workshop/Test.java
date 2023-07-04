package src.workshop;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Test {
    static final int TEST_NUMBER = 1000000;

    static StringBuilder sb = new StringBuilder();
    static long find_cnt, swap_cnt;

    public static void main(String[] args) {
        long beforeTime;
        long afterTime;
        long timeDiff;

//        int[] arr = testNormalCase();
        int[] arr = NoOverlab();
        beforeTime = System.currentTimeMillis();
        bubbleSort(arr);
        afterTime = System.currentTimeMillis();
        timeDiff = afterTime - beforeTime;
        System.out.println("Normal Case 소요 시간(ms): " + timeDiff + " find_cnt: " + find_cnt + " swap_cnt: " + swap_cnt);

        int[] arr2 = testWorstCase();
        beforeTime = System.currentTimeMillis();
        bubbleSort(arr2);
        afterTime = System.currentTimeMillis();
        timeDiff = afterTime - beforeTime;
        System.out.println("Worst Case 소요 시간(ms): " + timeDiff  + " find_cnt: " + find_cnt + " swap_cnt: " + swap_cnt);
    }

    private static int[] testNormalCase() {
        Random random = new Random();
        int[] arr = new int[TEST_NUMBER];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
//            arr[i] = i;
        }
        return arr;
    }

    private static int[] NoOverlab() {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();

        while (set.size() < TEST_NUMBER) {
            set.add(random.nextInt());
        }

        int[] arr = new int[set.size()];
        int i = 0;
        for (int num : set) {
            arr[i++] = num;
        }
        return arr;
    }

    private static int[] testWorstCase() {
        int[] arr = new int[TEST_NUMBER];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }
        return arr;
    }


    private static void bubbleSort(int[] arr) {
        find_cnt = 0;
        swap_cnt = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                find_cnt++;
                if (arr[j] > arr[j + 1]) {
                    swap_cnt++;
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap arr[i] and arr[minIdx]
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}
