package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2115 - 갤러리
 */
public class Pro2115 {
    static int M, N, res;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[M][N];
        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }
        pro();
        System.out.println(res);
    }

    private static void pro() {
        // 윗벽, 아랫벽
        for (int i = 1; i < M - 1; i++) {
            int leftCnt = 0;
            int rightCnt = 0;
            for (int j = 1; j < N - 1; j++) {
                if (map[i - 1][j] == 'X' && map[i][j] == '.') {
                    leftCnt++;
                } else {
                    res += leftCnt / 2;
                    leftCnt = 0;
                }
                if (map[i + 1][j] == 'X' && map[i][j] == '.') {
                    rightCnt++;
                } else {
                    res += rightCnt / 2;
                    rightCnt = 0;
                }
            }
            res += leftCnt / 2 + rightCnt / 2;
        }

        // 윗벽, 아래쪽벽
        for (int i = 1; i < N - 1; i++) {
            int upCnt = 0;
            int downCnt = 0;
            for (int j = 1; j < M - 1; j++) {
                if (map[j][i - 1] == 'X' && map[j][i] == '.') {
                    upCnt++;
                } else {
                    res += upCnt / 2;
                    upCnt = 0;
                }
                if (map[j][i + 1] == 'X' && map[j][i] == '.') {
                    downCnt++;
                } else {
                    res += downCnt / 2;
                    downCnt = 0;
                }
            }
            res += upCnt / 2 + downCnt / 2;
        }
    }
}
