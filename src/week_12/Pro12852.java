package src.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BOJ 12852 - 1로 만들기 2
 * 문제 이해: 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 *          2. X가 2로 나누어 떨어지면, 2로 나눈다.
 *          3. 1을 뺀다.
 */
public class Pro12852 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] visit, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        visit = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            visit[i] = i - 1;

            if (i % 3 == 0 && (dp[i / 3] + 1 < dp[i])) {
                dp[i] = dp[i / 3] + 1;
                visit[i] = i / 3;
            }
            if (i % 2 == 0 && (dp[i / 2] + 1 < dp[i])) {
                dp[i] = dp[i / 2] + 1;
                visit[i] = i / 2;
            }
        }
        int idx = N;
        while (true) {
            sb.append(idx).append(' ');
            if (idx == 1)
                break;
            idx = visit[idx];
        }
        System.out.println(dp[N]);
        System.out.println(sb);
    }
}
