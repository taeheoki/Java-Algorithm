package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 2458 - 키 순서
 */
public class Pro2458 {
    static int N, M;
    static boolean[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            dist[a][b] = true;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][k] && dist[k][j])
                        dist[i][j] = true;
                }
            }
        }

        int[] cnt = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dist[i][j] || dist[j][i])
                    cnt[i]++;
            }
        }

        int res = 0;
        for (int i : cnt) {
            if (i == N - 1)
                res++;
        }
        System.out.println(res);
    }
}
