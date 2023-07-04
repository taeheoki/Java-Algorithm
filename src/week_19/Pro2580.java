package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 2580 - 스도쿠
 */
public class Pro2580 {
    static final int SIZE = 9;
    static int[][] board = new int[SIZE][SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rec_func(0, 0);
    }

    private static void rec_func(int y, int x) {
        if (x == SIZE) {
            rec_func(y + 1, 0);
            return;
        }
        if (y == SIZE) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }
        if (board[y][x] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (!isPossible(y, x, i))
                    continue;
                board[y][x] = i;
                rec_func(y, x + 1);
                board[y][x] = 0;
            }
            return;
        }
        rec_func(y, x + 1);
    }

    private static boolean isPossible(int y, int x, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[y][i] == num)
                return false;
        }

        for (int i = 0; i < SIZE; i++) {
            if (board[i][x] == num)
                return false;
        }

        int set_row = (y / 3) * 3;
        int set_col = x / 3 * 3;


        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    private static void drawingMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
