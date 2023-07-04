package src.week_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 1043 - 거짓말
 */
public class Pro1043 {
    static int N, M, cnt;
    static ArrayList<Integer> true_adj = new ArrayList<>();
    static ArrayList<Integer>[] adj;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        cnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < cnt; i++) {
            true_adj.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            cnt = Integer.parseInt(st.nextToken());
            int pivot = Integer.parseInt(st.nextToken());
            arr[i] = pivot;
            for (int j = 1; j < cnt; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (adj[pivot].contains(tmp))
                    continue;
                adj[pivot].add(tmp);
                adj[tmp].add(pivot);
            }
        }
        pro();
    }

    private static void pro() {
        visit = new boolean[N + 1];
        for (int i = 0; i < true_adj.size(); i++) {
            dfs(true_adj.get(i));
        }

        int cnt = M;
        for (int i = 0; i < arr.length; i++) {
            if (visit[arr[i]])
                cnt--;
        }
        System.out.println(cnt);
    }

    private static void dfs(int x) {
        visit[x] = true;
        for (int y : adj[x]) {
            if (visit[y])
                continue;
            dfs(y);
        }
    }
}
