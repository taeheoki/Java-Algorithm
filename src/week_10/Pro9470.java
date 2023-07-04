package src.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 9470 - Strahler 순서
 * 문제 이해:
 */
public class Pro9470 {
    static StringBuilder sb = new StringBuilder();
    static int T, K, M, P;
    static int[] indeg, strahler_order, cnt;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken()); // 테스트 케이스 번호
            M = Integer.parseInt(st.nextToken()); // 노드의 수
            P = Integer.parseInt(st.nextToken()); // 간성의 수
            indeg = new int[M + 1];
            cnt = new int[M + 1];
            strahler_order = new int[M + 1];
            adj = new ArrayList[M + 1];
            for (int j = 1; j <= M; j++) {
                adj[j] = new ArrayList<>();
            }
            for (int j = 0; j < P; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj[from].add(to);
                indeg[to]++;
            }
            pro();
            sb.append(K + " " + strahler_order[M]).append("\n");
        }
        System.out.println(sb);
    }

    private static void pro() {

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= M; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
                strahler_order[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0)
                    queue.add(y);
                if (strahler_order[y] < strahler_order[x]) {
                    strahler_order[y] = strahler_order[x];
                    cnt[y] = strahler_order[x];
                } else if (strahler_order[y] == strahler_order[x] && cnt[y] == strahler_order[x])
                    strahler_order[y]++;
            }
        }
    }
}
