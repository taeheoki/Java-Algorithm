package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 7511 - 소셜 네트워킹 어플리케이션
 */
public class Pro7511 {
    static StringBuilder sb = new StringBuilder();
    static int T, n, k, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            sb.append("Scenario " + i + ":").append("\n");
            n = Integer.parseInt(br.readLine());
            parent = new int[n];
            for (int j = 0; j < n; j++) {
                parent[j] = j;
            }
            k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                if (find(u) == find(v))
                    sb.append(1).append('\n');
                else
                    sb.append(0).append('\n');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (parA >= parB) {
            parent[parA] = parB;
        } else {
            parent[parB] = parA;
        }
    }
}
