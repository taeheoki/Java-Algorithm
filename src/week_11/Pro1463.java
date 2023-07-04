package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 1463 - 1로 만들기
 * 문제 이해: 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 *          2. X가 2로 나누어떨어지면, 2로 나눈다.
 *          3. 1을 뺀다.
 *          이 과정을 통해 "1"을 만들기까지 최소 연산 횟수를 구하라
 */
public class Pro1463 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[1] = 0;
        if (N >= 2)
            dp[2] = 1;
        if (N >= 3)
            dp[3] = 1;
        for (int i = 4; i <= N; i++) {
            int cnt = N;
            if (i % 2 == 0) {
                cnt = dp[i / 2] + 1;
            }
            if (i % 3 == 0) {
                cnt = Math.min(cnt, dp[i / 3] + 1);
            }
            dp[i] = Math.min(cnt, dp[i - 1] + 1);
        }
        System.out.println(dp[N]);
    }
}
