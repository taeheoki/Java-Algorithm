package src.week_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 1003 - 피보나치 함수
 */
public class Pro1003 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        arr = new int[T];
        int max = 0;
        int i = 0;
        while (T-- > 0) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            i++;
        }
        pro(max);
        Arrays.stream(arr).forEach(num -> System.out.println(dp[num][0] + " " + dp[num][1]));
    }

    private static void pro(int max) {
        dp = new int[max + 1][2];
        dp[0][0] = 1;
        if (max > 0)
            dp[1][1] = 1;
        for (int i = 2; i <= max; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
    }
}
