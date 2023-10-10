package src.week_40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 16562 - 친구비
 */
public class BOJ16562 {
    static int N, M, k, fee;
    static int[] friendFees;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        init();
        pro();
    }

    private static void pro() {
        visit = new boolean[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (visit[i])
                continue;
            fee = friendFees[i];
            dfs(i);
            sum += fee;
            if (sum > k)
                break;
        }
        System.out.println(sum > k ? "Oh no" : sum);
    }

    private static void dfs(int x) {
        fee = Math.min(fee, friendFees[x]);
        visit[x] = true;

        for (int y : adj[x]) {
            if (visit[y])
                continue;
            dfs(y);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        friendFees = new int[N];
        adj = new ArrayList[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            friendFees[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken()) - 1;
            adj[v].add(w);
            adj[w].add(v);
        }
    }
}
