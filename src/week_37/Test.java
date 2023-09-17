package src.week_37;

import java.util.*;
class Solution {
    static int K;
    static ArrayList<Edge>[] adj;
    static boolean[] visited;
    static TreeSet<Integer> set = new TreeSet<>();

    public int[] solution(int n, int k, int[] capitals, int[][] edges) {
        adj = new ArrayList[n];
        visited = new boolean[n];
        K = k;
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            adj[edge[0] - 1].add(new Edge(edge[1] - 1, edge[2]));
            adj[edge[1] - 1].add(new Edge(edge[0] - 1, edge[2]));
        }

        for (int capital : capitals) {
            visited[capital - 1] = true;
            dfs(capital - 1, 0);
        }

        int[] res = new int[set.size()];
        int index = 0;
        for (int num : set) {
            res[index++] = num + 1;
        }
        return res;
    }

    private static void dfs(int x, int weight) {
        for (Edge e : adj[x]) {
            if (visited[e.to])
                continue;
            if (weight + e.weight > K)
                continue;
            visited[e.to] = true;
            set.add(e.to);
            dfs(e.to, weight + e.weight);
            visited[e.to] = false;
        }
    }

    private static class Edge {
        int to;
        int weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}