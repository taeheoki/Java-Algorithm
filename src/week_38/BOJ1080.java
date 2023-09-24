package src.week_38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1080 - 행렬
 */
public class BOJ1080 {
    static int N, M;
    static int[][] src, dest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        src = new int[N][M];
        dest = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                src[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                dest[i][j] = str.charAt(j) - '0';
            }
        }

        int cnt = 0;
        int i = 0;
        if (N >= 3 && M >= 3) {
            for (; i < N - 2; i++) {
                int j = 0;
                for (; j < M - 2; j++) {
                    if (src[i][j] != dest[i][j]) {
                        cnt++;
                        for (int a = 0; a < 3; a++) {
                            for (int b = 0; b < 3; b++) {
                                src[i + a][j + b] = src[i + a][j + b] == 1 ? 0 : 1;
                            }
                        }
                    }
                }
                if (src[i][j] != dest[i][j] || src[i][j + 1] != dest[i][j + 1]) {
                    cnt = -1;
                    break;
                }
            }
        }

        for (; i < N; i++) {
            boolean flag = false;
            for (int j = 0; j < M; j++) {
                if (src[i][j] != dest[i][j]) {
                    flag = true;
                    cnt = -1;
                    break;
                }
            }
            if (flag)
                break;
        }


        System.out.println(cnt);
    }
}
