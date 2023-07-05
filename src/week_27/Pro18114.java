package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 18114 - 블랙 프라이데이
 */
public class Pro18114 {
    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == C) {
                System.out.println(1);
                return;
            }
        }

        Arrays.sort(arr);
        pro();
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            int remain = C - arr[i];
            if(binarySearch(remain, i + 1, N - 1) != -1) {
                System.out.println(1);
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int remain = C - arr[i] - arr[j];
                if(binarySearch(remain, j + 1, N-1) != -1) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    private static int binarySearch(int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}