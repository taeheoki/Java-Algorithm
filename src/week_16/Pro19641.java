package src.week_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ 19641 - 중첩 집합 모델
 * 문제 이해:
 */
public class Pro19641 {
    static StringBuilder sb = new StringBuilder();
    static int N, root;
    static int[][] tree;
    static boolean[] visit;
    static ArrayList<Integer>[] adjs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adjs = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjs[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int tmp = Integer.parseInt(st.nextToken());
            do {
                adjs[v].add(tmp);
                tmp = Integer.parseInt(st.nextToken());
            } while (tmp != -1);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjs[i]);
        }
        root = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        visit = new boolean[N + 1];
        tree = new int[N + 1][2];
        dfs(root, 1);
        for (int i = 1; i <= N; i++) {
            sb.append(i).append(' ').append(tree[i][0]).append(' ').append(tree[i][1]).append('\n');
        }
        System.out.println(sb);
    }

    private static int dfs(int x, int level) {
        visit[x] = true;

        tree[x][0] = level;
        for (int adj : adjs[x]) {
            if (visit[adj])
                continue;
            level = dfs(adj, level + 1);
        }
        tree[x][1] = level + 1;
        return level + 1;
    }
}
