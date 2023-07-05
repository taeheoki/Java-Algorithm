package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * BOJ 15886 - 내 선물을 받아줘 2
 */
public class Pro15886 {
    static int N;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        String location = br.readLine();
        for (int i = 0; i < N; i++) {
            if (location.charAt(i) == 'E') {
                if (i == N - 1)
                    continue;
                adj[i].add(i + 1);
                adj[i + 1].add(i);
            } else {
                if (i == 0)
                    continue;
                adj[i].add(i - 1);
                adj[i - 1].add(i);
            }
        }
        pro();
    }

    private static void pro() {
        int cnt = 0;

        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (visit[i])
                continue;
            dfs(i);
            cnt++;
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
