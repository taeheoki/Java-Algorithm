package src.week_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 1956 - 운동
 */
public class Pro1956 {
    public static final int DIST = 10000 * 400 + 1;
    static int V, E;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        board = new int[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(board[i], DIST);
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            board[a][b] = c;
        }
        pro();
    }

    private static void pro() {
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
                }
            }
        }

        int res = DIST;
        for (int i = 0; i < V; i++) {
            res = Math.min(res, board[i][i]);
        }
        System.out.println(res == DIST ? -1 : res);
    }

    private static class Edge {
        int to;
        int road;

        public Edge(int to, int road) {
            this.to = to;
            this.road = road;
        }
    }
}
