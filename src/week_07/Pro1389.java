package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 1389 - 케빈 베이컨의 6단계 법칙
 * 문제 이해: 이강호와 민세희는 몇 단계만에 이어질 수 있을까?
 *          이강호 - 천민호 - 최백준 - 김선영 - 김도현 - 민세희
 *          1 - 3, 4
 *          2 - 3
 *          3 - 1, 2, 4
 *          4 - 1, 3, 5
 *          5 - 4
 *          1, 2, 3, 4, 5가 각각 케이 베이컨 게임을 따를 때 각 사람별로 걸리는 단계의 수의 합이 가장 작은 사람을 출력하라.
 *          만일 여러명 나올 경우 가장 번호가 빠른 사람을 출력
 * 시간 복잡도: O(N * N), N명의 사람을 N번 조회
 */
public class Pro1389 {
    static int N, M, sum = Integer.MAX_VALUE, ans;
    static ArrayList<Integer>[] adj;
    static int[] visit;

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
        visit = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                visit[j] = -1;
            int tmp_sum = 0;
            bfs(i);
            for (int j = 0; j < N; j++) {
                tmp_sum += visit[j];
            }
            if (tmp_sum < sum) {
                sum = tmp_sum;
                ans = i + 1;
            }
        }
        System.out.println(ans);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visit[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : adj[cur]) {
                if (visit[next] >= 0)
                    continue;
                queue.offer(next);
                visit[next] = visit[cur] + 1;
            }
        }
    }
}
