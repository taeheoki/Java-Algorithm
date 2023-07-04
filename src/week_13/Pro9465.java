package src.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOj 9465 - 스티커
 * 문제이해:
 */
public class Pro9465 {
    static int T, n;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- >0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][2];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    arr[j][i] = Integer.parseInt(st.nextToken());
            }
            pro();
        }
    }

    private static void pro() {
        dp = new int[n][2];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        if (n >= 2) {
            dp[1][0] = dp[0][1] + arr[1][0];
            dp[1][1] = dp[0][0] + arr[1][1];
        }
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], Math.max(dp[i - 2][0], dp[i - 2][1])) + arr[i][0];
            dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 2][0], dp[i - 2][1])) + arr[i][1];
        }
        System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));
    }
}
