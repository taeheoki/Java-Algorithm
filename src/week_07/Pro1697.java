package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 1697 - 숨바꼭질
 */
public class Pro1697 {
    static int N, K, ans;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new int[100001];
        bfs(N);
        System.out.println(ans - 1);
    }

    private static void bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visit[N] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == K) {
                ans = visit[cur];
                return;
            }

            int next = cur + 1;
            if (next >= 0 && next <= 100000 && visit[next] ==  0) {
                visit[next] = visit[cur] + 1;
                queue.offer(next);
            }
            next = cur - 1;
            if (next >= 0 && next <= 100000 && visit[next] == 0) {
                visit[next] = visit[cur] + 1;
                queue.offer(next);
            }
            next = cur * 2;
            if (next >= 0 && next <= 100000 && visit[next] == 0) {
                visit[next] = visit[cur] + 1;
                queue.offer(next);
            }
        }
    }
}
