package src.week_32;

import java.util.ArrayList;

/**
 * 프로그래머스 - 양과 늑대
 */
public class Pro92343 {
    static int res = 1;
    static int[] g_info, dp;
    static int[][] g_edges;
    static ArrayList<Edge>[] edgeList;
    static boolean[] visit;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1}, new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}));
        System.out.println(solution(new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0}, new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}}));
    }

    public static int solution(int[] info, int[][] edges) {
        g_info = info;
        g_edges = edges;
        edgeList = new ArrayList[g_info.length];
        visit = new boolean[info.length];
        dp = new int[info.length];
        for (int i = 0; i < g_info.length; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int type = g_info[to];
            edgeList[from].add(new Edge(to, type));
            edgeList[to].add(new Edge(from, type));
        }
        dfs(0, 1, 1);
        return res;
    }

    private static void dfs(int x, int n, int cnt) {
        res = Math.max(res, cnt);
        if (dp[x] == res)
            return;
        dp[x] = res;
        visit[x] = true;
        for (Edge e : edgeList[x]) {
            if (!visit[e.to]) {
                if (e.type == 0)
                    dfs(e.to, n + 1, cnt + 1);
                else if (e.type == 1 && n > 1)
                    dfs(e.to, n - 1, cnt);
            } else {
                dfs(e.to, n, cnt);
            }
        }
        visit[x] = false;
    }

    private static class Edge {
        int to;
        int type;

        public Edge(int to, int type) {
            this.to = to;
            this.type = type;
        }
    }
}
