package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1025 - 제곱수 찾기
 */
public class Pro1025 {
    static int N, M, res = -1;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }
        pro();
        System.out.println(res);
    }

    private static void pro() {
        if (N == 1 && M == 1 && isSquare(map[0][0])) {
            res = Math.max(res, map[0][0]);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int dy = -N + 1; dy <= N - 1; dy++) {
                    for (int dx = -M + 1; dx <= M - 1; dx++) {
                        if (dy == 0 && dx == 0)
                            continue;
                        dfs(i, j, dy, dx, map[i][j]);
                    }
                }
            }
        }
    }

    private static void dfs(int i, int j, int dy, int dx, int num) {
        if (isSquare(num))
            res = Math.max(res, num);

        int ni = i + dy;
        int nj = j + dx;
        if (ni < 0 || nj < 0 || ni >= N || nj >= M)
            return;
        dfs(ni, nj, dy, dx, num * 10 + map[ni][nj]);
    }

    private static boolean isSquare(int num) {
        return Math.sqrt(num) == (int) Math.sqrt(num);
    }
}
