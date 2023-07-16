package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 12865 - 평범한 배낭
 */
public class Pro12865 {
    static int N, K;
    static int[] wArr, vArr;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        wArr = new int[N];
        vArr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            wArr[i] = Integer.parseInt(st.nextToken());
            vArr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        dp = new Integer[N + 1][K + 1];
        System.out.println(knapsack(N - 1, K));
    }

    private static int knapsack(int index, int k) {
        if (index < 0)
            return 0;
        if (dp[index][k] == null) {
            // 탐색 불가능
            if (wArr[index] > k)
                dp[index][k] = knapsack(index - 1, k);
            // 탐색 가능
            else {
                dp[index][k] = Math.max(knapsack(index - 1, k), knapsack(index - 1, k - wArr[index]) + vArr[index]);
            }
        }
        return dp[index][k];
    }
}
