package src.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * BOJ 2606 - 바이러스
 * 문제 이해:
 */
public class Pro2606 {
    static int C, N, cnt;
    static ArrayList<Integer> arr[];
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());
        arr = new ArrayList[C];
        for (int i = 0; i < C; i++) {
            arr[i] = new ArrayList<>();
        }
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int connect = Integer.parseInt(st.nextToken());
            arr[index - 1].add(connect - 1);
            arr[connect - 1].add(index - 1);
        }
        pro();
    }

    private static void pro() {
        visit = new boolean[C];
        dfs(0);
        System.out.println(cnt);
    }

    private static void dfs(int x) {
        visit[x] = true;

        for (int y : arr[x]) {
            if (visit[y])
                continue;
            dfs(y);
            cnt++;
        }
    }
}
