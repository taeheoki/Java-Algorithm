package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 1068 - 트리
 */
public class Pro1068 {
    static int N, rm, root;
    static ArrayList<Integer>[] adjs;
    static int[] leaf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adjs = new ArrayList[N ];
        leaf = new int[N];
        for (int i = 0; i < N; i++) {
            adjs[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                adjs[parent].add(i);
            }
        }
        rm = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            if (adjs[i].contains((Object) rm))
                adjs[i].remove((Object) rm);
        }
        if (rm == root)
            System.out.println(0);
        else {
            dfs(root);
            System.out.println(leaf[root]);
        }
    }

    private static void dfs(int x) {
        if (adjs[x].isEmpty())
            leaf[x] = 1;
        for (Integer adj : adjs[x]) {
            dfs(adj);
            leaf[x] += leaf[adj];
        }
    }

}
