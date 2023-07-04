package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 13549 - 숨바꼭질
 * 문제 이해: 순간이동 0초 후 2 * x
 *          1초 후 x + 1 or x - 1
 *          동생이 있는 위치까지 가는데 가장 빠른 시간은 몇 초 후인가?
 * 시간 복잡도:
 */
public class Pro13549 {
    static int N, K;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pro();
    }

    private static void pro() {
        visit = new int[100000 + 1];
        int res = bfs(N);
        System.out.println(res);
    }

    private static int bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visit[start] = 1;

        while (!que.isEmpty()) {
            int cur = que.poll();
            if (cur == K)
                return visit[cur] - 1;
            int next = 2 * cur;
            if (next <= 100000 && visit[next] == 0) {
                que.offer(next);
                visit[next] = visit[cur];
            }
            next = cur + 1;
            if (next <= 100000 && visit[next] == 0) {
                que.offer(next);
                visit[next] = visit[cur] + 1;
            }
            next = cur - 1;
            if (next >= 0 && visit[next] == 0) {
                que.offer(next);
                visit[next] = visit[cur] + 1;
            }
        }
        return -1;
    }
}