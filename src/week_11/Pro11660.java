package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 11660 - 구간 합 구하기 5
 * 문제 이해:
 */
public class Pro11660 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int res = dp[y2][x2];
            if (y1 > 0)
                res -= dp[y1 - 1][x2];
            if (x1 > 0)
                res -= dp[y2][x1 - 1];
            if (x1 > 0 && y1 >0)
                res += dp[y1 - 1][x1 - 1];
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }

    private static void pro() {
        dp[0][0] = map[0][0];
        for (int i = 1; i < N; i++) {
            dp[0][i] += dp[0][i - 1] + map[0][i];
            dp[i][0] += dp[i - 1][0] + map[i][0];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + map[i][j];
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
