package src.week_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 1956 - 운동
 */
public class Pro1956 {
    public static final int DIST = 10000 * 400 + 1;
    static int V, E;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        map = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            Arrays.fill(map[i], DIST);
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map[from][to] = weight;
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        int res = DIST;
        for (int i = 1; i <= V; i++) {
            res = Math.min(res, map[i][i]);
        }
        System.out.println(res == DIST ? -1 : res);
    }
}
