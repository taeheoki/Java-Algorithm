package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 2668 - 숫자 고르기
 * 문제 이해: N개의 칸으로 이루어진 표가 있을 때, from 정점과 to 정점이
 *					결과적으로 연결되어 있는 경우를 찾아보자
 * 시간 복잡도: N개의 정점에서 N개의 정점으로 가는 경우를 조회
 *           O(N^2)
 */
public class Pro2668 {

    static int N;
    static ArrayList<Integer>[] adj;
    static Set<Integer> set = new TreeSet<>();
    static boolean[] visit, check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int from = 1; from <= N; from++) {
            int to = Integer.parseInt(br.readLine());
            adj[from].add(to);
        }
        pro();
    }

    private static void pro() {
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (visit[i])
                continue;
            bfs(i);
        }
        System.out.println(set.size());
        set.stream().forEach(s -> System.out.println(s));
    }

    private static void bfs(int start) {
        check = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : adj[cur]) {
                if (start == next) {
                    for (int j = 1; j <= N; j++)
                        if (check[j]) {
                            visit[j] = true;
                            set.add(j);
                        }
                    continue;
                }
                if (visit[next])
                    continue;
                if (check[next])
                    continue;
                queue.offer(next);
                check[next] = true;
            }
        }
    }
}