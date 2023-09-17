package src.week_37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, res;
    static int[][] greenBoard = new int[10][10];  // 초록색 보드
    static int[][] blueBoard = new int[10][10];   // 파란색 보드

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            placeBlock(t, y, x);
            score();
            moveUpper();
            moveRight();
        }

        int cnt = count();
        System.out.println(res);
        System.out.println(cnt);
    }

    // 블록을 놓는 메서드
    static void placeBlock(int t, int y, int x) {
        if (t == 1) {
            greenBoard[y][x] = 1;
            blueBoard[x][y] = 1;
        } else if (t == 2) {
            greenBoard[y][x] = 2;
            greenBoard[y][x + 1] = 2;
            blueBoard[x][y] = 2;
            blueBoard[x + 1][y] = 2;
        } else {
            greenBoard[y][x] = 3;
            greenBoard[y + 1][x] = 3;
            blueBoard[x][y] = 3;
            blueBoard[x][y + 1] = 3;
        }
    }

    // 점수를 계산하는 메서드
    static void score() {
        // 초록색 보드에서 점수 계산
        for (int i = 6; i < 10; i++) {
            boolean fullRow = true;
            for (int j = 0; j < 4; j++) {
                if (greenBoard[i][j] == 0) {
                    fullRow = false;
                    break;
                }
            }
            if (fullRow) {
                res++;
                for (int j = 0; j < 4; j++) {
                    greenBoard[i][j] = 0;
                }
            }
        }

        // 파란색 보드에서 점수 계산
        for (int j = 6; j < 10; j++) {
            boolean fullCol = true;
            for (int i = 0; i < 4; i++) {
                if (blueBoard[j][i] == 0) {
                    fullCol = false;
                    break;
                }
            }
            if (fullCol) {
                res++;
                for (int i = 0; i < 4; i++) {
                    blueBoard[j][i] = 0;
                }
            }
        }
    }

    // 초록색 보드에서 블록을 아래로 이동하는 메서드
    static void moveUpper() {
        for (int j = 6; j < 10; j++) {
            boolean fullCol = true;
            for (int i = 0; i < 4; i++) {
                if (greenBoard[i][j] == 0) {
                    fullCol = false;
                    break;
                }
            }
            if (fullCol) {
                for (int i = 9; i >= 4; i--) {
                    for (int k = 0; k < 4; k++) {
                        greenBoard[i][j] = greenBoard[i - 4][j];
                    }
                }
            }
        }
    }

    // 파란색 보드에서 블록을 오른쪽으로 이동하는 메서드
    static void moveRight() {
        for (int i = 6; i < 10; i++) {
            boolean fullRow = true;
            for (int j = 0; j < 4; j++) {
                if (blueBoard[i][j] == 0) {
                    fullRow = false;
                    break;
                }
            }
            if (fullRow) {
                for (int j = 9; j >= 4; j--) {
                    for (int k = 0; k < 4; k++) {
                        blueBoard[i][j] = blueBoard[i][j - 4];
                    }
                }
            }
        }
    }

    // 현재 보드에서 블록의 수를 세는 메서드
    static int count() {
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (greenBoard[i][j] != 0 || blueBoard[j][i] != 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
