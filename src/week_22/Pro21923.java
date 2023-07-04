package src.week_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 21923 - 곡예 비행
 */
public class Pro21923 {
    static int N, M;
    static int[][] map;
    static long res = -10000 * 1000 * 1000L;

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
        bfs();
    }

    private static void bfs() {
        Queue<Plain> que = new LinkedList<>();
        que.add(new Plain(N - 1, 0, 0, map[N - 1][0]));

        while (!que.isEmpty()) {
            Plain cur = que.poll();
            if (cur.y == N - 1 && cur.x == M - 1) {
                res = Math.max(res, cur.sum);
            }

            int ny;
            int nx;

            if (cur.status == 0) {
                ny = cur.y;
                nx = cur.x + 1;
                if (nx < M) {
                    que.add(new Plain(ny, nx, 0, cur.sum + map[ny][nx]));
                }

                ny = cur.y - 1;
                nx = cur.x;
                if (ny >= 0) {
                    que.add(new Plain(ny, nx, 0, cur.sum + map[ny][nx]));
                }
            }
            if (cur.status == 0 || cur.status == 1) {
                if (cur.status == 0) {
                    cur.sum += map[cur.y][cur.x];
                }
                ny = cur.y;
                nx = cur.x + 1;
                if (nx < M) {
                    que.add(new Plain(ny, nx, 1, cur.sum + map[ny][nx]));
                }

                ny = cur.y + 1;
                nx = cur.x;
                if (ny >= N)
                    continue;
                que.add(new Plain(ny, nx, 1, cur.sum + map[ny][nx]));
            }
        }
        if (N == 1 && M == 1) {
            System.out.println(map[0][0] * 2);
        } else
            System.out.println(res);
    }

    private static class Plain {
        int y;
        int x;
        int status;
        int sum;

        public Plain(int y, int x, int status, int sum) {
            this.y = y;
            this.x = x;
            this.status = status;
            this.sum = sum;
        }
    }
}
