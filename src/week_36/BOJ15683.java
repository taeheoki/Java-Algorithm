package src.week_36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 15683 - 감시
 */
public class BOJ15683 {
    static int N, M, res = Integer.MAX_VALUE;
    static int[] cctvDir;
    static int[][] board, dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static ArrayList<Cctv> cctvs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] >= 1 && board[i][j] <= 5)
                    cctvs.add(new Cctv(i, j, board[i][j]));
            }
        }
        cctvDir = new int[cctvs.size()];
        rec_func(0);
        System.out.println(res);
    }

    private static void rec_func(int depth) {
        if (depth == cctvs.size()) {
            int[][] copy = copyBoard();

            for (int i = 0; i < cctvs.size(); i++) {
                Cctv cctv = cctvs.get(i);
                if (cctv.type == 1) {
                    cctv1(cctv, i, copy);
                } else if (cctv.type == 2) {
                    cctv2(cctv, i, copy);
                } else if (cctv.type == 3) {
                    cctv3(cctv, i, copy);
                } else if (cctv.type == 4) {
                    cctv4(cctv, i, copy);
                } else {
                    cctv5(cctv, i, copy);
                }
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copy[i][j] == 0)
                        cnt++;
                }
            }
            res = Math.min(res, cnt);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if ((cctvs.get(depth).type == 2 && i == 2) || (cctvs.get(depth).type == 5 && i == 1))
                break;
            cctvDir[depth] = i;
            rec_func(depth + 1);
        }
    }

    private static void cctv5(Cctv cctv, int i, int[][] copy) {
        int time = 1;
        int ny = 0, nx = 0;
        while (true) {
            ny = cctv.y + dirs[cctvDir[i]][0] * time;
            nx = cctv.x + dirs[cctvDir[i]][1] * time;
            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                break;
            if (copy[ny][nx] == 6)
                break;
            if (copy[ny][nx] == 0)
                copy[ny][nx] = -1;
            time++;
        }
        time = 1;
        while (true) {
            ny = cctv.y + dirs[(cctvDir[i] + 1) % 4][0] * time;
            nx = cctv.x + dirs[(cctvDir[i] + 1) % 4][1] * time;
            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                break;
            if (copy[ny][nx] == 6)
                break;
            if (copy[ny][nx] == 0)
                copy[ny][nx] = -1;
            time++;
        }
        time = 1;
        while (true) {
            ny = cctv.y - dirs[cctvDir[i]][0] * time;
            nx = cctv.x - dirs[cctvDir[i]][1] * time;
            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                break;
            if (copy[ny][nx] == 6)
                break;
            if (copy[ny][nx] == 0)
                copy[ny][nx] = -1;
            time++;
        }
        time = 1;
        while (true) {
            ny = cctv.y - dirs[(cctvDir[i] + 1) % 4][0] * time;
            nx = cctv.x - dirs[(cctvDir[i] + 1) % 4][1] * time;
            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                break;
            if (copy[ny][nx] == 6)
                break;
            if (copy[ny][nx] == 0)
                copy[ny][nx] = -1;
            time++;
        }
    }

    private static void cctv4(Cctv cctv, int i, int[][] copy) {
        int time = 1;
        int ny = 0, nx = 0;
        while (true) {
            ny = cctv.y + dirs[cctvDir[i]][0] * time;
            nx = cctv.x + dirs[cctvDir[i]][1] * time;
            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                break;
            if (copy[ny][nx] == 6)
                break;
            if (copy[ny][nx] == 0)
                copy[ny][nx] = -1;
            time++;
        }
        time = 1;
        while (true) {
            ny = cctv.y + dirs[(cctvDir[i] + 1) % 4][0] * time;
            nx = cctv.x + dirs[(cctvDir[i] + 1) % 4][1] * time;
            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                break;
            if (copy[ny][nx] == 6)
                break;
            if (copy[ny][nx] == 0)
                copy[ny][nx] = -1;
            time++;
        }
        time = 1;
        while (true) {
            ny = cctv.y - dirs[cctvDir[i]][0] * time;
            nx = cctv.x - dirs[cctvDir[i]][1] * time;
            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                break;
            if (copy[ny][nx] == 6)
                break;
            if (copy[ny][nx] == 0)
                copy[ny][nx] = -1;
            time++;
        }
    }

    private static void cctv3(Cctv cctv, int i, int[][] copy) {
        int time = 1;
        int ny = 0, nx = 0;
        while (true) {
            ny = cctv.y + dirs[cctvDir[i]][0] * time;
            nx = cctv.x + dirs[cctvDir[i]][1] * time;
            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                break;
            if (copy[ny][nx] == 6)
                break;
            if (copy[ny][nx] == 0)
                copy[ny][nx] = -1;
            time++;
        }
        time = 1;
        while (true) {
            ny = cctv.y + dirs[(cctvDir[i] + 1) % 4][0] * time;
            nx = cctv.x + dirs[(cctvDir[i] + 1) % 4][1] * time;
            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                break;
            if (copy[ny][nx] == 6)
                break;
            if (copy[ny][nx] == 0)
                copy[ny][nx] = -1;
            time++;
        }
    }

    private static void cctv2(Cctv cctv, int i, int[][] copy) {
        int time = 1;
        int ny = 0, nx = 0;
        while (true) {
            ny = cctv.y + dirs[cctvDir[i]][0] * time;
            nx = cctv.x + dirs[cctvDir[i]][1] * time;
            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                break;
            if (copy[ny][nx] == 6)
                break;
            if (copy[ny][nx] == 0)
                copy[ny][nx] = -1;
            time++;
        }
        time = 1;
        while (true) {
            ny = cctv.y - dirs[cctvDir[i]][0] * time;
            nx = cctv.x - dirs[cctvDir[i]][1] * time;
            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                break;
            if (copy[ny][nx] == 6)
                break;
            if (copy[ny][nx] == 0)
                copy[ny][nx] = -1;
            time++;
        }
    }

    private static void cctv1(Cctv cctv, int i, int[][] copy) {
        int time = 1;
        int ny = 0, nx = 0;
        while (true) {
            ny = cctv.y + dirs[cctvDir[i]][0] * time;
            nx = cctv.x + dirs[cctvDir[i]][1] * time;
            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                break;
            if (copy[ny][nx] == 6)
                break;
            if (copy[ny][nx] == 0)
                copy[ny][nx] = -1;
            time++;
        }
    }

    private static int[][] copyBoard() {
        int[][] copyBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }
        return copyBoard;
    }

    private static class Cctv {
        int y;
        int x;
        int type;

        public Cctv(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }
}
