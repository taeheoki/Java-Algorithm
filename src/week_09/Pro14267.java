package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * BOJ 14267 - 회사 문화 1
 * 문제 이해:
 * 시간 복잡도:
 */
public class Pro14267 {
    static int n, m;
    static int[] gauge, cumulative_gauge;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp != -1)
                adj[tmp - 1].add(i);
        }
        gauge = new int[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            gauge[Integer.parseInt(st.nextToken()) - 1] += Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        cumulative_gauge = new int[n];
        dfs(0);
        for (int i = 0; i < n; i++)
            System.out.print(cumulative_gauge[i] + " ");
    }

    private static void dfs(int x) {
        cumulative_gauge[x] += gauge[x];

        for (int y : adj[x]) {
            cumulative_gauge[y] += cumulative_gauge[x];
            dfs(y);
        }
    }
}
