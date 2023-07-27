package src.week_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 21922 - 학부 연구생 민상
 */
public class Pro21922 {
    static int N, M;
    static int[][] board, dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static boolean[][] visit;
    static Queue<Elem> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    visit[i][j] = true;
                    que.add(new Elem(i, j, 0));
                    que.add(new Elem(i, j, 1));
                    que.add(new Elem(i, j, 2));
                    que.add(new Elem(i, j, 3));
                }
            }
        }
        pro();
    }

    private static void pro() {
        bfs();

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j])
                    res++;
            }
        }
        System.out.println(res);
    }

    private static void bfs() {
        while (!que.isEmpty()) {
            Elem e = que.poll();

            int ny = e.y + dirs[e.dir][0];
            int nx = e.x + dirs[e.dir][1];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M || board[ny][nx] == 9)
                continue;
            visit[ny][nx] = true;
            if (board[ny][nx] == 1 && (e.dir == 2 || e.dir == 3))
                continue;
            else if (board[ny][nx] == 2 && (e.dir == 0 || e.dir == 1))
                continue;
            else if (board[ny][nx] == 3) {
                if (e.dir == 0)
                    e.dir = 3;
                else if (e.dir == 1)
                    e.dir = 2;
                else if (e.dir == 2)
                    e.dir = 1;
                else if (e.dir == 3)
                    e.dir = 0;
            } else if (board[ny][nx] == 4) {
                if (e.dir == 0)
                    e.dir = 2;
                else if (e.dir == 1)
                    e.dir = 3;
                else if (e.dir == 2)
                    e.dir = 0;
                else if (e.dir == 3)
                    e.dir = 1;
            }
            que.add(new Elem(ny, nx, e.dir));
        }
    }

    private static class Elem {
        int y;
        int x;
        int dir;

        public Elem(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
}
