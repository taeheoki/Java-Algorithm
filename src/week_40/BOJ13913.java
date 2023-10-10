package src.week_40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 13913 - 숨바꼭질 4
 */
public class BOJ13913 {
    static int N, K;
    static boolean[] visit = new boolean[100000 + 1];
    static int[] from = new int[100001];

    public static void main(String[] args) throws IOException {
        init();
        bfs();
    }

    private static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        visit[N] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();
            if (cur == K) {
                printPath();
                return;
            }

            for (int next : new int[]{2 * cur, cur + 1, cur - 1}) {
                if (next >= 0 && next <= 100000 && !visit[next]) {
                    visit[next] = true;
                    from[next] = cur; // save the current position as the previous position of the next
                    que.add(next);
                }
            }
        }
    }

    private static void printPath() {
        List<Integer> path = new ArrayList<>();

        for (int i=K; i!=N; i=from[i])
            path.add(i);

        path.add(N);

        Collections.reverse(path);

        System.out.println(path.size()-1);

        for (int p : path)
            System.out.print(p + " ");

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}
