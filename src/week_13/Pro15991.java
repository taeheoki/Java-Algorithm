package src.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 15991 - 1, 2, 3 더하기 6
 * 문제 이해: 주어진 정수를 만들 때 합을 나타내는 숫자들이 대칭을 이루는 경우의 수
 */
public class Pro15991 {
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
        dp[1] = 1;
        if (max >= 2) {
            dp[2] = 2;
        }
        if (max >= 3) {
            dp[3] = 2;
        }
        if (max >= 4) {
            dp[4] = 3;
        }
        if (max >= 5) {
            dp[5] = 3;
        }
        if (max >= 6) {
            dp[6] = 6;
        }
        for (int i = 7; i <= max; i++) {
            dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % 1000000009;
        }
    }
}
