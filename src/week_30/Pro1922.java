package src.week_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 1922 - 네트워크 연결
 */
public class Pro1922 {
    static int N, M;
    static int[] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    static ArrayList<Edge>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(v1, v2, cost));
        }
        pro();
    }

    private static void pro() {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (find(e.v1) != find(e.v2)) {
                union(e.v1, e.v2);
                sum += e.cost;
            }
        }
        System.out.println(sum);
    }

    public static int find(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (parA < parB)
            parent[parA] = parB;
        else
            parent[parB] = parA;
    }

    private static class Edge {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }
}
