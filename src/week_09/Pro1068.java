package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 1068 - 트리
 */
public class Pro1068 {
    static int N, root, erase;
    static int[] parent, leaf;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int par = Integer.parseInt(st.nextToken());
            if (par == -1) {
                root = i;
                continue;
            }
            adj[par].add(i);
        }
        leaf = new int[N];
        erase = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            if (adj[i].contains(erase))
                adj[i].remove(adj[i].indexOf(erase));
        }

        if (root != erase)
            dfs(root);

        System.out.println(leaf[root]);
    }

    private static void dfs(int x) {
        if (adj[x].isEmpty()) {
            leaf[x] = 1;
        }
        for (int y : adj[x]) {
            dfs(y);
            leaf[x] += leaf[y];
        }
    }
}
