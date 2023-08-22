package src.week_34;

import java.util.ArrayList;

/**
 * 프로그래머스 - 전력망을 둘로 나누기
 */
public class Pro86971 {
    static ArrayList<Elem>[] adj;
    static boolean[] visit;

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
        System.out.println(solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
    }

    public static int solution(int n, int[][] wires) {
        int answer = 100;
        adj = new ArrayList[n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < wires.length; i++) {
            adj[wires[i][0] - 1].add(new Elem(wires[i][1] - 1, i));
            adj[wires[i][1] - 1].add(new Elem(wires[i][0] - 1, i));
        }

        visit[0] = true;
        for (int i = 0; i < wires.length; i++) {
            int m = dfs(0, i);
            answer = Math.min(answer, Math.abs(n - 2 * m));
        }
        return answer;
    }

    private static int dfs(int x, int cmp) {
        int n = 1;
        for (Elem e : adj[x]) {
            if (e.index == cmp)
                continue;
            if (visit[e.to])
                continue;
            visit[e.to] = true;
            n += dfs(e.to, cmp);
            visit[e.to] = false;
        }
        return n;
    }

    private static class Elem {
        int to;
        int index;

        public Elem(int to, int index) {
            this.to = to;
            this.index = index;
        }
    }
}
