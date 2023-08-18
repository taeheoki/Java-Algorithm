package src.week_33;

import java.util.Arrays;

/**
 * 프로그래머스 - 합승 택시 요금
 */
public class Pro72413 {

    public static final int INF = 1000001;
    static int[][] dist;

    public static void main(String[] args) {
        System.out.println(solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
        System.out.println(solution(7, 3, 4, 1, new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}));
        System.out.println(solution(6, 4, 5, 6, new int[][]{{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}}));
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        dist = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], INF);
        for (int[] fare : fares) {
            dist[fare[0] - 1][fare[1] - 1] = fare[2];
            dist[fare[1] - 1][fare[0] - 1] = fare[2];
        }
        // 플로이드-워셜
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        // 정답 도출
        int res = dist[s - 1][a - 1] + dist[s - 1][b - 1];
        for (int i = 0; i < n; i++) {
            if (i == a - 1)
                res = Math.min(res, dist[s - 1][i] + dist[i][b - 1]);
            else if (i == b - 1)
                res = Math.min(res, dist[s - 1][i] + dist[i][a - 1]);
            else
                res = Math.min(res, dist[s - 1][i] + dist[i][a - 1] + dist[i][b - 1]);
        }
        return res;
    }
}
