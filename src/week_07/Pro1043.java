package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 1043 - 거짓말
 * 문제 이해: 파티에서 과장되게 말하고 싶은데 진실을 알고 있는 사람이 있을 겨우
 *          진실을 말할 수 밖에 없고, 거짓말을 했다해도 이후 파티에 진실을 알고 있는 사람이
 *          있을 경우 거짓말이 들통 날 수도 있다.
 *          이럴 경우 최대로 거짓말을 할 수 있는 사람은 몇 사람인가?
 * 시간 복잡도: 파티에 참석하는 모든 사람이 아는 사람일 경우, 파티 횟수
 *           O(파티 횟수 * 파티에 참석하는 모든 사람)
 */
public class Pro1043 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, t;
    static int[] times;
    static int[][] arr;
    static ArrayList<Integer>[] adj;
    static boolean flag;
    static boolean[] visit;
    static ArrayList<Integer> true_adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++)
            adj[i] = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            int tmp = Integer.parseInt(st.nextToken()) - 1;
            true_adj.add(tmp);
        }
        pro();
    }

    private static void pro() throws IOException {
        times = new int[M];
        arr = new int[M][];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            arr[i] = new int[times[i]];
            arr[i][0] = Integer.parseInt(st.nextToken()) - 1;
            for (int j = 1; j < times[i]; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) - 1;
                if (!adj[arr[i][0]].contains(arr[i][j])) {
                    adj[arr[i][0]].add(arr[i][j]);
                    adj[arr[i][j]].add(arr[i][0]);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            visit = new boolean[N];
            flag = false;
            for (int j = 0; j < times[i]; j++) {
                if (!visit[arr[i][j]] && !flag) {
                    int tmp = arr[i][j];
                    dfs(arr[i][j]);
                }
            }
            if (flag)
                continue;
            cnt++;
        }
        System.out.println(cnt);
    }

    private static void dfs(int x) {
        visit[x] = true;
        for (int cmp : true_adj) {
            if (cmp == x) {
                flag = true;
                return;
            }
        }
        if (flag)
            return;
        for (int y : adj[x]) {
            if (visit[y])
                continue;
            dfs(y);
        }
    }
}
