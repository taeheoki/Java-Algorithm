package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 20040 - 사이클 게임
 */
public class Pro20040 {
    static int n, m;
    static private int[] parent;
    static private ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (find(a) == find(b)) {
                System.out.println(i + 1);
                System.exit(0);
            }
            union(a, b);
        }
        System.out.println(0);
    }

    private static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (parA >= parB) {
            parent[parA] = parB;
        } else {
            parent[parB] = parA;
        }
    }
}
