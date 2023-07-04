package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 2056 - 작업
 * 문제 이해: 수행해야 할 작업 N개와 각각의 작업마다 걸리는 시간이 주어진다.
 *          몇몇 작업들 사이에는 선행 관계가 있어서, 어떤 작업을 수행하기 위해
 *          반드시 먼저 완료되어야 할 작업들이 있다.
 *          모든 작업을 완료하기 위해 필요한 최소 시간을 구하여라.
 *          선행 관계가 없는 작업들은 동시에 수행 가능하다.
 *
 */
public class Pro2056 {
    static int N;
    static int[] indeg, time, time_done;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        indeg = new int[N + 1];
        time = new int[N + 1];
        time_done = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int pre_cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < pre_cnt; j++) {
                int from = Integer.parseInt(st.nextToken());
                adj[from].add(i);
                indeg[i]++;
            }
        }
        pro();
        System.out.println(Arrays.stream(time_done).max().getAsInt());
    }

    private static void pro() {
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
                time_done[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y : adj[x]) {
                indeg[y]--;
                time_done[y] = Math.max(time_done[x] + time[y], time_done[y]);
                if (indeg[y] == 0)
                    queue.add(y);
            }
        }
    }
}
