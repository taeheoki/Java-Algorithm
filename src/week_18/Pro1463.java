package src.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BOJ 1463 - 1로 만들기
 */
public class Pro1463 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        pro();
        System.out.println(dp[N]);
    }

    private static void pro() {
        dp[1] = 0;
        if (N >= 2) {
            dp[2] = 1;
        }
        if (N >= 3) {
            dp[3] = 1;
        }
        for (int i = 4; i <= N; i++) {
            int cnt = N;
            if (i % 2 == 0) {
                cnt = Math.min(cnt, dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                cnt = Math.min(cnt, dp[i / 3] + 1);
            }
            dp[i] = Math.min(cnt, dp[i - 1] + 1);
        }
    }
}
