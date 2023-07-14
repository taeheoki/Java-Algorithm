package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 16926 - 배열 돌리기 1
 */
public class Pro16926 {
    static int N, M, R;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void pro() {
        int section = Math.min(N, M) / 2;

        for (int r = 0; r < section; r++) {
            int row_len = (N - 2 * r) - 1;
            int col_len = (M - 2 * r) - 1;
            int distance = 2 * (row_len + col_len);
            int rotation = R % distance;

            int[] temp = new int[distance];
            int idx = 0;

            for (int j = r; j < M - r; j++) {
                temp[idx++] = map[r][j];
            }
            for (int i = r + 1; i < N - r; i++) {
                temp[idx++] = map[i][M - r - 1];
            }
            for (int j = M - r - 2; j >= r; j--) {
                temp[idx++] = map[N - r - 1][j];
            }
            for (int i = N - r - 2; i > r; i--) {
                temp[idx++] = map[i][r];
            }

            idx = -rotation;
            if (idx < 0) idx += distance;

            for (int j = r; j < M - r; j++) {
                map[r][j] = temp[idx];
                idx = (idx + 1) % distance;
            }
            for (int i = r + 1; i < N - r; i++) {
                map[i][M - r - 1] = temp[idx];
                idx = (idx + 1) % distance;
            }
            for (int j = M - r - 2; j >= r; j--) {
                map[N - r - 1][j] = temp[idx];
                idx = (idx + 1) % distance;
            }
            for (int i = N - r - 2; i > r; i--) {
                map[i][r] = temp[idx];
                idx = (idx + 1) % distance;
            }
        }
    }


}
