package src.week_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 18110 - solved.ac
 */
public class Pro18110 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int sum = 0;
        int tmp = (int) Math.round(n * 0.15);
        for (int i = tmp; i < n - tmp; i++) {
            sum += arr[i];
        }
        System.out.println(Math.round((double) sum / (n - 2 * tmp)));
    }
}
