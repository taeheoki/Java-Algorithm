package src.week_38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2467 - 용액
 */
public class BOJ2467 {
    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        int left = 0;
        int right = arr.length - 1;
        long sum = Long.MAX_VALUE;
        long[] res = new long[2];
        while (left < right) {
            if (Math.abs(arr[left] + arr[right]) < sum) {
                res[0] = arr[left];
                res[1] = arr[right];
                sum = Math.abs(arr[left] + arr[right]);
            }
            if (Math.abs(arr[left + 1] + arr[right]) < Math.abs(arr[left] + arr[right - 1])) {
                left++;
            } else
                right--;
        }
        System.out.println(res[0] + " " + res[1]);
    }
}
