package src.week_35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 15686 - 치킨 배달
 */
public class BOJ15686 {
    static int N, M, res = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[] open;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chiken = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1)
                    house.add(new int[]{i, j});
                else if (board[i][j] == 2)
                    chiken.add(new int[]{i, j});
            }
        }
        open = new boolean[chiken.size()];
        rec_func(0, 0);
        System.out.println(res);
    }

    private static void rec_func(int depth, int start) {
        if (depth == M) {
            int sum = 0;
            for (int i = 0; i < house.size(); i++) {
                int dist = Integer.MAX_VALUE;
                int rHouse = house.get(i)[0];
                int cHouse = house.get(i)[1];
                for (int j = 0; j < chiken.size(); j++) {
                    if (!open[j])
                        continue;
                    int rChiken = chiken.get(j)[0];
                    int cChiken = chiken.get(j)[1];
                    dist = Math.min(dist, Math.abs(rHouse - rChiken) + Math.abs(cHouse - cChiken));
                }
                sum += dist;
            }
            res = Math.min(res, sum);
            return;
        }
        for (int i = start; i < chiken.size(); i++) {
            if (open[i])
                continue;
            open[i] = true;
            rec_func(depth + 1, i + 1);
            open[i] = false;
        }
    }
}
