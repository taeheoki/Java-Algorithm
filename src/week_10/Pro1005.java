package src.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * BOJ 1005 - ACM Craft
 * 문제 이해:
 */
public class Pro1005 {
    static StringBuilder sb = new StringBuilder();
    static int T, N, K, W;
    static int[] indeg, time, time_done;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            indeg = new int[N + 1];
            time = new int[N + 1];
            time_done = new int[N + 1];
            adj = new ArrayList[N + 1];
            for (int j = 1; j <= N; j++) {
                adj[j] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                time[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj[from].add(to);
                indeg[to]++;
            }
            pro();
            W = Integer.parseInt(br.readLine());
            sb.append(time_done[W]).append('\n');
        }
        System.out.println(sb);
    }

    private static void pro() {
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
                time_done[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0)
                    queue.add(y);
                time_done[y] = Math.max(time_done[y], time_done[x] + time[y]);
            }
        }
    }
}
