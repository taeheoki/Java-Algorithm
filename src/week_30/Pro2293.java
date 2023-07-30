package src.week_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2293 - 동전 1
 */
public class Pro2293 {
    static int n, k;
    static int[] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            for (int j = tmp; j <= k; j++) {
                dp[j] += dp[j - tmp];
            }
        }
        System.out.println(dp[k]);
    }
}
