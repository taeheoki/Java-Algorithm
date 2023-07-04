package src.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * BOJ 12865 - 평범한 배낭
 * 문제 이해: K만큼의 무게만 넣을 수 있을 때, 최대 가치를 가지게 하는 경우를 구해보자.
 */
public class Pro12865 {
    static int N, K, res;
    static int[] W, V;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        W = new int[N];
        V = new int[N];

        dp = new Integer[N][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(knapsack(N - 1, K));
    }

    private static int knapsack(int i, int k) {
        // i가 0미만, 즉 범위 밖에 된다면
        if (i < 0)
            return 0;

        // 탐색하지 않은 위치라면?
        if (dp[i][k] == null) {

            // 현재 물건(i)을 추가로 못 담는 경우 (이전 i 값 탐색)
            if (W[i] > k) {
                dp[i][k] = knapsack(i - 1, k);
            }
            // 현재 물건(i)을 담을 수 있는 경우
            else {
                // 이전 i 값과 이전 i값에 대한 k - W[i]의 값 + 현재 가치(V[i]) 중 큰 값을 저장
                dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - W[i]) + V[i]);
            }
        }
        return dp[i][k];
    }
}