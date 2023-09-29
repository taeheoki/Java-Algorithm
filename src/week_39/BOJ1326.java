package src.week_39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 1326 - 폴짝폴짝
 */
public class BOJ1326 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    private static final int LIMIT = 10000;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (a == b) {
            System.out.println(0);
            return;
        }

        boolean[] v = new boolean[LIMIT+1];
        Queue<int[]> q = new ArrayDeque<>();
        v[a] = true;
        q.add(new int[]{a, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int num = arr[cur[0]];
            int next = cur[0];

            while (true) {
                next += num;
                if (next > n) break;
                if (v[next]) continue;
                v[next] = true;

                if (next == b) {
                    System.out.println(cur[1] + 1);
                    return;
                }
                q.add(new int[]{next, cur[1]+1});
            }

            next = cur[0];
            while (true) {
                next -= num;
                if (next < 1) break;
                if (v[next]) continue;
                v[next] = true;

                if (next == b) {
                    System.out.println(cur[1] + 1);
                    return;
                }

                q.add(new int[]{next, cur[1]+1});
            }

        }
        System.out.println(-1);
    }
}
