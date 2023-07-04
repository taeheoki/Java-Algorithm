package src.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1269번 DFS와 BFS
 */
public class Pro1260 {
    // 인접 리스트 풀이
    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 양방향 간선을 의미한다.
            adj[x].add(y);
            adj[y].add(x);
        }
        // 정렬을 통해 차례대로 조회하는 것을 보장한다.
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }
        pro();
    }
    private static void pro() {
        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        for (int i = 1; i <= N; i++)
            visited[i] = false;
        bfs(V);

        System.out.println(sb);
    }


    private static void dfs(int x) {
        visited[x] = true;
        sb.append(x).append(" ");
        for (int y : adj[x]) {
            if (visited[y])
                continue;
            dfs(y);
        }
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();

        // start는 방문 가능한 점이므로 stack에 넣어준다.
        queue.add(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            x = queue.poll();
            sb.append(x).append(" ");

            for (int y : adj[x]) {
                if (visited[y])
                    continue;
                queue.add(y);
                visited[y] = true;
            }
        }
    }
}
