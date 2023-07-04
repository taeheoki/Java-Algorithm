package src.week_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2293 - 동전 1
 * 5 - 2, 2 - 0, 1 - 0
 * 5 - 1, 2 - 2, 1 - 1
 * 5 - 1, 2 - 1, 1 - 3
 * 5 - 1, 2 - 0, 1 - 5
 * 5 - 0, 2 - 5, 1 - 0
 * 5 - 0, 2 - 4, 1 - 2
 * 5 - 0, 2 - 3, 1 - 4
 * 5 - 0, 2 - 2, 1 - 6
 * 5 - 0, 2 - 1, 1 - 8
 * 5 - 0, 2 - 0, 1 - 10
 * dp[0] = 0
 * dp[1] = 1
 * dp[2] = 1 + 1
 * dp[3] = 2 + 1
 * dp[4] =
 */
public class Pro2293 {
    static int n, k;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = arr[i]; j <= k; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
