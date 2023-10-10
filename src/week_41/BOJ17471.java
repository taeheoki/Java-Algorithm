package src.week_41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 17471 - 게리맨더링
 */
public class BOJ17471 {
    static int N, res = Integer.MAX_VALUE;
    static int[] population, area;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        init();
        pro();
    }

    private static void pro() {
        dfs(0);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    private static void dfs(int num) {
        if (num == N + 1) {
            // 두 영역으로 전부 나누어 지는지 확인, 나누어 질 경우 두 영역의 인구차의 최솟값을 구하는 로직

        }

        area[num] = 1;
        dfs(num + 1);
        area[num] = 2;
        dfs(num + 1);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            adj[i] = new ArrayList<>();
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                adj[i].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }
        area = new int[N];
    }
}
