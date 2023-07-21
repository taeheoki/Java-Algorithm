package src.week_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 18513 - 샘터
 */
public class Pro18513 {
    public static final int RANGE = 100000000;
    static int N, K;
    static int[] dirs = {1, -1};
    static long res;
    static Set<Integer> arr = new HashSet<>();
    static Queue<Integer> que = new LinkedList();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken()) ;
            que.add(tmp);
            arr.add(tmp);
        }
        bfs();
    }

    private static void bfs() {
        int cnt = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int x = que.poll();
                for (int dir : dirs) {
                    int nx = x + dir;
                    if (arr.contains(nx))
                        continue;
                    arr.add(nx);
                    que.add(nx);
                    res += cnt;
                    if (K-- == 1) {
                        System.out.println(res);
                        System.exit(0);
                    }
                }
            }
        }
    }
}
