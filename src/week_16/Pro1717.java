package src.week_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1717 - 집합의 표현
 * 문제 이해:
 */
public class Pro1717 {
    static int n, m;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmp = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (cmp == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b))
                    sb.append("YES").append('\n');
                else
                    sb.append("NO").append('\n');
            }
        }
        System.out.println(sb);
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

    private static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
}
