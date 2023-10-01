package src.week_39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 1697 - 숨바꼭질
 */
public class BOJ1697 {
    static int N, K;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[100000 + 1];
        bfs();
    }

    private static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        visit[N] = true;

        int cnt = -1;
        while (!que.isEmpty()) {
            int size = que.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int cur = que.poll();
                if (cur == K) {
                    System.out.println(cnt);
                    return;
                }

                int nx = cur + 1;
                if (nx >= 0 && nx <= 100000 && !visit[nx]) {
                    visit[nx] = true;
                    que.add(nx);
                }
                nx = cur - 1;
                if (nx >= 0 && nx <= 100000 && !visit[nx]) {
                    visit[nx] = true;
                    que.add(nx);
                }
                nx = cur * 2;
                if (nx >= 0 && nx <= 100000 && !visit[nx]) {
                    visit[nx] = true;
                    que.add(nx);
                }
            }
        }
    }
}
