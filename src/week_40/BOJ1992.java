package src.week_40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1992 - 쿼드트리
 */
public class BOJ1992 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        init();
        rec_func(N, 0, 0);
        System.out.println(sb);
    }

    private static void rec_func(int size, int y, int x) {
        if (check(size, y, x)) {
            sb.append(board[y][x]);
            return;
        }
        sb.append('(');
        rec_func(size / 2, y, x);
        rec_func(size / 2, y, x + size / 2);
        rec_func(size / 2, y + size / 2, x);
        rec_func(size / 2, y + size / 2, x + size / 2);
        sb.append(')');
    }

    private static boolean check(int size, int y, int x) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (board[i][j] != board[y][x])
                    return false;
            }
        }
        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
    }
}
