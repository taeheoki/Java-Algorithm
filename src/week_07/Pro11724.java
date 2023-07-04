package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 11724 - 연결 요소의 개수
 * 문제 이해: 방향 없는 그래프가 주어졌을 때, 연결 요소의 개수 구하기
 * 시간 복잡도: O(N * N)
 *           N개의 개수를 다 돌면서 선이 몇개인지 확인
 */
public class Pro11724 {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++)
            adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            adj[from].add(to);
            adj[to].add(from);
        }
        pro();
    }

    private static void pro() {
        visit = new boolean[N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                dfs(i);
                cnt++;
            }
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
