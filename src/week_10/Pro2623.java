package src.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * BOJ 2623 - 음악프로그램
 * 문제 이해: 보조 PD가 정한 순서를 토대로 남일이가 이 순서들을 모아서 전체 가수의 순서를 정하는 일이다.
 *          보조 PD가 정한 순서에 따라 전체 순서를 정할수 있을 때가 있고, 불가능 할 경우가 있는데,
 *          순서를 정할 수 있을 때 순서대로 출력하고, 불가능 하다면 '0'을 출력하라.
 * 시간 복잡도: O(ElogV)
 */
public class Pro2623 {
    static StringBuilder sb = new StringBuilder();
    static int N, M, cnt;
    static int[] indeg;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indeg = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int pre = 0;
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                adj[pre].add(tmp);
                if (pre != 0)
                    indeg[tmp]++;
                pre = tmp;
            }
        }
        pro();
        if (cnt == N)
            System.out.println(sb);
        else
            System.out.println(0);
    }

    private static void pro() {
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append('\n');
            cnt++;
            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0)
                    queue.add(y);
            }
        }
    }
}
