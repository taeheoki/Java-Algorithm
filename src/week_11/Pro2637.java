package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 2637 - 장난감 조립
 * 문제 이해:
 */
public class Pro2637 {
    static StringBuilder sb = new StringBuilder();
    static int N, M, X, Y, K;
    static int[] indeg, part;
    static int[][] required_part;
    static ArrayList<Integer>[] adj;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        part = new int[N + 1];
        indeg = new int[N + 1];
        required_part = new int[N + 1][N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            required_part[X][Y] = K;
            adj[X].add(Y);
            indeg[Y]++;
        }
        pro();
    }

    private static void pro() {
        ArrayList<Integer> base_part = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
                part[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (adj[x].isEmpty()) {
                base_part.add(x);
            }
            for (int y : adj[x]) {
                indeg[y]--;
                part[y] += required_part[x][y] * part[x];
                if (indeg[y] == 0)
                    queue.add(y);
            }
        }

        Collections.sort(base_part);
        for (int i = 1; i <= N; i++) {
            if (base_part.contains(i)) {
                sb.append(i).append(' ').append(part[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}
