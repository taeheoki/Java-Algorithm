package src.week_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2073 - 수도배관공사
 */
public class Pro2073 {
    static int D, P;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        dp = new int[D + 1];
        dp[0] = Integer.MAX_VALUE;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int capacity = Integer.parseInt(st.nextToken());
            for (int y = D; y >= length; y--) {
                dp[y] = Math.max(dp[y], Math.min(capacity, dp[y - length]));
            }
        }
        System.out.println(dp[D]);
    }
}
