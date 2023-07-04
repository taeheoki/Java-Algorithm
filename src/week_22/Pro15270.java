package src.week_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 15270 - 친구 팰린드롬
 */
public class Pro15270 {
    static int N, M, res;
    static int[][] friends;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friends = new int[M][2];
        visit = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            friends[i][0] = Integer.parseInt(st.nextToken());
            friends[i][1] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        dfs(0, 0);

        res *= 2;
        if (res < N) {
            res++;
        }

        System.out.println(res);
    }

    private static void dfs(int index, int count) {
        if (index >= M) {
            res = Math.max(res, count);
            return;
        }
        if (visit[friends[index][0]] || visit[friends[index][1]]) {
            dfs(index + 1, count);
        } else {
            visit[friends[index][0]] = true;
            visit[friends[index][1]] = true;

            dfs(index + 1, count + 1);

            visit[friends[index][0]] = false;
            visit[friends[index][1]] = false;

            dfs(index + 1, count);
        }
    }
}
