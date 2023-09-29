package src.week_39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 1347 - 미로 만들기
 */
public class BOJ1347 {
    static int N;
    static int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}}; // 남서북동 R +1, L -1
    static char[][] board = new char[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for (int i = 0; i < 100; i++) {
            Arrays.fill(board[i], '#');
        }
        int y = 50;
        int x = 50;

        // 처음 위치에 '.' 찍기
        board[y][x] = '.';

        int dir = 0;
        int minY = 50, minX = 50, maxY = 50, maxX = 50;
        for (int i = 0; i < N; i++) {
            char ch = str.charAt(i);
            if (ch == 'R') {
                dir = dir + 1 == 4 ? 0 : dir + 1;
            } else if (ch == 'L') {
                dir = dir - 1 < 0 ? 3 : dir - 1;
            } else {
                y = y + dirs[dir][0];
                x = x + dirs[dir][1];
                board[y][x] = '.';
                minY = Math.min(minY, y);
                minX = Math.min(minX, x);
                maxY = Math.max(maxY, y);
                maxX = Math.max(maxX, x);
            }
        }

        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
