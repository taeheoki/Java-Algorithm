package src.week_40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 1197 - 최소 스패닝 트리
 */
public class BOJ1197 {
    static int V, E;
    static int[] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

    public static void main(String[] args) throws IOException {
        init();
        pro();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Edge(from, to, weight));
        }
        parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
    }

    private static void pro() {
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (find(e.from) == find(e.to))
                continue;
            union(e.from, e.to);
            sum += e.weight;
        }
        System.out.println(sum);
    }

    private static void union(int from, int to) {
        int parentA = find(from);
        int parentB = find(to);
        if (parentA < parentB)
            parent[parentB] = parentA;
        else
            parent[parentA] = parentB;
    }

    private static int find(int num) {
        if (parent[num] == num)
            return num;
        return parent[num] = find(parent[num]);
    }

    private static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
