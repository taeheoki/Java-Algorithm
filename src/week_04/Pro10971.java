package src.week_04;

import java.io.*;
import java.util.*;

/**
 * 백준 10971번 외판원 순회 2
 */
public class Pro10971 {
    static int N, y, x, min = Integer.MAX_VALUE, city;
    static int[][] board;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i ++) {
            city = i;
            rec_func(0, i, 0);
        }
        System.out.println(min);
    }

    private static void rec_func(int depth, int start, int sum) {
        if (depth == N) {
            min = Math.min(min, sum);
        } else {
            for (int i = 0; i < N; i++) {
                if (!visited[i] && start != i && board[start][i] != 0 && city != i) {
                    visited[i] = true;
                    rec_func(depth + 1, i, sum + board[start][i]);
                    visited[i] = false;
                } else if (!visited[i] && city == i && depth == N - 1 && board[start][i] != 0 && start != i) {
                    rec_func(depth + 1, i, sum + board[start][i]);
                }
            }
        }
    }


}
