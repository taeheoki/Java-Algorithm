package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
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

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            for (int j = people; j < C + 101; j++) {
                dp[j] = Math.min(dp[j], cost + dp[j - people]);
            }
        }
        int result=Integer.MAX_VALUE;
        for (int i = C; i < C + 101; i++) {
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }
}
