package src.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 11052 - 카드 구매하기
 * 문제 이해: N개의 카드를 구매할 때, 비싼 값을 지불할 수록 좋은 카드가 있을 것이라 생각하기에
 *          주어진 카드팩을 N개 구매할 때 최대 값을 구하라.
 */
public class Pro11052 {
    static int N;
    static int[] P, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N + 1];
        dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            dp[i] = P[i];
        }
        pro();
        System.out.println(dp[N]);
    }

    private static void pro() {
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + P[i - j]);
            }
        }
    }
}
