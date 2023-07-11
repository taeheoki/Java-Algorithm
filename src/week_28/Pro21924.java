package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 21924 - 도시 건설
 */
public class Pro21924 {
    static int N, M;
    static int[] parent;
    static long max;
    static PriorityQueue<Elem> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Elem(from, to, weight));
            max += weight;
        }
        pro();
    }

    private static void pro() {
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        long sum = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Elem e = pq.poll();
            if (find(e.from) != find(e.to)) {
                sum += e.weight;
                union((e.from), e.to);
                cnt++;
            }
        }
        System.out.println(cnt == N - 1 ? max - sum : -1);
    }

    private static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (parA > parB) {
            parent[parA] = parB;
        } else {
            parent[parB] = parA;
        }
    }

    private static class Elem {
        int from;
        int to;
        int weight;

        public Elem(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
