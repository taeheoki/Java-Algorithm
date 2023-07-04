package src.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * # BOJ 20168 - 골목 대장 호석 - 기능성
 */
public class Pro20168 {
    static int N, M, A, B, C, res;
    static int[][] map;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], C + 100);
            map[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[v1][v2] = cost;
            map[v2][v1] = cost;
        }
        visit = new boolean[N + 1];
        visit[A] = true;
        rec_func(A, 0, 0);
        System.out.println(res == 0 ? -1 : res);
    }

    private static void rec_func(int x, int sum, int max) {
        if (x == B) {
            if (res == 0) {
                res = max;
            } else {
                res = Math.min(res, max);
            }
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (x == i)
                continue;
            if (visit[i])
                continue;
            if (sum + map[x][i] > C)
                continue;
            visit[i] = true;
            rec_func(i, sum + map[x][i], Math.max(max, map[x][i]));
            visit[i] = false;
        }
    }
}
