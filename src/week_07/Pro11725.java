package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * BOJ 11725 - 트리의 부모 찾기
 * 문제 이해: 루트 노드에 1이 있다고 가정하고, 각 노드의 부모 노드를 구하라.
 * 시간 복잡도: 1과 연결된 노드부터 시작하여 차례대로 내려가며 자식 노드를 구한다.
 *           N번 조회가 일어날 것이다.
 */
public class Pro11725 {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static ArrayList<Integer>[] adj;
    static Map<Integer, Integer> map = new TreeMap<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            adj[to].add(from);
        }
        pro();
    }

    private static void pro() {
        visit = new boolean[N + 1];
        dfs(1);
        for (int i = 2; i <= N; i++)
            sb.append(map.get(i)).append("\n");
        System.out.println(sb);
    }

    private static void dfs(int x) {
        visit[x] = true;

        for (int y : adj[x]) {
            if (visit[y])
                continue;
            map.put(y, x);
            dfs(y);
        }
    }
}
