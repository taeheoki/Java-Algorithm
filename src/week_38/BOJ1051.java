package src.week_38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1051 - 숫자 정사각형
 */
public class BOJ1051 {
    static int N, M, res = 1;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        pro();
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                isRec(i, j);
            }
        }
        System.out.println(res);
    }

    private static void isRec(int y, int x) {
        for (int i = 1; i < Math.max(N, M); i++) {
            if (y + i >= N || x + i >= M)
                break;
            if (board[y][x + i] == board[y][x] && board[y + i][x] == board[y][x] && board[y + i][x + i] == board[y][x])
                res = Math.max(res, (i + 1) * (i + 1));
        }
    }
}
