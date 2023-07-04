package src.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 15988 - 1, 2, 3 더하기 3
 * 문제 이해: n을 1, 2, 3의 합으로 나타낼 수 있는 방법의 경우의 수를 구하라.
 */
public class Pro15988 {
    static StringBuilder sb = new StringBuilder();
    static int T, max;
    static int[] nums;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        nums = new int[T];
        for (int i = 0; i < T; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, nums[i]);
        }
        pro();
        for (int i = 0; i < T; i++) {
            sb.append(dp[nums[i]]).append('\n');
        }
        System.out.println(sb);
    }

    private static void pro() {
        dp = new long[max + 1];
        if (max >= 1)
            dp[1] = 1;
        if (max >= 2)
            dp[2] = 2;
        if (max >= 3)
            dp[3] = 4;
        for (int i = 4; i <= max; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }
    }
}
