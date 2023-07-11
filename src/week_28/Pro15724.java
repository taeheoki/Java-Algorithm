package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 15724 - 주지수
 */
public class Pro15724 {
    static StringBuilder sb = new StringBuilder();
    static int N, M, K, x1, y1, x2, y2;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        setCumulativeMap();

        K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken()) - 1;
            y1 = Integer.parseInt(st.nextToken()) - 1;
            x2 = Integer.parseInt(st.nextToken()) - 1;
            y2 = Integer.parseInt(st.nextToken()) - 1;
            int sum = dp[x2][y2];
            if (y1 != 0)
                sum -= dp[x2][y1 - 1];
            if (x1 != 0)
                sum -= dp[x1 - 1][y2];
            if (x1 != 0 && y1 != 0)
                sum += dp[x1 - 1][y1 - 1];
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }

    private static void setCumulativeMap() {
        dp = new int[N][M];
        dp[0][0] = map[0][0];
        // 가로
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }
        // 세로
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }
        // 나머지
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + map[i][j];
            }
        }
//        System.out.println("==============================");
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("==============================");
    }
}
