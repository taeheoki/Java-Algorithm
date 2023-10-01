package src.week_39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * BOJ 2156 - 포도주 시식
 */
public class BOJ2156 {
    static int n;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        pro();
    }

    private static void pro() {
        dp = new int[n][3];

        dp[0][1] = arr[0];
        dp[0][2] = arr[0];
        if (n >= 2) {
            dp[1][0] = arr[0];
            dp[1][1] = Math.max(arr[0], arr[1]);
            dp[1][2] = arr[0] + arr[1];
        }
        for (int i = 2; i < n; i++) {
            dp[i][2] = dp[i - 1][1] + arr[i];
            dp[i][1] = Math.max(dp[i - 2][2], Math.max(dp[i - 2][1], dp[ i - 2][0])) + arr[i];
            dp[i][0] = Math.max(dp[i - 1][2], Math.max(dp[i - 1][1], dp[i - 1][0]));
        }
        System.out.println(Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2])));
    }
}
