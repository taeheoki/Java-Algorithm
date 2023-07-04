package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1080 - 행렬
 * 문제 이해:
 */
public class Pro1080 {
    static int N, M;
    static char[][] src_data, dest_data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        src_data = new char[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                src_data[i][j] = tmp.charAt(j);
            }
        }
        dest_data = new char[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                dest_data[i][j] = tmp.charAt(j);
            }
        }
        pro();
    }

    private static void pro() {
        int cnt = 0;

        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (src_data[i][j] != dest_data[i][j]) {
                    reverse(i, j);
                    cnt++;
                }
            }
        }

        if (!isSame())
            cnt = -1;
        System.out.println(cnt);
    }

    private static boolean isSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (src_data[i][j] != dest_data[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void reverse(int i, int j) {
        for (int y = i; y < i + 3; y++) {
            for (int x = j; x < j + 3; x++) {
                src_data[y][x] = src_data[y][x] == '0' ? '1' : '0';
            }
        }
    }
}
