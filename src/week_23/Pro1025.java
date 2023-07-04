package src.week_23;

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
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tmp.substring(j, j + 1));
            }
        }
        pro();
        System.out.println(res);
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int y = -N; y < N; y++) {
                    for (int x = -M; x < M; x++) {
                        if (x == 0 && y == 0)
                            continue;
                        rec_func(i, j, y, x, map[i][j]);
                    }
                }
            }
        }
    }

    private static void rec_func(int i, int j, int y, int x, int num) {
        double sqrt = Math.sqrt(num);
        if (sqrt == (int) sqrt) {
            res = Math.max(res, num);
        }
        int ni = i + y;
        int nj = j + x;
        if (ni < 0 || nj < 0 || ni >= N || nj >= M)
            return;
        rec_func(ni, nj, y, x, num * 10 + map[ni][nj]);
    }
}
