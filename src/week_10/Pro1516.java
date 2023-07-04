package src.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 1516 - 게임 개발
 * 문제 이해: 어떠한 건물을 짓기 위해 먼저 지어야하는 건물이 있을 수 있고,
 *          특정 건물을 짓기까지 얼마나 시간이 필요한지 생각해보자.
 */
public class Pro1516 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] indeg, time, time_done;
    static ArrayList<Integer> tmp = new ArrayList<>();

    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        indeg = new int[N + 1];
        time = new int[N + 1];
        time_done = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int pre;
            while ((pre = Integer.parseInt(st.nextToken())) != -1) {
                if (!adj[pre].contains(i)) {
                    adj[pre].add(i);
                    indeg[i]++;
                }
            }
        }
        pro();
        for (int i = 1; i <= N; i++) {
            sb.append(time_done[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void pro() {
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
            }
            time_done[i] = time[i];
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int y : adj[x]) {
                indeg[y]--;
                time_done[y] = Math.max(time_done[y], time_done[x] + time[y]);
                if (indeg[y] == 0) {
                    queue.add(y);
                }
            }
        }
    }
}
