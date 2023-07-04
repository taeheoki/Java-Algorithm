package src.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 2412 - 암벽 등반
 */
public class Pro2412 {
    static int n, T;
    static ArrayList<ArrayList<Elem>> elems = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= T; i++) {
            elems.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            elems.get(y).add(new Elem(x, y, 0));
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Elem> que = new LinkedList<>();
        que.add(new Elem(0, 0, 0));

        while (!que.isEmpty()) {
            Elem cur = que.poll();
            if (cur.y == T)
                return cur.cnt;

            for (int i = - 2; i <= 2; i++) {
                int ny = cur.y + i;

                if (ny < 0 || ny > T)
                    continue;

                for (int j = 0; j < elems.get(ny).size(); j++) {
                    Elem elem = elems.get(ny).get(j);

                    if (Math.abs(elem.x - cur.x) > 2 || elem.cnt > 0)
                        continue;
                    que.add(elem);
                    elem.cnt = cur.cnt + 1;
                }
            }
        }
        return -1;
    }

    private static class Elem {
        int x;
        int y;
        int cnt;

        public Elem(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
