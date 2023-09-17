package src.week_37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 20061 - 모노미노도미노 2
 */
public class BOJ20061 {
    static int N, res;
    static boolean[][] board = new boolean[10][10];
    static int[][] board2 = new int[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if (t == 1) {
                board2[y][x] = 1;
                // blue
                int i = 6;
                for (; i < 10; i++) {
                    if (board2[y][i] == 1)
                        break;
                }
                board2[y][i - 1] = 1;
                // red
                i = 6;
                for (; i < 10; i++) {
                    if (board2[i][x] == 1)
                        break;
                }
                board2[i - 1][x] = 1;
                board2[y][x] = 0;
            } else if (t == 2) {
                board2[y][x] = 1;
                board2[y][x + 1] = 1;
                // blue
                int i = 6;
                for (; i < 10; i++) {
                    if (board2[y][i] == 1)
                        break;
                }
                board2[y][i - 1] = 1;
                board2[y][i - 2] = 1;
                // red
                i = 6;
                for (; i < 10; i++) {
                    if (board2[i][x] == 1 || board2[i][x + 1] == 1)
                        break;
                }
                board2[i - 1][x] = 1;
                board2[i - 1][x + 1] = 1;
                board2[y][x] = 0;
                board2[y][x + 1] = 0;
            } else {
                board2[y][x] = 1;
                board2[y + 1][x] = 1;
                // blue
                int i = 6;
                for (; i < 10; i++) {
                    if (board2[y][i] == 1 || board2[y + 1][i] == 1)
                        break;
                }
                board2[y][i - 1] = 1;
                board2[y + 1][i - 1] = 1;
                // red
                i = 6;
                for (; i < 10; i++) {
                    if (board2[i][x] == 1)
                        break;
                }
                board2[i - 1][x] = 1;
                board2[i - 2][x] = 1;
                board2[y][x] = 0;
                board2[y + 1][x] = 0;
            }

            // 점수 매기기
            for (int i = 6; i < 10; i++) {
                if (board2[0][i] == 1 && board2[1][i] == 1 && board2[2][i] == 1 && board2[3][i] == 1) {
                    res++;
                    for (int j = i; j >= 4; j--) {
                        board2[0][j] = board2[0][j - 1];
                        board2[1][j] = board2[1][j - 1];
                        board2[2][j] = board2[2][j - 1];
                        board2[3][j] = board2[3][j - 1];
                    }
                }
            }
            for (int i = 6; i < 10; i++) {
                if (board2[i][0] == 1 && board2[i][1] == 1 && board2[i][2] == 1 && board2[i][3] == 1) {
                    res++;
                    for (int j = i; j >= 4; j--) {
                        board2[j][0] = board2[j - 1][0];
                        board2[j][1] = board2[j - 1][1];
                        board2[j][2] = board2[j - 1][2];
                        board2[j][3] = board2[j - 1][3];
                    }
                }
            }
            // 연한칸 이동
            if (board2[0][4] == 1 || board2[1][4] == 1 || board2[2][4] == 1 || board2[3][4] == 1) {
                for (int i = 9; i >= 6; i--) {
                    board2[0][i] = board2[0][i - 2];
                    board2[1][i] = board2[1][i - 2];
                    board2[2][i] = board2[2][i - 2];
                    board2[3][i] = board2[3][i - 2];
                }
            } else if (board2[0][5] == 1 || board2[1][5] == 1 || board2[2][5] == 1 || board2[3][5] == 1) {
                for (int i = 9; i >= 6; i--) {
                    board2[0][i] = board2[0][i - 1];
                    board2[1][i] = board2[1][i - 1];
                    board2[2][i] = board2[2][i - 1];
                    board2[3][i] = board2[3][i - 1];
                }
            }
            if (board2[4][0] == 1 || board2[4][1] == 1 || board2[4][2] == 1 || board2[4][3] == 1) {
                for (int i = 9; i >= 6; i--) {
                    board2[i][0] = board2[i - 2][0];
                    board2[i][1] = board2[i - 2][1];
                    board2[i][2] = board2[i - 2][2];
                    board2[i][3] = board2[i - 2][3];
                }
            } else if (board2[5][0] == 1 || board2[5][1] == 1 || board2[5][2] == 1 || board2[5][3] == 1) {
                for (int i = 9; i >= 6; i--) {
                    board2[i][0] = board2[i - 1][0];
                    board2[i][1] = board2[i - 1][1];
                    board2[i][2] = board2[i - 1][2];
                    board2[i][3] = board2[i - 1][3];
                }
            }
            for (int j = 4; j <= 5; j++) {
                for (int i = 0; i < 4; i++) {
                    board2[i][j] = 0;
                    board2[j][i] = 0;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 6; j < 10; j++)
                if (board2[i][j] == 1)
                    cnt++;
        }
        for (int i = 6; i < 10; i++) {
            for (int j = 0; j < 4; j++)
                if (board2[i][j] == 1)
                    cnt++;
        }
        System.out.println(res);
        System.out.println(cnt);
    }
}
