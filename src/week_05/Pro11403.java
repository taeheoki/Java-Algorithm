package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 11403 - 경로 찾기
 * 문제 이해: 그래프가 주어졌을 때, i -> j가 가능한지 확인해보자.
 * 시간 복잡도:
 */
public class Pro11403 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] map;
    static boolean flag;
    static boolean[] visit;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    adj[i].add(j);
                }
            }
        }
        pro();
    }

    private static void pro() {
        map = new int[N][N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++)
                    visit[k] = false;
                dfs(i, j, 0);
                if (flag)
                    map[i][j] = 1;
                flag = false;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int from, int to, int depth) {
        if (depth != 0)
            visit[from] = true;

        for (int n : adj[from]) {
            if (visit[n])
                continue;
            if (n == to || flag) {
                flag = true;
                return;
            }
            dfs(n, to, depth + 1);
        }
    }
}
