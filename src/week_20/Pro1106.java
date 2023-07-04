package src.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 1106 - 호텔
 */
public class Pro1106 {
    static int C, N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new int[C + 101];
        Arrays.fill(dp, C * 100);
        dp[0] = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            for (int i = people; i < dp.length; i++) {
                dp[i] = Math.min(dp[i], dp[i - people] + cost);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = C; i < C + 101; i++) {
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }
}
