package src.week_41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
        if (num == N) {
            // 두 영역으로 전부 나누어 지는지 확인, 나누어 질 경우 두 영역의 인구차의 최솟값을 구하는 로직
            ArrayList<Integer> area1 = new ArrayList<>();
            ArrayList<Integer> area2 = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (area[i] == 1) area1.add(i);
                else if (area[i] == 2) area2.add(i);
            }

            // 각각의 구역이 연결되어있다면 인구차 계산
            if ((area1.size() != 0 && isConnected(area1)) &&
                    (area2.size() != 0 && isConnected(area2))) {

                int sumArea1 = sumPopulation(area1);
                int sumArea2 = sumPopulation(area2);

                res = Math.min(res, Math.abs(sumArea1 - sumArea2));
            }
            return;
        }

        area[num] = 1;
        dfs(num + 1);
        area[num] = 2;
        dfs(num + 1);
    }

    private static boolean isConnected(ArrayList<Integer> list) {
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();

        q.offer(list.get(0));

        while (!q.isEmpty()) {
            int currentCity= q.poll();
            visited[currentCity] = true;

            for(int nextCity: adj[currentCity]) {
                if(!visited[nextCity] && list.contains(nextCity)) {
                    visited[nextCity]=true;
                    q.offer(nextCity);
                }
            }
        }

        for(int city: list)
            if(!visited[city]) return false;

        return true;
    }

    private static int sumPopulation(ArrayList<Integer> list) {
        int sum = 0;
        for (int city: list) {
            sum += population[city];
        }
        return sum;
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
