package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 5567 - 결혼식
 * 문제 이해: 결혼식에 초대할 동기들을 모두 초대하기 위해 최소로 초대할 인원
 *          1 -> 2 친구일 경우 1만 초대해도 2는 알아서 따라 온다.
 *          친구의 친구까지만 초대한다.
 * 시간 복잡도: N명의 친구가 N명의 친구 관계를 맺고 있을 경우 N * N의 시간 복잡도를 가질 것이다.
 *           O(N^2)
 */
public class Pro5567 {

    static int n, m, cnt;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            adj[to].add(from);
        }
        pro();
    }

    private static void pro() {
        visit = new boolean[n + 1];
        bfs(1);
        System.out.println(cnt);
    }

    private static void bfs(int origin) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(origin);
        visit[origin] = true;
        int limit = 2; // 초대 인원의 친구의 친구까지 제한

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int cur = queue.poll();

                for (int next : adj[cur]) {
                    if (visit[next])
                        continue;
                    queue.offer(next);
                    visit[next] = true;
                    cnt++;
                }
            }
            limit--;
            if (limit == 0)
                break;
        }
    }
}
