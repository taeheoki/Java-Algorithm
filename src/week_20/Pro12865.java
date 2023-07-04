package src.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 12865 - 평범한 배낭
 */
public class Pro12865 {
    static int N, K;
    static int[] W, V;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        W = new int[N];
        V = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        dp = new Integer[N + 1][K + 1];
        System.out.println(knapsack(N -1, K));
    }

    private static int knapsack(int idx, int k) {
        if (idx < 0)
            return 0;

        if (dp[idx][k] == null) {
            // 탐색 불가능
            if (W[idx] > k)
                dp[idx][k] = knapsack(idx - 1, k);
            // 탐색 가능
            else {
                dp[idx][k] = Math.max(knapsack(idx - 1, k), knapsack(idx - 1, k - W[idx]) + V[idx]);
            }
        }
        return dp[idx][k];
    }
}
