package src.week_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 17208 - 카우버거 알바생
 */
public class Pro17208 {
    static int N, M, K;
    static int[][][] dp;
    static Order[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new Order[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Order(x, y);
        }
        pro();
    }

    private static void pro() {
        dp = new int[N][M + 1][K + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k <= K; k++) {
                    dp[i][j][k] = -1; // dp 값 초기화
                }
            }
        }
        System.out.println(knapsack(0, M, K));
    }

    private static int knapsack(int pos, int c, int f) {
        if (pos == N)
            return 0; // 주문할게 없으면 0을 반환
        if (dp[pos][c][f] >= 0)
            return dp[pos][c][f]; // 이미 계산된 값
        int ret = 0;
        if (arr[pos].x <= c && arr[pos].y <= f)
            ret = knapsack(pos + 1, c - arr[pos].x, f - arr[pos].y) + 1; // 주문을 처리할 수 있음
        ret = Math.max(ret, knapsack(pos + 1, c, f));
        return dp[pos][c][f] = ret; // dp값을 갱신함과 동시에 결과값 반환
    }

    private static class Order {
        int x;
        int y;

        public Order(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
