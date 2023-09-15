package src.week_37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 16967 - 배열 복원하기
 */
public class BOJ16967 {
    static int H, W, X, Y;
    static int[][] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        A = new int[H][W];
        B = new int[H + X][W + Y];
        for (int i = 0; i < H + X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W + Y; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
    }

    private static void pro() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (i < X)
                    A[i][j] = B[i][j];
                else if (j < Y)
                    A[i][j] = B[i][j];
                else
                    A[i][j] = B[i][j] - A[i - X][j - Y];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(A[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
