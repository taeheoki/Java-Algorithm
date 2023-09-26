package src.week_39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1286 - 부분 직사각형
 */
public class BOJ1286 {
    static int N, M;
    static long[] alphabet = new long[26];
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        pro();

        for (long i : alphabet) {
            System.out.println(i);
        }
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            int row = (i + 1) * (2 * N - i) + (i + N + 1) * (N - i);
            for (int j = 0; j < M; j++) {
                int col = (j + 1) * (2 * M - j) + (j + M + 1) * (M - j);
                alphabet[board[i][j] - 'A'] += row * col;
            }
        }
    }
}
